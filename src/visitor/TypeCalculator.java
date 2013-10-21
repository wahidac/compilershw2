package visitor;

import java.util.ArrayList;
import java.util.HashMap;

import syntaxtree.*;

//Visitor to return the type and expression would return.
//Return null if an expression will not type check. Return
//an array of types because an identifier may potentially
//have different types, and based on what kind of expression
//the types is being used in, we'll have to infer which
//binding to use
public class TypeCalculator extends GJDepthFirst<VarType, HashMap<String, ClassBinding>>  {
	public ClassBinding currentClassBinding;
	public MethodBinding currentMethodBinding;	

	//public returnDesiredVarType(VariableType.)
	
	/**
	    * f0 -> AndExpression()
	    *       | CompareExpression()
	    *       | PlusExpression()
	    *       | MinusExpression()
	    *       | TimesExpression()
	    *       | ArrayLookup()
	    *       | ArrayLength()
	    *       | MessageSend()
	    *       | PrimaryExpression()
	    */
	   public VarType[] visit(Expression n, HashMap<String, ClassBinding> symbolTable) {
	      return n.f0.accept(this, symbolTable);
	    
	   }
	   
	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "&&"
	    * f2 -> PrimaryExpression()
	    */
	   public VarType visit(AndExpression n, HashMap<String, ClassBinding> symbolTable) {
		   	  VarType b1 = n.f0.accept(this, symbolTable);
		   	  VarType b2 = n.f2.accept(this, symbolTable);
		   	  if(b1.type == VariableType.BOOLEAN && b2.type == VariableType.BOOLEAN)
		   		  return new VarType(VariableType.BOOLEAN);
		   	  else
		   		  return null;
		}
	   
	   
	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "<"
	    * f2 -> PrimaryExpression()
	    */
	   public VarType visit(CompareExpression n, HashMap<String, ClassBinding> symbolTable) {
		   	  VarType b1 = n.f0.accept(this, symbolTable);
		   	  VarType b2 = n.f2.accept(this, symbolTable);
		   	  if(b1.type == VariableType.INTEGER && b2.type == VariableType.INTEGER)
		   		  return new VarType(VariableType.BOOLEAN);
		   	  else
		   		  return null;
		}
		   
		   	   
	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "+"
	    * f2 -> PrimaryExpression()
	    */
	   public VarType visit(PlusExpression n, HashMap<String, ClassBinding> symbolTable) {
		   	  VarType b1 = n.f0.accept(this, symbolTable);
		   	  VarType b2 = n.f2.accept(this, symbolTable);
		   	  if(b1.type == VariableType.INTEGER && b2.type == VariableType.INTEGER)
		   		  return new VarType(VariableType.INTEGER);
		   	  else
		   		  return null;
		}

	   
	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "-"
	    * f2 -> PrimaryExpression()
	    */
	   public VarType visit(MinusExpression n, HashMap<String, ClassBinding> symbolTable) {
		   	  VarType b1 = n.f0.accept(this, symbolTable);
		   	  VarType b2 = n.f2.accept(this, symbolTable);
		   	  if(b1.type == VariableType.INTEGER && b2.type == VariableType.INTEGER)
		   		  return new VarType(VariableType.INTEGER);
		   	  else
		   		  return null;
		}
	   
	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "*"
	    * f2 -> PrimaryExpression()
	    */
	   public VarType visit(TimesExpression n, HashMap<String, ClassBinding> symbolTable) {
		   	  VarType b1 = n.f0.accept(this, symbolTable);
		   	  VarType b2 = n.f2.accept(this, symbolTable);
		   	  if(b1.type == VariableType.INTEGER && b2.type == VariableType.INTEGER)
		   		  return new VarType(VariableType.INTEGER);
		   	  else
		   		  return null;
		}
	   
	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "["
	    * f2 -> PrimaryExpression()
	    * f3 -> "]"
	    */
	   public VarType visit(ArrayLookup n, HashMap<String, ClassBinding> symbolTable) {
		   	  VarType b1 = n.f0.accept(this, symbolTable);
		   	  VarType b2 = n.f2.accept(this, symbolTable);
		   	  if(b1.type == VariableType.INT_ARRAY && b2.type == VariableType.INTEGER)
		   		  return new VarType(VariableType.INTEGER);
		   	  else
		   		  return null;
		}
	   
