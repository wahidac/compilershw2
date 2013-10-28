package visitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class MethodBinding  {
	public VarType returnValue;
	public LinkedHashMap<String, VarType> parameters;
	public HashMap<String, VarType> locals;
	
	public MethodBinding() {
		parameters = new LinkedHashMap<String,VarType>();
		locals = new HashMap<String,VarType>();
	}
}
