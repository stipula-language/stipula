package lib;

import ast.*;

public class StipulaLib {
  
	private static int labCount=0; 
  
	private static int funLabCount=0; 

	private static String funCode="";

	public static boolean isSubtype (Node asm, Node var) {
    
		if((var instanceof RealTypeNode && asm instanceof AssetTypeNode) || (asm instanceof RealTypeNode && var instanceof AssetTypeNode)) {
			return true;
		}
    
		return asm.getClass().equals(var.getClass()) || ( (asm instanceof BoolTypeNode) && (var instanceof IntTypeNode) );
	}
  
	public static String freshLabel() { 
		return "label"+(labCount++);
	} 

	public static String freshFunLabel() { 
		return "function"+(funLabCount++);
	} 
  
	public static void putCode(String c) { 
		funCode+="\n"+c; //aggiunge una linea vuota di separazione prima di funzione
	} 
  
	public static String getCode() { 
		return funCode;
	} 

}