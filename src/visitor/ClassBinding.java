package visitor;
import java.util.HashMap;

public class ClassBinding {
	private HashMap<String, VarType> fields;
	private HashMap<String,MethodBinding> methods;
	//For when this class extends another class, 
	public String parentClass;
	
	public ClassBinding() {
		fields = new HashMap<String,VarType>();
		methods = new HashMap<String,MethodBinding>();
		parentClass = "";
	}
	
	//Return method binding, considering super-classes if they exist
	public MethodBinding getMethodBinding(String id, HashMap<String,ClassBinding> symbolTable) {
		//Look through the hierarchy to find the binding
		MethodBinding m = methods.get(id);
		if(m == null && !this.parentClass.isEmpty()) {
				ClassBinding c = symbolTable.get(this.parentClass);
				m = c.getMethodBinding(id, symbolTable);
				return m;
		}
		
		return m;
	}
	
	//Return method binding, considering super-classes if they exist
	public VarType getField(String id, HashMap<String,ClassBinding> symbolTable) {
			//Look through the hierarchy to find the field, returning the first one found.
			VarType v = fields.get(id);
			if(v == null && !this.parentClass.isEmpty()) {
					ClassBinding c = symbolTable.get(this.parentClass);
					v= c.getField(id, symbolTable);
					return v;
			}
			
			return v;
	} 
	
	public boolean hasAncestor(String ancestorId, HashMap<String,ClassBinding> symbolTable) {
		//Is there an ancestor w/ the name ancestorId?
		if(parentClass.isEmpty())
			return false;
		
		if(parentClass.equals(ancestorId))
			return true;
		else {
			ClassBinding c = symbolTable.get(this.parentClass);
			return c.hasAncestor(ancestorId, symbolTable);
		}
		
	}
	
	public HashMap<String,MethodBinding> getMethodBindings() {
		return methods;
	}
	
	public HashMap<String,VarType> getFields() {
		return fields;
	}
	
}
