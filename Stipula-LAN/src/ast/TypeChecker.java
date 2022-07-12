package ast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import lib.Pair;
import parser.StipulaBaseVisitor;
import parser.StipulaParser.*;

public class TypeChecker extends StipulaBaseVisitor<Object> {
	int n_types = 0;
	Map<Pair<String,Integer>,Type> types = null;
	int n_scope = 0	;
	ArrayList<String> contractNames = null;
	ArrayList<String> parties = null;

	ArrayList<Pair<String,ArrayList<Pair<String,Type>>>> funParams = new ArrayList<Pair<String,ArrayList<Pair<String,Type>>>>();

	public ArrayList<String> getNames(){
		return contractNames;
	}

	public void print_map(){
		for(Pair<String,Integer> s: types.keySet()) {
			System.out.print("var: " + s.getKey() +" type: " + types.get(s).getTypeName() );
			if(s.getValue()>0) {
				int toPrint = Integer.valueOf(s.getValue())-1;
				System.out.println("function#" + toPrint);
			}
		}
	}

	public void print_map(Map<Pair<String,Integer>,Type> map){
		for(Pair<String,Integer> s: map.keySet()) {
			System.out.println("var: " + s.getKey() +" type: " + map.get(s).getTypeName() + " scope: " + s.getValue());
		}
	}

	public ArrayList<Pair<String,ArrayList<Pair<String,Type>>>> getFunParams() {
		return funParams;
	}

	public Map<Pair<String,Integer>,Type> setType(Pair<String,Integer> pair, Type type, Map<Pair<String,Integer>,Type> map){
		for(Pair<String,Integer> s : map.keySet()) {
			if(s.equals(pair)) {
				map.put(pair,type);
			}
		}
		return map;
	}

	public void addElementsMap(Map<Pair<String,Integer>,Type> toRet) {
		for(Pair<String,Integer> s : toRet.keySet()) {
			if(!isPresent(s,types)){
				types.put(s,toRet.get(s));
			}
			else {
				Type tmpType = getType(s,types);
				if(tmpType == null || (!(tmpType instanceof RealType) && !(tmpType instanceof BooleanType) && !(tmpType instanceof AssetType) && !(tmpType instanceof TimeType))) {
					for(Entry<Pair<String, Integer>, Type> entry : types.entrySet()) {
						if(entry.getKey().getKey().equals(s.getKey())) {
							entry.setValue(toRet.get(s));
						}
					}
				}
			}
		}
	}

	public boolean isPresent(Pair<String,Integer> pair, Map<Pair<String,Integer>,Type> type){
		boolean present = false;
		for(Pair<String,Integer> s : type.keySet()) {
			if(s.getKey().equals(pair.getKey())  && (s.getValue()==0 || s.getValue()==pair.getValue())) {
				present = true;
			}
		}
		return present;
	}

	public Type getType(Pair<String,Integer> pair, Map<Pair<String,Integer>,Type> type){
		Type toRet = null;
		for(Pair<String,Integer> s : type.keySet()) {
			if(s.getKey().equals(pair.getKey()) && (s.getValue()==0 || s.getValue()==pair.getValue())) {
				toRet = type.get(s);
			}
		}
		return toRet;
	}

