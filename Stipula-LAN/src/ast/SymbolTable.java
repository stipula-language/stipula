package ast;

import java.util.LinkedHashMap;
import java.util.Iterator;
import java.io.IOException;

public class SymbolTable {
	private int scope;
	private LinkedHashMap<String, Symbol> entryMap;

	public SymbolTable(int inputScope) {
		this.scope = inputScope;
		this.entryMap = new LinkedHashMap<String, Symbol>();
	}

	public int getScope() {
		return this.scope;
	}

	public LinkedHashMap<String, Symbol> getEntryMap() {
		return this.entryMap;
	}

	public void addEntry(Symbol entry) {
		/*if(this.entryMap.containsKey(entry.getName())) {
			System.out.println("DECLARATION ERROR " + entry.getName() + entry.getType());
			System.exit(0);
		} else {*/
			this.entryMap.put(entry.getName(), entry);
		/*}*/
	}

	public boolean thereIsEntry(Symbol entry) {
		boolean thereIs = false;
		if(this.entryMap.containsKey(entry.getName())) {
			thereIs = true;
		} 
		return thereIs;
	}
	
	public void printSymbolTable() {
		System.out.println("Symbol table " +  this.scope);
		Iterator<Symbol> it = this.entryMap.values().iterator();
		while(it.hasNext()) {
			Symbol currSymbol = it.next();
			if(currSymbol.getType() == "STRING") {
				System.out.println("name: " + currSymbol.getName() + " -> " + currSymbol.getType() + " -> " + currSymbol.getValue());
			} else {
				System.out.println("name " + currSymbol.getName() + " -> " + currSymbol.getType());
			}
		}
		System.out.println();
	}
	
}