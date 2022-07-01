package ast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Stack;
import java.io.IOException;

public class SymbolTableStack {
	public static Stack<SymbolTable> stack = new Stack<SymbolTable>();
	private static int blockCount = 1;
	private static int size = 0;
	
	public static void createScope(int scope) {
		
			stack.push(new SymbolTable(scope));
		
	}

	public static void add(SymbolTable add) {
		SymbolTable currTable = stack.pop();
		LinkedHashMap<String, Symbol>  toAdd = add.getEntryMap();
		Iterator<Symbol> it = toAdd.values().iterator();
		while(it.hasNext()) {
			Symbol currSymbol = it.next();
			Symbol sb = new Symbol(currSymbol.getName(), currSymbol.getType(), currSymbol.getValue());
			currTable.addEntry(sb);
		}
		stack.push(currTable);
	}
	
	public static void add(String inputType, String inputName) {
		String[] nameList = inputName.trim().split(",");
		SymbolTable currTable = stack.pop();
		for (int i = 0; i < nameList.length; i++) {
			Symbol sb = new Symbol(nameList[i], inputType, null);
			currTable.addEntry(sb);
		}
		stack.push(currTable);
	}

	
	
	public static void add(String inputName, String inputType, String inputValue) {
		SymbolTable currTable = stack.pop();
		Symbol sb = new Symbol(inputName, inputType, inputValue);
		currTable.addEntry(sb);
		stack.push(currTable);
	}

	public int getSize() {
		return stack.size();
	}
	
	public SymbolTable get(int i) {
		return stack.get(i);
	}
	
	public void toVisit() {
		Object[] vals = stack.toArray();
	    for (Object obj : vals) {
	        ((SymbolTable) obj).printSymbolTable();
	    }
	}
	
}