	public Map<Pair<String,Integer>,Type> visitProg(ProgContext ctx) {
		types = new LinkedHashMap<Pair<String,Integer>,Type>();
		parties = visitAgreement(ctx.agreement());
		if(ctx.assetdecl()!=null) {
			Map<Pair<String,Integer>,Type> tmpAssets = new LinkedHashMap<Pair<String,Integer>,Type>();
			tmpAssets = visitAssetdecl(ctx.assetdecl());
			for(Pair<String,Integer> el : tmpAssets.keySet()) {
				types.put(el,tmpAssets.get(el));
			}
		}
		if(ctx.fielddecl()!=null) {
			Map<Pair<String,Integer>,Type> tmpFields = new LinkedHashMap<Pair<String,Integer>,Type>();
			tmpFields = visitFielddecl(ctx.fielddecl());
			for(Pair<String,Integer> el : tmpFields.keySet()) {
				types.put(el,tmpFields.get(el));
			}
		}
		/*for(DeclistContext n : ctx.declist()) {
			if(n.type().ASSET()!=null) {
				types.put(new Pair<String, Integer>(n.strings().getText(),n_scope),new AssetType());
			}
			else if(n.type().FIELD()!=null) {
				types.put(new Pair<String, Integer>(n.strings().getText(),n_scope),new GeneralType(n_types));
				n_types++;
			}
			else if(n.type().INTEGER()!=null || n.type().DOUBLE()!=null) {
				types.put(new Pair<String, Integer>(n.strings().getText(),n_scope),new RealType());
			}
			else if(n.type().BOOLEAN()!=null) {
				types.put(new Pair<String, Integer>(n.strings().getText(),n_scope),new BooleanType());
			}
			else if(n.type().STRING()!=null) {
				types.put(new Pair<String, Integer>(n.strings().getText(),n_scope),new StringType());
			}
		}*/
		for(FunContext f : ctx.fun()) {
			Map<Pair<String,Integer>,Type> tmp = visitFun(f);
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(!isPresent(s,types)){
					types.put(s,tmp.get(s));
				}
				else {
					Type tmpType = getType(s,types);
					if(tmpType == null || (!(tmpType instanceof RealType) && !(tmpType instanceof BooleanType) && !(tmpType instanceof AssetType) && !(tmpType instanceof TimeType))) {
						for(Entry<Pair<String, Integer>, Type> entry : types.entrySet()) {
							if(entry.getKey().getKey().equals(s.getKey())) {
								entry.setValue(tmp.get(s));
							}
						}
					}
				}
			}
			if(contractNames == null) {
				contractNames = new ArrayList<String>();
			}
			String name = "";
			for(PartyContext dc : f.party()) {
				name = name+dc.ID().getText();
			}
			name = name+"."+f.ID().getText();
			contractNames.add(name);
		}
		return types;
	}

	public Map<Pair<String,Integer>,Type> visitAssetdecl(AssetdeclContext ctx){
		Map<Pair<String,Integer>,Type> retAssets = new LinkedHashMap<Pair<String,Integer>,Type>();
		for(int i=0; i<ctx.idAsset.size(); i++) {
			retAssets.put(new Pair<String, Integer>(ctx.idAsset.get(i).getText(),n_scope),new AssetType());
		}
		return retAssets;
	}

	public Map<Pair<String,Integer>,Type> visitFielddecl(FielddeclContext ctx){
		Map<Pair<String,Integer>,Type> retAssets = new LinkedHashMap<Pair<String,Integer>,Type>();
		for(int i=0; i<ctx.idField.size(); i++) {
			retAssets.put(new Pair<String, Integer>(ctx.idField.get(i).getText(),n_scope),new GeneralType(n_types));
			n_types++;
		}
		return retAssets;
	}

	public ArrayList<String> visitAgreement(AgreementContext ctx) {
		ArrayList<String> toRet = new ArrayList<String>();
		for(PartyContext d : ctx.party()) {
			toRet.add(d.ID().getText());
		}
		return toRet;
	}

	public Map<Pair<String,Integer>,Type> visitFun(FunContext ctx){
		Map<Pair<String,Integer>,Type> toRet = new LinkedHashMap<Pair<String,Integer>,Type>();
		ArrayList<Pair<String,Type>> tmpFuns = new ArrayList<Pair<String,Type>> ();
		n_scope++;
		if(ctx.vardec()!=null) {
			for(VardecContext n : ctx.vardec()) {
				toRet.put(new Pair<String, Integer>(n.ID().getText(),n_scope),new GeneralType(n_types));
				n_types++;
				tmpFuns.add(new Pair<String, Type>(n.ID().getText(),new GeneralType(n_types)));
			}
		}

		if(ctx.assetdec()!=null) {
			for(AssetdecContext n : ctx.assetdec()) {
				toRet.put(new Pair<String, Integer>(n.ID().getText(),n_scope),new AssetType());
				tmpFuns.add(new Pair<String, Type>(n.ID().getText(),new AssetType()));
			}
		}
		funParams.add(new Pair<String, ArrayList<Pair<String, Type>>>(ctx.ID().getText(),tmpFuns));
		addElementsMap(toRet);
		if(ctx.prec()!=null) {
			Map<Pair<String,Integer>,Type> tmp = visitPrec(ctx.prec());
			for(Pair<String,Integer> s : tmp.keySet()) {

				if(!isPresent(s,toRet)){
					toRet.put(s,tmp.get(s));
				}
				else {
					Type tmpType = getType(s,toRet);

					if(tmpType == null || (!(tmpType instanceof RealType) && !(tmpType instanceof BooleanType) && !(tmpType instanceof AssetType) && !(tmpType instanceof TimeType))) {
						for(Entry<Pair<String, Integer>, Type> entry : toRet.entrySet()) {
							if(entry.getKey().getKey().equals(s.getKey())) {
								entry.setValue(tmp.get(s));
							}
						}
					}
				}
			}
		}
		addElementsMap(toRet);

		if(ctx.stat()!=null) {
			for(StatContext sc : ctx.stat()) {
				Map<Pair<String,Integer>,Type> tmp = visitStat(sc);

				for(Pair<String,Integer> s : tmp.keySet()) {
					if(!isPresent(s,toRet)){
						toRet.put(s,tmp.get(s));
					}
					else {
						Type tmpType = getType(s,toRet);					
						if(tmpType == null || (!(tmpType instanceof RealType) && !(tmpType instanceof BooleanType) && !(tmpType instanceof AssetType) && !(tmpType instanceof TimeType))) {
							for(Entry<Pair<String, Integer>, Type> entry : toRet.entrySet()) {
								if(entry.getKey().getKey().equals(s.getKey())) {
									entry.setValue(tmp.get(s));
								}
							}
						}
					}
				}
			}
		}
		addElementsMap(toRet);

		if(ctx.events()!=null) {
			for(EventsContext sc : ctx.events()) {
				if(sc.EMPTY()==null) {
					Map<Pair<String,Integer>,Type> tmp = visitEvents(sc);
					for(Pair<String,Integer> s : tmp.keySet()) {
						if(!isPresent(s,toRet)){
							toRet.put(s,tmp.get(s));
						}
						else {
							Pair<String,Integer> tmpPair = new Pair<String, Integer>(s.getKey(),0);
							toRet.put(tmpPair,tmp.get(s));
						}
					}
				}
			}

		}

		return toRet ;
	}

	public Map<Pair<String,Integer>,Type> visitStat(StatContext ctx){


		Map<Pair<String,Integer>,Type> toRet = new LinkedHashMap<Pair<String,Integer>,Type>();
		if(ctx.ASSETUP()!=null) {
			Map<Pair<String,Integer>,Type> tmp = visitValue(ctx.left);
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(!parties.contains(s.getKey())){
					toRet.put(s,new GeneralType(n_types));
					n_types++;
				}
			} 
			Pair<String,Integer> rightVal = new Pair<String,Integer>(ctx.right.getText(),n_scope);
			//Map<Pair<String,Integer>,Type> tmp1 = visitValue(ctx.right);
			//for(Pair<String,Integer> s : tmp1.keySet()) {
			if(!parties.contains(rightVal.getKey())){
				toRet.put(rightVal,new GeneralType(n_types));
				n_types++;
			}
			//} 
			if(ctx.COMMA()!=null) {
				Pair<String,Integer> rightValPlus = new Pair<String,Integer>(ctx.right.getText(),n_scope);
				if(!parties.contains(rightValPlus.getKey())){
					toRet.put(rightValPlus,new GeneralType(n_types));
					n_types++;
				}
			}
		}
		else if(ctx.FIELDUP()!=null) {
			Map<Pair<String,Integer>,Type> tmp = visitValue(ctx.left);
			Type typeLeft = null;
			for(Pair<String,Integer> s : tmp.keySet()) {

				if(tmp.get(s) instanceof RealType) {
					typeLeft = new RealType();
				}
				else if(tmp.get(s) instanceof BooleanType) {
					typeLeft = new BooleanType();
				}

			} 

			if(typeLeft==null) {
				for(Pair<String,Integer> s : tmp.keySet()) {
					if(getType(s,types) instanceof RealType) {
						typeLeft = new RealType();
					}
					else if(getType(s,types) instanceof BooleanType) {
						typeLeft = new BooleanType();
					}
				} 

			}

			for(Pair<String,Integer> s : tmp.keySet()) {

				if(typeLeft!=null) {
					toRet.put(s,typeLeft);
				}
				else{
					toRet.put(s,tmp.get(s));
				}
			}

			Pair<String,Integer> rightVal = new Pair<String,Integer>(ctx.right.getText(),n_scope);

			Type typeRight = null;


			if(getType(rightVal,types) instanceof RealType) {
				typeRight = new RealType();
			}
			else if(getType(rightVal,types) instanceof BooleanType) {
				typeRight = new BooleanType();
			}



			if(typeLeft != null && typeRight!=null && !typeLeft.equals(typeRight)) {
				System.out.println("Expressions not of the same type (" +typeLeft.getTypeName()+" and "+typeRight.getTypeName() +")");
				System.exit(0);
			}

			if(typeLeft!=null) {
				toRet.put(rightVal,typeLeft);
			}
			else{
				toRet.put(rightVal,new GeneralType(n_types));
				n_types++;
			}



			if(ctx.COMMA()!=null) {
				Pair<String,Integer> rightValPlus = new Pair<String,Integer>(ctx.rightPlus.getText(),n_scope);

				if(typeLeft!=null) {
					toRet.put(rightValPlus,typeLeft);
				}
				else{
					if(!isPresent(rightValPlus,toRet)){
						toRet.put(rightVal,new GeneralType(n_types));
						n_types++;						
					}
					else {
						toRet.put(rightVal,new GeneralType(n_types));
						n_types++;						
					}
				}
			}

		}

		return toRet;
	}

	public Map<Pair<String,Integer>,Type> visitPrec(PrecContext ctx){
		Map<Pair<String,Integer>,Type> toRet = new LinkedHashMap<Pair<String,Integer>,Type>();
		toRet = visitExpr(ctx.expr());

		return toRet;
	}

	public Map<Pair<String,Integer>,Type> visitExpr(ExprContext ctx){
		Map<Pair<String,Integer>,Type> toRet = new LinkedHashMap<Pair<String,Integer>,Type>();
		Type typeRight = null;

		if(ctx.right!=null) {
			Map<Pair<String,Integer>,Type> tmp = visitExpr(ctx.right);
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(s.getKey().equals(ctx.right.getText()) && s.getValue()==n_scope) {
					if(!(tmp.get(s) instanceof GeneralType)) {
						typeRight = tmp.get(s) ;
					}
				}
			}


		}
		Type typeLeft = null;
		Map<Pair<String,Integer>,Type> tmp = visitTerm(ctx.left);
		for(Pair<String,Integer> s : tmp.keySet()) {
			if(!(tmp.get(s) instanceof GeneralType)) {
				typeLeft = tmp.get(s) ;
			}
		}
		if(typeRight!=null && !(typeRight instanceof AssetType)) {
			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,typeRight);
			}
			tmp = visitExpr(ctx.right);
			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,typeRight);
			}
		}
		else if(typeRight!=null && (typeRight instanceof AssetType)) {
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(tmp.get(s) instanceof AssetType) {
					toRet.put(s,typeRight);
				}
				else {
					toRet.put(s,new RealType());
				}
			}
			tmp = visitExpr(ctx.right);
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(tmp.get(s) instanceof AssetType) {
					toRet.put(s,typeRight);
				}
				else {
					toRet.put(s,new RealType());
				}
			}
		}
		else if(typeLeft!=null && !(typeLeft instanceof AssetType)) {

			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,typeLeft);
			}
			if(ctx.right!=null) {
				tmp = visitExpr(ctx.right);
				for(Pair<String,Integer> s : tmp.keySet()) {
					toRet.put(s,typeLeft);
				}
			}
		}
		else if(typeLeft!=null && (typeLeft instanceof AssetType)) {

			for(Pair<String,Integer> s : tmp.keySet()) {
				if(tmp.get(s) instanceof AssetType) {
					toRet.put(s,typeLeft);
				}
				else {
					toRet.put(s,new RealType());
				}			}
			if(ctx.right!=null) {
				tmp = visitExpr(ctx.right);
				for(Pair<String,Integer> s : tmp.keySet()) {
					if(tmp.get(s) instanceof AssetType) {
						toRet.put(s,typeLeft);
					}
					else {
						toRet.put(s,new RealType());
					}				
				}
			}
		}
		else {

			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,tmp.get(s));
			}
			if(ctx.right!=null) {
				tmp = visitExpr(ctx.right);
				for(Pair<String,Integer> s : tmp.keySet()) {
					toRet.put(s,tmp.get(s));
				}
			}
		}
		return toRet;
	} 

	public Map<Pair<String,Integer>,Type> visitTerm(TermContext ctx){
		Map<Pair<String,Integer>,Type> toRet = new LinkedHashMap<Pair<String,Integer>,Type>();
		Type typeRight = null;

		if(ctx.right!=null) {
			Map<Pair<String,Integer>,Type> tmp = visitTerm(ctx.right);
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(s.getKey().equals(ctx.right.getText()) && s.getValue()==n_scope) {
					if(!(tmp.get(s) instanceof GeneralType)) {
						typeRight = tmp.get(s) ;
					}
				}
			}


		}
		Type typeLeft = null;
		Map<Pair<String,Integer>,Type> tmp = visitFactor(ctx.left);
		for(Pair<String,Integer> s : tmp.keySet()) {
			if(!(tmp.get(s) instanceof GeneralType)) {
				typeLeft = tmp.get(s) ;
			}
		}
		if(typeRight!=null && !(typeRight instanceof AssetType)) {
			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,typeRight);
			}
			tmp = visitTerm(ctx.right);
			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,typeRight);
			}
		}
		else if(typeRight!=null && (typeRight instanceof AssetType)) {
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(tmp.get(s) instanceof AssetType) {
					toRet.put(s,typeRight);
				}
				else {
					toRet.put(s,new RealType());
				}
			}
			tmp = visitTerm(ctx.right);
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(tmp.get(s) instanceof AssetType) {
					toRet.put(s,typeRight);
				}
				else {
					toRet.put(s,new RealType());
				}
			}
		}
		else if(typeLeft!=null && !(typeLeft instanceof AssetType)) {

			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,typeLeft);
			}
			if(ctx.right!=null) {
				tmp = visitTerm(ctx.right);
				for(Pair<String,Integer> s : tmp.keySet()) {
					toRet.put(s,typeLeft);
				}
			}
		}
		else if(typeLeft!=null && (typeLeft instanceof AssetType)) {

			for(Pair<String,Integer> s : tmp.keySet()) {
				if(tmp.get(s) instanceof AssetType) {
					toRet.put(s,typeLeft);
				}
				else {
					toRet.put(s,new RealType());
				}			}
			if(ctx.right!=null) {
				tmp = visitTerm(ctx.right);
				for(Pair<String,Integer> s : tmp.keySet()) {
					if(tmp.get(s) instanceof AssetType) {
						toRet.put(s,typeLeft);
					}
					else {
						toRet.put(s,new RealType());
					}				
				}
			}
		}
		else {

			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,tmp.get(s));
			}
			if(ctx.right!=null) {
				tmp = visitTerm(ctx.right);
				for(Pair<String,Integer> s : tmp.keySet()) {
					toRet.put(s,tmp.get(s));
				}
			}
		}
		return toRet;

	} 

	public Map<Pair<String,Integer>,Type> visitFactor(FactorContext ctx){
		Map<Pair<String,Integer>,Type> toRet = new LinkedHashMap<Pair<String,Integer>,Type>();
		Type typeRight = null;

		if(ctx.right!=null) {
			Map<Pair<String,Integer>,Type> tmp = visitValue(ctx.right);
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(s.getKey().equals(ctx.right.getText()) && s.getValue()==n_scope) {
					if(!(tmp.get(s) instanceof GeneralType)) {
						typeRight = tmp.get(s) ;
					}
				}
			}


		}
		Type typeLeft = null;
		Map<Pair<String,Integer>,Type> tmp = visitValue(ctx.left);
		for(Pair<String,Integer> s : tmp.keySet()) {
			if(!(tmp.get(s) instanceof GeneralType)) {
				typeLeft = tmp.get(s) ;
			}
		}
		if(typeRight!=null && !(typeRight instanceof AssetType)) {
			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,typeRight);
			}
			tmp = visitValue(ctx.right);
			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,typeRight);
			}
		}
		else if(typeRight!=null && (typeRight instanceof AssetType)) {
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(tmp.get(s) instanceof AssetType) {
					toRet.put(s,typeRight);
				}
				else {
					toRet.put(s,new RealType());
				}
			}
			tmp = visitValue(ctx.right);
			for(Pair<String,Integer> s : tmp.keySet()) {
				if(tmp.get(s) instanceof AssetType) {
					toRet.put(s,typeRight);
				}
				else {
					toRet.put(s,new RealType());
				}
			}
		}
		else if(typeLeft!=null && !(typeLeft instanceof AssetType)) {

			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,typeLeft);
			}
			if(ctx.right!=null) {
				tmp = visitValue(ctx.right);
				for(Pair<String,Integer> s : tmp.keySet()) {
					toRet.put(s,typeLeft);
				}
			}
		}
		else if(typeLeft!=null && (typeLeft instanceof AssetType)) {

			for(Pair<String,Integer> s : tmp.keySet()) {
				if(tmp.get(s) instanceof AssetType) {
					toRet.put(s,typeLeft);
				}
				else {
					toRet.put(s,new RealType());
				}			}
			if(ctx.right!=null) {
				tmp = visitValue(ctx.right);
				for(Pair<String,Integer> s : tmp.keySet()) {
					if(tmp.get(s) instanceof AssetType) {
						toRet.put(s,typeLeft);
					}
					else {
						toRet.put(s,new RealType());
					}				
				}
			}
		}
		else {

			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,tmp.get(s));
			}
			if(ctx.right!=null) {
				tmp = visitValue(ctx.right);
				for(Pair<String,Integer> s : tmp.keySet()) {
					toRet.put(s,tmp.get(s));
				}
			}
		}
		return toRet;
	} 

	public Map<Pair<String,Integer>,Type> visitEvents(EventsContext ctx){
		Map<Pair<String,Integer>,Type> toRet = new LinkedHashMap<Pair<String,Integer>,Type>();
		Map<Pair<String,Integer>,Type> tmp = visitExpr(ctx.expr());
		for(Pair<String,Integer> s : tmp.keySet()) {
			toRet.put(s,new TimeType());
		}

		return toRet;
	}

	public Map<Pair<String,Integer>,Type> visitValue(ValueContext ctx){

		Map<Pair<String,Integer>,Type> toRet = new LinkedHashMap<Pair<String,Integer>,Type>();
		if(ctx.expr()!=null) {

			Map<Pair<String,Integer>,Type> tmp = visitExpr(ctx.expr());
			for(Pair<String,Integer> s : tmp.keySet()) {
				toRet.put(s,tmp.get(s));
			}
		}
		else if(ctx.RAWSTRING()!=null ) {
			toRet.put(new Pair<String, Integer>(ctx.RAWSTRING().getText(),n_scope),new StringType());
		}
		else if(ctx.ID()!=null) {
			boolean flag = false;
			for(Pair<String,Integer> pair : types.keySet()) {
				if(pair.getKey().equals(ctx.ID().getText()) && pair.getValue() == n_scope) {
					toRet.put(new Pair<String, Integer>(ctx.ID().getText(),n_scope),types.get(pair));
					flag = true;
				}
			}

			if(!flag) {
				toRet.put(new Pair<String, Integer>(ctx.ID().getText(),n_scope),new GeneralType(n_types));
				n_types++;
			}
		}
		else if(ctx.number()!=null) {
			toRet.put(new Pair<String, Integer>(ctx.number().getText(),n_scope),new RealType());
			n_types++;
		}
		else if(ctx.TRUE()!=null ) {

			toRet.put(new Pair<String, Integer>(ctx.TRUE().getText(),n_scope),new BooleanType());
		}
		else if(ctx.FALSE()!=null) {
			toRet.put(new Pair<String, Integer>(ctx.FALSE().getText(),n_scope),new BooleanType());

		}
		else if(ctx.NOW()!=null) {
			toRet.put(new Pair<String, Integer>(ctx.NOW().getText(),n_scope),new TimeType());

		}


		return toRet;
	}



}
