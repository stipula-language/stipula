package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import org.javatuples.Triplet;
import org.javatuples.Pair;

import parser.StipulaBaseListener;
import parser.StipulaParser.AssetdecContext;
import parser.StipulaParser.FunContext;
import parser.StipulaParser.ProgContext;
import parser.StipulaParser.StatContext;

public class LiquidityAnalysis extends StipulaBaseListener  {

	ArrayList<Map<Triplet<String,String,String>,ArrayList<ArrayList<Node>>>> types = new ArrayList<Map<Triplet<String,String,String>,ArrayList<ArrayList<Node>>>>();
	String name ;
	ArrayList<String> disputers = new ArrayList<String>();

	public ArrayList<Map<Triplet<String,String,String>,ArrayList<ArrayList<Node>>>> getLiquidityTypes(){
		return types;
	}

	public static void printTypes(ArrayList<Map<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<Node>>>> typesComp) {
		for(int i=0; i<typesComp.size(); i++){
			for(Map.Entry<ArrayList<Triplet<String,String,String>>, ArrayList<ArrayList<Node>>> entry : typesComp.get(i).entrySet()) {
				ArrayList<Triplet<String,String,String>> label = entry.getKey();
				for(int k = 0; k<label.size(); k++) {
					Triplet<String,String,String> label2 = label.get(k);
					System.out.print(label2+" ");
					System.out.println("");
				}
				ArrayList<ArrayList<Node>> typesTmp = entry.getValue();
				if(typesTmp!=null) {
					for(int j=0; j<typesTmp.size(); j++) {
						for(int k=0; k<typesTmp.get(j).size(); k++) {
							System.out.print(" \t "+typesTmp.get(j).get(k).toVisit()+" ");
						}
						System.out.println("");
					}
				}

			}
			System.out.println("");
		}
	}
	
	public boolean checkChangeLiquidity(ArrayList<Node> toCheck, ArrayList<Pair<String,Node>> setZ, String state, ArrayList<Map<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<Node>>>>  typesLiquidity) {
		boolean flag = false;
		if(!toCheck.get(2).toVisit().equals("0") && !toCheck.get(1).toVisit().equals(toCheck.get(2).toVisit())) {
			Pair<String,Node> tmp = new Pair<>(state,toCheck.get(0));
			for(int i=0; i<setZ.size(); i++) {
				if(setZ.get(i).getValue0().equals(tmp.getValue0()) && setZ.get(i).getValue1().toVisit().equals(tmp.getValue1().toVisit())){
					flag = true;
				}
			}
			if(!flag) {
				ArrayList<ArrayList<Triplet<String,String,String>>> comp = calcComputations(state);
				ArrayList<Pair<String,ArrayList<ArrayList<Node>>>> types = getArrayPairTypes(comp,typesLiquidity);

				boolean check = false;
				for(int i=0; i<types.size() && !check; i++) {
					if(types.get(i).getValue(0).equals(state)) {
						for(int j=0; j<types.get(i).getValue1().size(); j++) {
							if(types.get(i).getValue1().get(j).get(2).toVisit().equals("0")) {
								check = true;
							}
						}
					}
				}
				if(!check) {
					flag = true;
				}
			}
		}
		return flag;
	}



	public ArrayList<Pair<String,Node>> addLiquidity(ArrayList<Node> toCheck, ArrayList<Pair<String,Node>> setZ, String state) {
		boolean flag = false;
		if(!toCheck.get(2).toVisit().equals("0") && !toCheck.get(1).toVisit().equals(toCheck.get(2).toVisit())) {
			Pair<String,Node> tmp = new Pair<>(state,toCheck.get(0));
			boolean present = false;
			for(int i=0; i<setZ.size(); i++) {
				if(setZ.get(i).getValue0().equals(tmp.getValue0()) && setZ.get(i).getValue1().toVisit().equals(tmp.getValue1().toVisit())){
					present = true;
				}
			}
			if(!present) {
				setZ.add(tmp);
			}
			flag = true;
		}
		return setZ;
	}


