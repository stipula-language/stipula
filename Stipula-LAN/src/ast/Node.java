package ast;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;
import util.Environment;
import util.SemanticError;

public interface Node {
	
  
  String toPrint(String indent);

  Node typeCheck();
  
  String toVisit();
  
  SymbolTableStack genTypes(int scope);

  Node getType();
  
  void setType(Node t);
  
  
  
}  