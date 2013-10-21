package visitor;
import java.util.HashMap;

public class ClassBinding {
	public HashMap<String, VarType> fields;
	public HashMap<String,MethodBinding> methods;
	//For when this class extends another class, 
	public ClassBinding parentBinding;
	
	public ClassBinding() {
		fields = new HashMap<String,VarType>();
		methods = new HashMap<String,MethodBinding>();
	}
}