	public ArrayList<Pair<String,ArrayList<ArrayList<Node>>>> getArrayPairTypes(ArrayList<ArrayList<Triplet<String,String,String>>> reach, ArrayList<Map<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<Node>>>>  typesLiquidity) {
		Pair<String,ArrayList<ArrayList<Node>>> type = null;
		ArrayList<Pair<String,ArrayList<ArrayList<Node>>>> allTypes = new ArrayList<Pair<String,ArrayList<ArrayList<Node>>>>();
		for(int i=0; i<reach.size(); i++) {
			type = null;
			if(reach.get(i).size()>1) {
				for(int j=0; j<typesLiquidity.size(); j++) {
					for(Map.Entry<ArrayList<Triplet<String,String,String>>, ArrayList<ArrayList<Node>>> entry : typesLiquidity.get(j).entrySet()) {
						ArrayList<Triplet<String,String,String>> label = entry.getKey();
						if(label.equals(reach.get(i))) {
							if(entry.getValue()!=null) {
								String tmpLabel = label.get(label.size()-1).getValue2();
								ArrayList<ArrayList<Node>> tmpList = entry.getValue();
								type = new Pair<>(tmpLabel,tmpList);

							}
						}
					}
				}
			}
			else {
				for(int j=0; j<types.size(); j++){
					for(Map.Entry<Triplet<String,String,String>, ArrayList<ArrayList<Node>>> entry : types.get(j).entrySet()) {
						Triplet<String,String,String> label = entry.getKey();
						if(label.equals(reach.get(i).get(0))) {
							if(entry.getValue()!=null) {
								String tmpLabel = label.getValue2();
								ArrayList<ArrayList<Node>> tmpList = entry.getValue();
								type = new Pair<>(tmpLabel,tmpList);
							}
						}
					}
				}


			}
			allTypes.add(type);
		}
		return allTypes;
	}

	public boolean separateLiquidity(ArrayList<Map<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<Node>>>>  typesLiquidity, String init) {
		boolean flag = false;
		ArrayList<ArrayList<Triplet<String,String,String>>> reach = calcComputations(init);
		ArrayList<String> states = new ArrayList<String>();
		for(int i=0; i<reach.size(); i++) {
			for(int j=0; j<reach.get(i).size(); j++) {
				if(!reach.get(i).get(j).getValue0().equals(init) && !states.contains(reach.get(i).get(j).getValue0())) {
					states.add(reach.get(i).get(j).getValue0());
				}
				if(!reach.get(i).get(j).getValue2().equals(init) && !states.contains(reach.get(i).get(j).getValue2())) {
					states.add(reach.get(i).get(j).getValue2());
				}

			}
		}
		for(int i = 0; i<states.size(); i++) {
			ArrayList<ArrayList<Triplet<String,String,String>>> tmp = calcComputations(states.get(i));
			for(int j=0; j<tmp.size(); j++) {
				if(!reach.contains(tmp.get(j))) {
					reach.add(tmp.get(j));
				}
			}
		}
		ArrayList<Pair<String,ArrayList<ArrayList<Node>>>> allTypes = getArrayPairTypes(reach,typesLiquidity);
		
		ArrayList<Pair<String,Node>> setZ = new ArrayList<Pair<String,Node>>();
		boolean notLiquid = false;
		for(int i=0; i<allTypes.size() && !notLiquid; i++) {

			if(allTypes.get(i)!=null) {
				for(int j=0; j<allTypes.get(i).getValue1().size(); j++) {
					notLiquid = checkChangeLiquidity(allTypes.get(i).getValue1().get(j),setZ,allTypes.get(i).getValue0(),typesLiquidity);
					if(!notLiquid) {
						setZ = addLiquidity(allTypes.get(i).getValue1().get(j),setZ,allTypes.get(i).getValue0());
					}
				}
			}
		}
		
		return notLiquid;
	}

	public ArrayList<ArrayList<Node>> calcTypesComputations(Triplet<String,String,String> init, ArrayList<ArrayList<Triplet<String,String,String>>> comp, int index) {
		for(int j=0; j<types.size(); j++) {
			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(j).entrySet().stream().findFirst().get();
			Triplet<String,String,String> label = tmp.getKey();
			if(init.equals(label)) {
				ArrayList<ArrayList<Node>> typesInit = new ArrayList<ArrayList<Node>>();
				for(int k=0; k<tmp.getValue().size(); k++) {
					ArrayList<Node> tmpValues = new ArrayList<Node>();
					tmpValues.add(tmp.getValue().get(k).get(0));
					if(tmp.getValue().get(k).size()>index) {
						tmpValues.add(tmp.getValue().get(k).get(index));
					}
					else {
						Node tmpType = calculateFinValueVarsComputations(tmp.getValue().get(k).get(0));
						tmpValues.add(tmpType);
					}
					typesInit.add(tmpValues);
				}
				return typesInit;
			}
		}
		return null;
	}

