package visitor;
import java.util.ArrayList;


public class VarType {
	//Represent class hierarchies w/ list structure
	public ArrayList<VarType> parents; 
	public VariableType type;
	//Class name if there is one
	public String className;
	
	public VarType(VariableType type) {
		this.type = type;
		this.parents = new ArrayList<VarType>();
	}
	
	public VarType(VariableType type, String className) {
		this.type = type;
		this.className = className;
		this.parents = new ArrayList<VarType>();
	}
	
	//Check to see whether legal to assign a var of type v2 to one of v1
    public static boolean canAssignVarType(VarType v1, VarType v2) {
    	 boolean ret = false;
    	 
    	 if(v1 == null || v2 == null)
    		 return false;
    	 
    	 
    	 if(v1.type == VariableType.CLASS && v2.type == VariableType.CLASS) {
    		 //Return if v1 is equal to v2 or if v1 is a subclass of v2
    		 if(v1.className.equals(v2.className))
    			 ret = true;
    		 else {
    			 //Check parents if any. Return true if v1 as an ancestor of  v2 
    			 for(VarType p:v2.parents) {
    			     if(v1.className.equals(v2.className)) {
    	    			 ret = true;
    			         break;
    			     }   
    			 }
    		 }
	      } else {
	    	  ret = (v1.type == v2.type);
	      }
    	 return ret;
		
	}
		
}
