package util;

import java.util.ArrayList;
import java.util.HashMap;

import ast.Node;
import ast.STentry;

public class Environment {
	
	public ArrayList<HashMap<Node,Node>>  envs = new ArrayList<HashMap<Node,Node>>();
	
	public ArrayList<HashMap<Node,Node>> getEnvironments(){
		return envs;
	}
	
	
	
}