	public ArrayList<Map<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<Node>>>> getTypesComputations(ArrayList<ArrayList<Triplet<String,String,String>>> comp) {
		ArrayList<Map<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<Node>>>> typesComp = new ArrayList<Map<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<Node>>>>();
		for(int i=0; i<comp.size(); i++) {
			if(comp.get(i).size()>0) {
				Triplet<String,String,String> init = comp.get(i).get(0);
				ArrayList<ArrayList<Node>> typesInit = calcTypesComputations(init,comp,1);
				Triplet<String,String,String> fin = comp.get(i).get(comp.get(i).size()-1);
				ArrayList<ArrayList<Node>> typesFin = calcTypesComputations(fin,comp,2);
				for(int j=0; j<typesInit.size(); j++) {
					boolean flag = false;
					for(int k=0; k<typesFin.size(); k++) {
						if(typesInit.get(j).get(0).toVisit().equals(typesFin.get(k).get(0).toVisit())) {
							typesInit.get(j).add(typesFin.get(k).get(1));
							flag = true;
						}
					}
					if(!flag) {
						Node typeTmp = calculateFinValueVarsComputations(typesInit.get(j).get(0));
						typesInit.get(j).add(typeTmp);
					}
				}

				for(int j=0; j<typesFin.size(); j++) {
					boolean flag = false;
					for(int k=0; k<typesInit.size(); k++) {
						if(typesFin.get(j).get(0).toVisit().equals(typesInit.get(k).get(0).toVisit())) {
							flag = true;
						}
					}
					if(!flag) {
						Node typeTmp = calculateInitValueVarsComputations(typesFin.get(j).get(0));
						typesFin.get(j).add(1,typeTmp);
						typesInit.add(typesFin.get(j));
					}
				}

				Map<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<Node>>> toAdd = new LinkedHashMap<ArrayList<Triplet<String,String,String>>,ArrayList<ArrayList<Node>>>();
				toAdd.put(comp.get(i),typesInit);
				typesComp.add(toAdd);
			}
		}
		return typesComp;
	}

	public int howManyComputations(String init) {
		int comp = 0;
		for(int i=0; i<types.size(); i++) {
			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(i).entrySet().stream().findFirst().get();
			String labelTmp = tmp.getKey().getValue0();


			if(labelTmp.equals(init)) {
				comp++;
			}
		}
		return comp;
	}

	public ArrayList<Triplet<String,String,String>> calcSetReachable(String init, String initFin, int i,ArrayList<Triplet<String,String,String>> reach){
		Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(i).entrySet().stream().findFirst().get();
		String labelTmp = tmp.getKey().getValue0();
		if(i<types.size()) {
			if(labelTmp.equals(init)) {
				boolean flag = false;
				for(int k=0; k<reach.size(); k++) {
					if(reach.get(k).getValue1().equals(tmp.getKey().getValue1())) {
						flag = true;
					}
				}
				if(!flag) {
					String labelFin = tmp.getKey().getValue2();
					reach.add(tmp.getKey());

					if(i+1<types.size()) {
						i = i+1;
						reach = calcSetReachable(labelFin,initFin,i, reach);

					}
				}
			}
		}
		return reach;
	}

	public ArrayList<ArrayList<Triplet<String,String,String>>> calcComputations2(String init){
		ArrayList<ArrayList<Triplet<String,String,String>>> comp = new ArrayList<ArrayList<Triplet<String,String,String>>>();
		ArrayList<Triplet<String,String,String>> toPass = null; 
		for(int i=0; i<types.size(); i++) {
			toPass = new ArrayList<Triplet<String,String,String>>();
			toPass = calcSetReachable(init,init,i,toPass);
			comp.add(toPass);
		}
		if(toPass.size()>0) {
			comp = calcComputations(init);
		}
		return comp;
	}

	public ArrayList<Triplet<String,String,String>> cerca(String init){
		ArrayList<Triplet<String,String,String>> comp = new ArrayList<Triplet<String,String,String>>();

		for(int i=0; i<types.size(); i++) {
			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(i).entrySet().stream().findFirst().get();
			String labelTmp = tmp.getKey().getValue0();
			if(labelTmp.equals(init)) {
				Triplet<String,String,String> toPass = tmp.getKey();

				comp.add(toPass);
			}

		}
		return comp;
	}


