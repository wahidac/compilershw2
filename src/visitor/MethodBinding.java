package visitor;
import java.util.ArrayList;
import java.util.HashMap;


public class MethodBinding  {
	public VarType returnValue;
	public HashMap<String, VarType> parameters;
	public HashMap<String, VarType> locals;
	
	public MethodBinding() {
		parameters = new HashMap<String,VarType>();
		locals = new HashMap<String,VarType>();
	}
}
