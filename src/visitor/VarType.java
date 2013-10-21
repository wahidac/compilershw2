package visitor;
import java.util.ArrayList;


public class VarType {
	//Represent class hierarchies w/ tree structure
	public ArrayList<VarType> children; 
	public VariableType type;
	//Class name if there is one
	public String className;
	
	public VarType(VariableType type) {
		this.type = type;
	}
	
	public VarType(VariableType type, String className) {
		this.type = type;
		this.className = className;
	}
}