	public ArrayList<ArrayList<Triplet<String,String,String>>> calcComputations(String init){
		ArrayList<ArrayList<Triplet<String,String,String>>> comp = new ArrayList<ArrayList<Triplet<String,String,String>>>();
		ArrayList<Triplet<String,String,String>> toPass = null; 
		for(int i=0; i<types.size(); i++) {

			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(i).entrySet().stream().findFirst().get();
			String labelTmp = tmp.getKey().getValue0();
			if(labelTmp.equals(init)) {
				toPass = new ArrayList<Triplet<String,String,String>>();
				toPass.add(tmp.getKey());
				comp.add(toPass);
			}
		}
		ArrayList<ArrayList<Triplet<String,String,String>>> toRet = new ArrayList<ArrayList<Triplet<String,String,String>>>();
		int t = 0;

		for(int i=0; i<comp.size(); i++){

			t = 0;
			while(t<comp.get(i).size()) {

				String labelTmp = comp.get(i).get(t).getValue2();

				ArrayList<Triplet<String,String,String>>  tmpLst = new ArrayList<Triplet<String,String,String>>();
				tmpLst = cerca(labelTmp);
				for(int k = 0; k<tmpLst.size(); k++ ) {
					if(k>0 ) {

						ArrayList<Triplet<String,String,String>> toPass2 = new ArrayList<Triplet<String,String,String>>();
						ArrayList<Triplet<String,String,String>> tmp = null;
						for(int p=0; p<=t; p++) {
							toPass2.add(comp.get(i).get(p));
							tmp = new ArrayList<Triplet<String,String,String>>();
							for(int q=0; q<toPass2.size();q++) {
								tmp.add(toPass2.get(q));
							}
							if(!toRet.contains(tmp)) {
								toRet.add(tmp);
							}							
						}

						toPass2.add(tmpLst.get(k));
					

						if(!toRet.contains(toPass2)) {
							toRet.add(toPass2);
						}


					}
					else {

						if(!comp.get(i).contains(tmpLst.get(k))) {

							comp.get(i).add(tmpLst.get(k));
						}
						if(!toRet.contains(comp.get(i))) {

							toRet.add(comp.get(i));
						}

					}
				}
				//System.out.println(toRet);

				if(tmpLst.size()==0 && !toRet.contains(comp.get(i))) {
					toRet.add(comp.get(i));
				}
				t++;
			}

		}

		return toRet;
	}