	   /**
	    * f0 -> PrimaryExpression()
	    * f1 -> "."
	    * f2 -> Identifier()
	    * f3 -> "("
	    * f4 -> ( ExpressionList() )?
	    * f5 -> ")"
	    */
	   public VarType visit(MessageSend n, HashMap<String, ClassBinding> symbolTable) {
		   	 //f0 must be a class.
		   	  VarType object = n.f0.accept(this,symbolTable);
		   	  
		   	  if(object.type != VariableType.CLASS)
		   		  return null;
		   	  
		   	  //f2 must be a method in the class given by f0, verify this
		   	  //Return class designated by f0
		   	  String identifier = object.className;
		   	  assert(!identifier.isEmpty());
		   	  ClassBinding c = symbolTable.get(identifier);
		   	  assert(c != null);
		   	  
		   	  String method = SymbolTableVisitor.identifierForIdentifierNode(n.f2);
		   	  MethodBinding m = c.methods.get(method);
		   	  if(m == null) {
		   		  //No method!!!
		   		  return null;
		   	  }
		   	  
		   	  VarType returnType = m.returnValue;
		   	  
		   	  //Visit expression list to make sure everything there type checks w/ what is expected as input
		   	  //to the method
		   	  n.f4.accept(this,symbolTable);   	  
		   	  return returnType;
		}
	   
	   
	    
	   
	   
	   /**
	    * f0 -> IntegerLiteral()
	    *       | TrueLiteral()
	    *       | FalseLiteral()
	    *       | Identifier()
	    *       | ThisExpression()
	    *       | ArrayAllocationExpression()
	    *       | AllocationExpression()
	    *       | NotExpression()
	    *       | BracketExpression()
	    */
	   public VarType visit(PrimaryExpression n, HashMap<String, ClassBinding> symbolTable) {
		   return n.f0.choice.accept(this, symbolTable);
	   }
	   
	   /**
	    * f0 -> <INTEGER_LITERAL>
	    */
	   public VarType visit(IntegerLiteral n, HashMap<String, ClassBinding> symbolTable) {
		   return new VarType(VariableType.INTEGER);
	   }
	   
	   /**
	    * f0 -> "true"
	    */
	   public VarType visit(TrueLiteral n, HashMap<String, ClassBinding> symbolTable) {
		   return new VarType(VariableType.BOOLEAN);
	   }
	   
	   
	   /**
	    * f0 -> "false"
	    */
	   public VarType visit(FalseLiteral n, HashMap<String, ClassBinding> symbolTable) {
		   return new VarType(VariableType.BOOLEAN);
	   }
	   
	   
	   public VarType returnDesiredTypeFromArrayOfTypes(VarType[] types)
	   
	   
	   /**
	    * f0 -> <IDENTIFIER>
	    */
	   public VarType visit(Identifier n, HashMap<String, ClassBinding> symbolTable) {
		   //Need to consult symbol table for type. 
		   VarType v = null;
		   //Check local variable declarations, which take priority over class declarations.
		   //If we find the mapping in the method dec, don't look at the class fields.
		   v = currentMethodBinding.locals.get(n);
		   if(v == null) {
			   v = currentMethodBinding.parameters.get(n);		
		   }
		   if(v == null) {
			   v = currentClassBinding.fields.get(n);
		   }
		   
		   return v;
	   }
	   
	   /**
	    * f0 -> "this"
	    */
	   public R visit(ThisExpression n, A argu) {
	      R _ret=null;
	      n.f0.accept(this, argu);
	      return _ret;
	   }
	
	
}
