
import syntaxtree.*;
import visitor.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main {
   public static void main(String [] args) {
      try {
    	 Node root;
    	 if(args.length == 1) {
    		FileInputStream stream = new FileInputStream(args[0]); 
    		root = new MiniJavaParser(stream).Goal();
    	 } else {
            root = new MiniJavaParser(System.in).Goal();
    	 }
         System.out.println("Program parsed successfully");
         //PrintSubtreeVisitor visitor = new PrintSubtreeVisitor();
         SymbolTableVisitor symVisitor = new SymbolTableVisitor();
         
         //String subtree = root.accept(visitor,new Integer(0));
         //System.out.println(subtree);
         
         //Create the symbol table
         root.accept(symVisitor);
         //Typecheck
         System.out.println(symVisitor.tableSuccessfullyCreated);
         TypeChecker typeCheckVisitor = new TypeChecker(symVisitor.table);
         Boolean didTypecheck = root.accept(typeCheckVisitor);
         System.out.println("Did typecheck:" + didTypecheck.toString());
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