	public Node calculateInitValueVars(ArrayList<ArrayList<Node>> list, Node el) {
		Node toRet = null;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).get(0).toVisit().equals(el.toVisit())) {
				toRet = list.get(i).get(1);
			}
		}
		return toRet;
	}

	public Node calculateFinValueVarsComputations(Node el) {
		Node toRet = null;
		for(int i=0; i<types.size(); i++) {
			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(i).entrySet().stream().findFirst().get();
			ArrayList<ArrayList<Node>> tmpTypes = tmp.getValue();
			for(int j=0; j<tmpTypes.size(); j++) {
				if(tmpTypes.get(j).get(0).toVisit().equals(el.toVisit()) && tmpTypes.get(j).size()>2) {
					toRet = tmpTypes.get(j).get(2);
				}
			}

		}
		return toRet;
	}

	public Node calculateInitValueVarsComputations(Node el) {
		Node toRet = null;
		for(int i=0; i<types.size(); i++) {
			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(i).entrySet().stream().findFirst().get();
			ArrayList<ArrayList<Node>> tmpTypes = tmp.getValue();
			for(int j=0; j<tmpTypes.size(); j++) {
				if(tmpTypes.get(j).get(0).toVisit().equals(el.toVisit()) && tmpTypes.get(j).size()>2) {
					toRet = tmpTypes.get(j).get(1);
				}
			}

		}
		return toRet;
	}

	public Node calculateInitValue(Node nameAsset, Triplet<String,String,String> label) {
		String initState = label.getValue0();
		Node typeToRet = null;
		for(int i=0; i<types.size(); i++) {
			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(i).entrySet().stream().findFirst().get();

			String labelTmp = tmp.getKey().getValue2();

			ArrayList<ArrayList<Node>> tmpTypes = tmp.getValue();
			if(labelTmp.equals(initState) && !tmp.getKey().getValue1().equals(label.getValue1())) {
				for(int j=0; j<tmpTypes.size(); j++) {
					if(nameAsset.toVisit().equals(tmpTypes.get(j).get(0).toVisit()) && tmpTypes.get(j).size()>2) {
						if( tmpTypes.get(j).get(2) instanceof UpperTypeNode) {
							typeToRet = new CsiTypeNode();

						}
						else {

							typeToRet = tmpTypes.get(j).get(2);

						}
					}
				}
			}

		}
		if(typeToRet == null) {typeToRet = new InfTypeNode();}

		return typeToRet;
	}

	public Pair<Node,Node> calculateValue(Node nameAssetA, Node typeAssetA, Node nameAssetB, Node typeAssetB) {
		Node tmpFinalAssetB = null;
		Node tmpFinalAssetA = null;
		if(typeAssetA instanceof ZeroTypeNode) {
			// non devo fare niente, il tipo di B rimane quello che aveva
			tmpFinalAssetB = typeAssetB;
			tmpFinalAssetA = typeAssetA;

		}else if(typeAssetA instanceof CsiTypeNode || typeAssetA instanceof InfTypeNode) {
			// il tipo di B diventa csi U typeB
			tmpFinalAssetB = new UpperTypeNode(typeAssetA,typeAssetB);	
			tmpFinalAssetA = new ZeroTypeNode();
		}

		return new Pair<Node,Node>(tmpFinalAssetA,tmpFinalAssetB);
	}

	public String getLabel() {
		return name;
	}

	public boolean isPresent(ArrayList<ArrayList<Node>> list, Node el) {
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).get(0).toVisit().equals(el.toVisit())) {
				flag = true;
			}
		}
		return flag;
	}


	public ArrayList<ArrayList<Node>> modifyValue(ArrayList<ArrayList<Node>> list, Node el, Node type) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).get(0).toVisit().equals(el.toVisit())) {
				if(list.get(i).size()>2) {
					list.get(i).set(2,type);
				}
				else {
					list.get(i).add(type);
				}

			}
		}
		return list;
	}

	@Override
	public void enterFun(FunContext ctx) {
		String state1 = ctx.state().get(0).getText();
		String state2 = ctx.state().get(1).getText();
		String disp = ctx.disputer().get(0).getText();
		if(!disputers.contains(disp)) {
			disputers.add(disp);
		}
		String id = ctx.id().getText();
		String toRet = disp+"."+id;
		Triplet<String,String,String> triplet = new Triplet<String,String,String>(state1, toRet, state2);
		Map<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> toAdd = new LinkedHashMap<Triplet<String,String,String>,ArrayList<ArrayList<Node>>>();
		toAdd.put(triplet,null);
		types.add(toAdd);

	}

	@Override
	public void enterAssetdec(AssetdecContext ctx) {
		VarNode toAdd = new VarNode(ctx.strings().ID().getText(), new AssetTypeNode());;

		if(types.get(types.size()-1).entrySet().stream().findFirst().get().getValue()==null) {
			ArrayList<ArrayList<Node>> tmpToAdd = new ArrayList<ArrayList<Node>>();
			ArrayList<Node> listTmp = new ArrayList<Node>();
			listTmp.add(toAdd);
			if(types.size()==1) {
				Node typeInit = new InfTypeNode();
				listTmp.add(typeInit);
			}
			else {
				Node typeInit = calculateInitValue(toAdd,types.get(types.size()-1).entrySet().stream().findFirst().get().getKey());
				listTmp.add(typeInit);
			}
			tmpToAdd.add(listTmp);
			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(types.size()-1).entrySet().stream().findFirst().get();
			Triplet<String,String,String> label = tmp.getKey();
			types.get(types.size()-1).put(label,tmpToAdd);
		}
		else {
			ArrayList<Node> listTmp = new ArrayList<Node>();
			listTmp.add(toAdd);
			if(types.size()==1) {
				Node typeInit = new InfTypeNode();
				listTmp.add(typeInit);
			}
			else {
				Node typeInit = calculateInitValue(toAdd,types.get(types.size()-1).entrySet().stream().findFirst().get().getKey());
				listTmp.add(typeInit);
			}
			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(types.size()-1).entrySet().stream().findFirst().get();
			Triplet<String,String,String> label = tmp.getKey();
			ArrayList<ArrayList<Node>> array = tmp.getValue();
			array.add(listTmp);
			types.get(types.size()-1).put(label,array);


		}
	}

	@Override
	public void enterStat(StatContext ctx) {
		if(ctx.ASSETUP()!=null ) {
			VarNode toAddLeft = new VarNode(ctx.left.strings().ID().getText(), new AssetTypeNode());
			VarNode toAddRight = new VarNode(ctx.right.strings().ID().getText(), new AssetTypeNode());

			Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(types.size()-1).entrySet().stream().findFirst().get();
			ArrayList<ArrayList<Node>> tmpToAdd = null;
			if(tmp.getValue()==null) {
				tmpToAdd  = new ArrayList<ArrayList<Node>>();
			}
			else {
				tmpToAdd = tmp.getValue();
			}
			ArrayList<Node> listTmpLeft = new ArrayList<Node>();
			ArrayList<Node> listTmpRight = new ArrayList<Node>();

			Triplet<String,String,String> label = tmp.getKey();
			listTmpLeft.add(toAddLeft);
			listTmpRight.add(toAddRight);
			if(types.size()==1) {
				Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp1 = types.get(types.size()-1).entrySet().stream().findFirst().get();
				ArrayList<ArrayList<Node>> arrayTmp = tmp.getValue();
				Node typeInitLeft = calculateInitValueVars(arrayTmp,toAddLeft);
				Node typeInitRight = null;
				if(!disputers.contains(toAddRight.toVisit())) {
					typeInitRight = calculateInitValueVars(arrayTmp,toAddRight);
				}
				if(typeInitLeft == null) { typeInitLeft = new CsiTypeNode();}
				if(typeInitRight == null) { typeInitRight = new CsiTypeNode();}
				listTmpLeft.add(typeInitLeft);
				listTmpRight.add(typeInitRight);

				Pair<Node,Node> t = calculateValue(toAddLeft,typeInitLeft,toAddRight,typeInitRight);
				listTmpLeft.add(t.getValue0());
				listTmpRight.add(t.getValue1());

			}
			else {


				Node typeInitLeft = calculateInitValue(toAddLeft,label);
				listTmpLeft.add(typeInitLeft);
				Node typeInitRight = calculateInitValue(toAddRight,label);
				listTmpRight.add(typeInitRight);

				Pair<Node,Node> t = calculateValue(toAddLeft,typeInitLeft,toAddRight,typeInitRight);
				listTmpLeft.add(t.getValue0());
				listTmpRight.add(t.getValue1());

			}


			if(!isPresent(tmpToAdd,toAddLeft)) {
				tmpToAdd.add(listTmpLeft);
			}
			else {
				if(listTmpLeft.size()>2) {
					tmpToAdd = modifyValue(tmpToAdd,toAddLeft,listTmpLeft.get(2));
				}
			}
			if(!isPresent(tmpToAdd,toAddRight) && !disputers.contains(toAddRight.toVisit())) {
				tmpToAdd.add(listTmpRight);
			}
			else {
				if(listTmpRight.size()>2 && !disputers.contains(toAddRight.toVisit())) {
					tmpToAdd = modifyValue(tmpToAdd,toAddRight,listTmpRight.get(2));
				}
			}
			types.get(types.size()-1).put(label,tmpToAdd);
		}

	}
	/*
			else {
				ArrayList<Node> listTmp = new ArrayList<Node>();
				listTmp.add(toAddLeft);
				if(types.size()==1) {
					Node typeInit = new CsiTypeNode();
					listTmp.add(typeInit);
					if(typeInit != null) {
						Pair<Node,Node> tmpTypes = calculateValue(toAddLeft,typeInit,toAddRight,typeInit);
						System.out.println(toAddLeft.toVisit()+" "+tmpTypes.getValue0().toVisit()+" "+toAddRight.toVisit()+" "+tmpTypes.getValue1().toVisit());
					}
				}
				else {
					Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(types.size()-1).entrySet().stream().findFirst().get();
					Triplet<String,String,String> label = tmp.getKey();
					Node typeInit = calculateInitValue(toAddLeft,label);
					//listTmp.add(typeInit);
					if(typeInit != null) {
						calculateValue(toAddLeft,typeInit,toAddRight,typeInit);
					}
				}
				Map.Entry<Triplet<String,String,String>,ArrayList<ArrayList<Node>>> tmp = types.get(types.size()-1).entrySet().stream().findFirst().get();
				Triplet<String,String,String> label = tmp.getKey();
				ArrayList<ArrayList<Node>> array = tmp.getValue();
				if(!isPresent(array,toAddLeft)) {
					array.add(listTmp);
					types.get(types.size()-1).put(label,array);
				}
			}*/

}
