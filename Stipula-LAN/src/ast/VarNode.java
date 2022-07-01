package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public class VarNode implements Node {

	private String id;
	private Node exp;
	private Node type ;
  
	//var declaration without initialization
	public VarNode (Node i, Node t) {
		id=i.toVisit();
		exp=null;
		type = t;
	}
	
	public VarNode (String i, Node t) {
		id=i;
		exp=null;
		type = t;
	}
  
	public VarNode (String i, Node v, Node t) {
		id=i;
		exp=v;
		type = t;
	}

	@Override
	public String toPrint(String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node typeCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toVisit() {
		return id;
	}
/*
	@Override
	public HashMap<String, STentry> genTypes(Environment env) {
		//create result list
  	  	ArrayList<SemanticError> res = new ArrayList<SemanticError>();
  	  
  	    HashMap<String,STentry> hm = env.symTable.get(env.nestingLevel);
  	    STentry entry = new STentry(env.nestingLevel,type, env.offset--); //separo introducendo "entry"
  	  
  	   	
        
  	    if ( hm.put(id,entry) != null )
  	    	res.add(new SemanticError("Var id "+id+" already declared"));
  	  
  	    // if exp == null, var declaration without initialization
  	    if (exp != null)
  	    	hm.putAll(exp.genTypes(env));
        
  	    return hm;
	}*/

	@Override
	public Node getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public SymbolTableStack genTypes(int scope) {
		SymbolTableStack ret = new SymbolTableStack();
		ret.createScope(scope);
		if(exp==null) {
			ret.add(this.type.toVisit(), this.id);
		}
		else {
			ret.add(this.id,this.type.toVisit(),this.exp.toVisit()); // SISTEMARE
		}
		return ret;
	}

	@Override
	public void setType(Node t) {
		this.type = t;
		
	}

  
}