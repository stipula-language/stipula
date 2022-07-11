package ast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.Object;
import java.nio.charset.Charset;

import lib.Pair;

public class Agreement {
	public static final int LEN = 5;  

	ArrayList<Disputer> disputers = null;
	ArrayList<Field> vars = null;
	ArrayList<Pair<Disputer,ArrayList<Field>>> vals = null;

	public Agreement(ArrayList<Disputer> d, ArrayList<Field> v) {
		disputers = d;
		vars = v;
		for(Disputer disp : disputers) {
			disp.setUserId(generateUserId(LEN).toString());
		}

	}

	public Agreement(ArrayList<Disputer> d, ArrayList<Field> v, ArrayList<Pair<Disputer,ArrayList<Field>>> l) {
		disputers = d;
		vars = v;
		vals = l;
		for(Disputer disp : disputers) {
			disp.setUserId(generateUserId(LEN).toString());
		}
		for(Pair<Disputer,ArrayList<Field>> pair : vals) {
			for(Disputer disp : disputers) {
				if(disp.getId().equals(pair.getKey().getId())) {
					pair.getKey().setUserId(disp.getUserId());
				}
			}
			
		}

	}

	public ArrayList<Disputer> getDisputers(){
		return disputers;
	}

	public StringBuilder generateUserId(int len) {
		String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
		StringBuilder s = new StringBuilder(len);
		int i;
		for ( i=0; i<len; i++) {
			int ch = (int)(AlphaNumericStr.length() * Math.random());
			s.append(AlphaNumericStr.charAt(ch));
		}
		return s;
	}

	public ArrayList<ArrayList<Pair<Field,String>>> askValues() {
		Scanner input = new Scanner(System.in);
		ArrayList<ArrayList<Pair<Field,String>>>  values = new ArrayList<ArrayList<Pair<Field,String>>>();
		ArrayList<Pair<Field,String>> str = new ArrayList<Pair<Field,String>>();
		for(Pair<Disputer,ArrayList<Field>> pair : vals) {
			str = new ArrayList<Pair<Field,String>>();
			System.out.println();
			System.out.println("# Please, " + pair.getKey().getId() + " insert your id: ");
			String read1 = input.nextLine();
			
			if(read1.equals(pair.getKey().getUserId())) {
				System.out.println("# Please, " + pair.getKey().getId() + " insert the values for the fields: ");
				for(int i=0; i<pair.getValue().size(); i++) {
					System.out.println(pair.getValue().get(i).getId()+": ");
					String read = input.nextLine();
					str.add(new Pair(pair.getValue().get(i),read));
				}
				values.add(str);
			}
			else {
				values = null;
				break;
			}
		}

		return values;
	}


	public boolean doAgree(ArrayList<ArrayList<Pair<Field,String>>> values) {
		boolean agree = true;
		ArrayList<Pair<Field,String>> ref = values.get(0);
		for(int i = 1; i<values.size() && agree; i++) {
			for(int j=0; j<values.get(i).size(); j++) {
				for(int k=0; k<ref.size(); k++) {
					if(ref.get(k).getKey().getId().equals(values.get(i).get(j).getKey().getId())) {
						if(!ref.get(k).getValue().equals(values.get(i).get(j).getValue())){
							agree = false;
						}
					}
				}
			}
		}
		return agree;
	}


	public void printAgreement() {
		for(Disputer d : disputers) {
			d.printDisputer();
		}
		for(Field f : vars) {
			f.printField();
		}
	}

}
