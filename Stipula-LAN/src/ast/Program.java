package ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import ast.Event.DelayEvent;
import lib.Pair;


public class Program {

	private String id ;
	private String initState = null;
	private ArrayList<Field> fields = null;
	private ArrayList<Asset> assets = null;
	private ArrayList<Party> parties = null;
	private Agreement agreement;
	private ArrayList<Contract> contracts = null;
	private ArrayList<Event> events = null;
	private ArrayList<Timer> timer;
	private String runningState = null;
	private boolean running = false;
	private ArrayList<Object> lock = new ArrayList<Object>();
	private int howManyThreads = 0;
	private boolean checkEvent = false;
	private int caseExec = 0;


	public Program(String name, ArrayList<Field> f, ArrayList<Asset> a, ArrayList<Party> d, String s){
		id = name;
		fields = f;
		assets = a;
		parties = d;
		initState = s;
	}

	public String getInitState() {
		return initState;
	}

	public String getRunningState() {
		return runningState;
	}

	public void addContract(Contract c) {
		if(contracts == null) {
			contracts = new ArrayList<Contract>();
		}
		contracts.add(c);
	}

	public void addEvents(ArrayList<Event> e) {
		events = e ;
	}

	public void addEvent(Event a) {
		if(events == null) {
			events = new ArrayList<Event>();
		}
		events.add(a);
	}

	public void addAsset(Asset a) {
		if(assets == null) {
			assets = new ArrayList<Asset>();
		}
		assets.add(a);
	}

	public void addAgreement(Agreement a) {
		agreement = a;
	}


	public ArrayList<Party> getParties(){
		return parties;
	}

	public ArrayList<Contract> getContracts(){
		return contracts;
	}
	public Contract getContract(int index) {
		for(int i = 0; i<contracts.size(); i++) {
			if(i==index) {
				return contracts.get(i);
			}
		}
		return null;
	}

	public void addParties(ArrayList<Party> disp) {
		if(parties==null) {
			parties = new ArrayList<Party>();
			parties = disp;
		}
		else {
			for(Party d : disp) {
				parties.add(d);
			}
		}
	}

	public void addParty(Party disp) {
		if(parties==null) {
			parties = new ArrayList<Party>();
		}
		parties.add(disp);

	}

	public ArrayList<Field> getFields(){
		return fields;
	}

	public Agreement getAgreement() {
		return agreement;
	}

	public ArrayList<Asset> getAssets(){
		return assets;
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public void updateFieldsTypes(Map<Pair<String, Integer>, Type> typedVars) {
		for(Pair<String,Integer> pair : typedVars.keySet()) {
			for(Field f : fields) {
				if(f.getId().equals(pair.getKey())) {
					f.setType(typedVars.get(pair));
				}
			}
		}
	}

	public void updateFields(Contract cnt) {
		for(Field fc : cnt.getGlobalVars()) {
			for(Field f : fields) {
				if(f.getId().equals(fc.getId())) {
					if(fc.getValueStr()!=null ) {
						f.setValueStr(fc.getValueStr());
					}
					else{
						f.setValue((float) fc.getValue());
					}
				}
			}
		}
	}

	public void updateParties(Contract cnt) {
		for(Party fc : cnt.getGlobalParties()) {
			for(Party f : parties) {
				if(f.getId().equals(fc.getId())) {
					f.setValue((float) fc.getValue());
					f.setValueStr(fc.getValueStr());
					f.setValueAssetCalc((float) fc.getValueAsset());
				}
			}
		}
	}

	public void updateFieldsAgreement(ArrayList<ArrayList<Pair<Field,String>>> values) {
		ArrayList<Pair<Field,String>> tmp = new ArrayList<Pair<Field,String>>();
		for(ArrayList<Pair<Field,String>> el : values) {
			tmp.addAll(el);
		}
		for(Pair<Field,String> el : tmp) {
			for(Field f: fields) {
				if(f.getId().equals(el.getKey().getId())) {
					DateUtils d = new DateUtils();
					if(d.isValidDate(el.getValue())  ) {
						f.setValueStr(el.getValue());
						f.setType(new TimeType());
					}
					else if(isNumeric(el.getValue())) {
						f.setValue((float) Double.parseDouble(el.getValue()));
						f.setType(new RealType());
					}
					else if(el.getValue().equals("true") || el.getValue().equals("false")) {
						f.setValueBool(Boolean.parseBoolean(el.getValue()));
						f.setType(new BooleanType());
					}
					else {
						f.setValueStr(el.getValue());
						f.setType(new StringType());
					}
				}
			}
		}
	}

	public void updateAssets(Contract cnt) {
		for(Asset ac : cnt.getGlobalAssets()) {
			for(Asset a : assets) {
				if(a.getId().equals(ac.getId())) {
					a.setCalcValue((float) ac.getValue());
				}
			}
		}
	}

	public void printFields() {
		for(Field f : fields) {

			System.out.print("\t");
			f.printField();
		}
	}

	public void printAssets() {
		for(Asset f : assets) {
			System.out.print("\t");
			f.printAsset();
		}

	}


	public void printParties() {
		for(Party d : parties) {
			System.out.print("\t");
			d.printParty();
		}

	}

	public boolean contained(Entity el, ArrayList<Party> A) {
		boolean contains = false;
		if(A!=null) {
			for(Party n : A) {
				if(n.getId().equals(el.getId())) {
					contains = true;
				}
			}
		}
		return contains;
	}

	public void setTimer(int index, long seconds, Event event, TypeInference ti) {

		if(timer==null) {
			timer = new ArrayList<Timer>();
		}
		timer.add(new Timer());
		timer.get(index).schedule(new DelayEvent(event,ti), seconds*1000);
		

	}

	void udpateRunningState(String s) {
		runningState = s;
	}

	class GetInputThread implements Runnable {
		String inputString = "";

		public void run() {
			while (checkEvent) {
				@SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);
				inputString = in.nextLine();
				try {
					Thread.sleep(5000);
					continue;
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		}

		public String getInput() {
			return this.inputString;
		}

	}

	class DelayEvent extends TimerTask {

		ArrayList<Pair<Expression,ArrayList<Statement>>> toExecute = null;
		String initStateEvent = null;
		String endStateEvent = null;
		Event eventExec = null;
		TypeInference typesInf = null;
		public boolean runningEvent = false;

		public DelayEvent(Event event, TypeInference typeinferencer) {
			super();
			toExecute = event.getStatements();
			initStateEvent = event.getInitState();
			endStateEvent = event.getEndState();
			eventExec = event;
			typesInf = typeinferencer;
		}

		public void run() {
			running = true;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(lock){
				System.out.println("Trying to run an event");
				if(initStateEvent.equals(getRunningState())) {
					System.out.println("############");
					System.out.println("An event is running..");
					for(Pair<Expression,ArrayList<Statement>> pair : toExecute) {
						ArrayList<Statement> stm = pair.getValue();
						eventExec.getContract().runStatements(true,typesInf,pair.getValue());
					}
					udpateRunningState(endStateEvent);
					System.out.println("Updated fields:");
					printFields();
					System.out.println("Updated assets:");
					printAssets();
					System.out.println("Updated parties:");
					printParties();
					System.out.println("############");
					System.out.println("Next state " + getRunningState());
					System.out.println("############");

				}
				else {
					System.out.println("Time has passed, but wrong init state. Event couldn't run!");
					System.out.println("############");
				}
				running = false;
				howManyThreads--;
				lock.notifyAll();
			}
			Thread.currentThread().interrupt();
		}


		public boolean getRunningEvent() {
			return runningEvent;
		}
	}

	public void runProgram(TypeInference typeinferencer) throws InterruptedException {
		Map<Pair<String, Integer>, Type> typedVars = typeinferencer.getTypes();
		System.out.print("Initial state ");
		System.out.println(this.getInitState());
		runningState = this.getInitState();
		boolean flag = true;
		String state = this.getInitState();
		System.out.println("");
		System.out.println("Variables at the beginning of the execution");
		updateFieldsTypes(typedVars);
		if(this.getFields()!=null) {
			System.out.println("Fields:");
			this.printFields();

		}
		if(this.getAssets()!=null) {
			System.out.println("Assets:");
			this.printAssets();
		}
		if(this.getParties()!=null) {
			System.out.println("Parties:");
			for(Party a : this.getParties()) {
				System.out.print("\t");
				a.printParty();
			}
		}
		System.out.println("############");
		for(int i = 0; i<this.getContracts().size(); i++) {
			this.getContract(i).updateTypes(typedVars);
		}
		if(this.getAgreement()!=null) {
			System.out.println("Running the agreement.");
			System.out.println("--------------------");
			for(Party disp : this.getAgreement().getParties()) {
				for(Party disp2 : this.getParties()) {
					if(disp2.getId().equals(disp.getId())) {
						disp2.setUserId(disp.getUserId());
						System.out.println(disp2.getId()+ " " + disp2.getUserId());

					}
				}
			}
			for(Contract c : this.getContracts()) {
				for(Party d : c.getParty()) {
					for(Party d2 : this.getParties()) {
						if(d2.getId().equals(d.getId())) {
							d.setUserId(d2.getUserId());
						}
					}
				}
			}
			System.out.println("--------------------");

			ArrayList<ArrayList<Pair<Field,String>>> valuesAgree = this.getAgreement().askValues();
			if(valuesAgree == null) {flag = false;}
			else{flag = this.getAgreement().doAgree(valuesAgree);}
			if(flag) {
				this.updateFieldsAgreement(valuesAgree);
				typeinferencer.addTypes(valuesAgree);
				typeinferencer.print_map();
				typedVars = typeinferencer.getTypes();
			}
		}
		if(events!=null) {
			for(int index = 0; index<events.size(); index++) {
				long secs = events.get(index).evaluateEvent(this);
				setTimer(index,secs,events.get(index),typeinferencer);
				lock.add(new Object());				
				howManyThreads++;
			}
		}
		boolean found = false;

		while(flag) {
			checkEvent = true;
			state = getRunningState();
			boolean success = true;
			if(running) {caseExec = 10;}
			switch(caseExec) {
			case 0: // first execution

				System.out.println("############");
				if(this.getFields()!=null) {
					System.out.println("Initialized fields:");
					for(Field f : this.getFields()) {
						if(f.getType()!=null && ( f.getType() instanceof TimeType ||  f.getType() instanceof BooleanType || f.getType() instanceof RealType || f.getType() instanceof StringType)) {
							System.out.print("\t");
							f.printField();
						}
					}
				}

				caseExec = 1;
				if(running) {caseExec = 10;}
				break;

			case 1: 
				System.out.println("############");
				System.out.println("# Please, choose which function should run: ");

				for(Contract c : this.getContracts()) {
					boolean rightInitState = false;
					for(String initState : c.getInitState()) {
						if(initState.equals(state)) {
							rightInitState = true;
						}
					}

					if(rightInitState) {
						found = true;
						for(int i=0; i<c.getParty().size(); i++) {
							if(i==0) {
								System.out.print("\t");
							}
							if(i==c.getParty().size()-1) {
								System.out.print(c.getParty().get(i).getId()+".");
							}
							else {
								System.out.print(c.getParty().get(i).getId()+",");
							}
						}
						System.out.print(c.getId()+"(");
						if(c.getVars()!=null){
							for(int i=0; i<c.getVars().size(); i++) {
								if(i!=c.getVars().size()-1) {
									System.out.print(c.getVars().get(i).getType().getTypeName()+" "+c.getVars().get(i).getId()+",");
								}
								else {
									System.out.print(c.getVars().get(i).getType().getTypeName()+" "+c.getVars().get(i).getId());
								}
							}
						}
						System.out.print(")[");
						if(c.getAssets()!=null){
							for(int i=0; i<c.getAssets().size(); i++) {
								if(i!=c.getAssets().size()-1) {
									System.out.print(c.getAssets().get(i).getType().getTypeName()+" "+c.getAssets().get(i).getId()+",");
								}
								else {
									System.out.print(c.getAssets().get(i).getType().getTypeName()+" "+c.getAssets().get(i).getId());
								}
							}
						}
						System.out.println("]");
					}
				}
				if(running) {caseExec = 10;}
				else if(!found && howManyThreads==0) {
					System.out.println("### No more functions to run!");
					System.out.println("############");

					caseExec = 4;
					break;
				}
				else if(!found && howManyThreads!=0) {
					System.out.println("### No more functions to run, but still some events! Waiting..");
					System.out.println("############");
					caseExec = 5; 
					break;
				}
				else if(found){
					caseExec = 3;
					break;
				}

			case 3:
				String s;
				GetInputThread input = new GetInputThread();
				Thread thread = new Thread(input);
				thread.start();
				while (input.getInput().equals("") && !running) {
					Thread.sleep(1500);
				}
				checkEvent = false;
				s = input.getInput();
				thread.interrupt();

				if(running) {
					caseExec = 10;
					break;
				}

				String variables = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
				String assetsVar = s.substring(s.indexOf("[") + 1, s.indexOf("]"));

				String userID = s.substring(0,s.indexOf(".") );
				String nameContract = s.substring(s.indexOf(".") + 1, s.indexOf("("));;

				String[] varsItems = variables.split(",");
				String[] assetsItems = assetsVar.split(",");

				Contract tmpContr = null;
				for(int index=0; index< this.getContracts().size(); index++) {
					Contract c = this.getContracts().get(index);
					boolean rightId = false;
					for(Party d : c.getParty()) {
						if(d.getUserId().equals(userID)) {
							rightId = true;
						}
					}
					boolean rightInitState = false;
					for(String initState : c.getInitState()) {
						if(initState.equals(state)) {
							rightInitState = true;
						}
					}
					if(rightId && c.getId().equals(nameContract) && rightInitState) {
						tmpContr = c;

						boolean emptyVars = varsItems.length==1 && varsItems[0].length()==0 && tmpContr.getVars().size()==0;
						boolean emptyAssets = assetsItems.length==1 && assetsItems[0].length()==0 && tmpContr.getAssets().size()==0;
						boolean equalDimVars = varsItems.length==tmpContr.getVars().size() && varsItems[0].length()!=0 ;
						boolean equalDimAssets = assetsItems.length==tmpContr.getAssets().size() && assetsItems[0].length()!=0 ;

						boolean rightDimVars = emptyVars ||  equalDimVars;
						boolean rightDimAssets = emptyAssets ||  equalDimAssets;

						if(rightDimVars && rightDimAssets) {
							boolean rightTypes = true;
							for(int i=0; i<tmpContr.getVars().size(); i++) {
								DateUtils d = new DateUtils();
								if(d.isValidDate(varsItems[i]) && (!(tmpContr.getVars().get(i).getType() instanceof TimeType) || !(tmpContr.getVars().get(i).getType() instanceof GeneralType))) {
									rightTypes = false;
								}
								else if((varsItems[i].equals("true") || varsItems[i].equals("false")) && !(tmpContr.getVars().get(i).getType() instanceof GeneralType) && !(tmpContr.getVars().get(i).getType() instanceof BooleanType)) {
									rightTypes = false;
								}
								else if(!(tmpContr.getVars().get(i).getType() instanceof GeneralType) && !(tmpContr.getVars().get(i).getType() instanceof RealType) && !(tmpContr.getVars().get(i).getType() instanceof TimeType) && !(tmpContr.getVars().get(i).getType() instanceof StringType)) {
									rightTypes 	= false;
								}
							}
							if(rightTypes) {

								if(assetsItems[0].length()!=0) {
									for(int i=0; i<assetsItems.length; i++) {
										Asset newAsset = new Asset((float) Double.parseDouble(assetsItems[i]));
										newAsset.move((float) Double.parseDouble(assetsItems[i]),tmpContr.getAssets().get(i));
										typeinferencer.addType(tmpContr.getAssets().get(i).getId(), new AssetType(),index);

									}
								}

								if(varsItems[0].length()!=0) {
									for(int i=0; i<varsItems.length; i++) {
										DateUtils d = new DateUtils();
										if(d.isValidDate(varsItems[i]) && (!(tmpContr.getVars().get(i).getType() instanceof TimeType) || !(tmpContr.getVars().get(i).getType() instanceof GeneralType)) ) {
											tmpContr.getVars().get(i).setValue(d.calculateSeconds(varsItems[i])); 
											tmpContr.getVars().get(i).setType(new TimeType());
											typeinferencer.addType(tmpContr.getVars().get(i).getId(), new TimeType(),index);
										}
										else if(Program.isNumeric(varsItems[i])) {

											tmpContr.getVars().get(i).setValue((float) Double.parseDouble(varsItems[i]));
											tmpContr.getVars().get(i).setType(new RealType());
											typeinferencer.addType(tmpContr.getVars().get(i).getId(), new RealType(),index);
										}
										else if(varsItems[i].equals("true") || varsItems[i].equals("false")) {
											tmpContr.getVars().get(i).setValueBool(Boolean.parseBoolean(varsItems[i]));
											tmpContr.getVars().get(i).setType(new BooleanType());
											typeinferencer.addType(tmpContr.getVars().get(i).getId(), new BooleanType(),index);

										}
										else {
											tmpContr.getVars().get(i).setValueStr(varsItems[i]);
											tmpContr.getVars().get(i).setType(new StringType());
											typeinferencer.addType(tmpContr.getVars().get(i).getId(), new StringType(),index);

										}
									}
								}

								if(tmpContr.getVars()!=null) {
									for(int j=0; j<tmpContr.getVars().size(); j++) {
										tmpContr.getVars().get(j).printField();
									}
								}
								if(tmpContr.getAssets()!=null) {
									for(int j=0; j<tmpContr.getAssets().size(); j++) {
										tmpContr.getAssets().get(j).printAsset();
									}
								}

								System.out.println("Executing...");
								typedVars = typeinferencer.getTypes();
								success = tmpContr.runContract(typeinferencer,index);

								this.updateFields(tmpContr);
								this.updateAssets(tmpContr);
								this.updateParties(tmpContr);
								for(Field f : tmpContr.getVars()) {
									typeinferencer.addType(f.getId(),f.getType(),index);
								}
								for(Field f : tmpContr.getGlobalVars()) {
									typeinferencer.addType(f.getId(),f.getType(),0);
								}
								System.out.println("=====TYPES======");
								typedVars = typeinferencer.getTypes();
								typeinferencer.print_map();

								System.out.println("================");

								typedVars = typeinferencer.getTypes();
								if(tmpContr.getVars()!=null) {
									for(int j=0; j<tmpContr.getVars().size(); j++) {
										tmpContr.getVars().get(j).printField();
									}
								}
								if(tmpContr.getAssets()!=null) {
									for(int j=0; j<tmpContr.getAssets().size(); j++) {
										tmpContr.getAssets().get(j).printAsset();
									}
								}
								System.out.println("Updated fields:");
								this.printFields();
								System.out.println("Updated assets:");
								this.printAssets();
								System.out.println("Updated parties:");
								this.printParties();


							}
						}
					}
				}
				if(running) {caseExec = 10;}
				if(!running && tmpContr!=null && success) {
					state = tmpContr.getEndState();
					runningState = tmpContr.getEndState();
					System.out.println("############");
					System.out.println("Next state " + state);
					caseExec = 1;
				}
				if(!running && ((!success && tmpContr==null)|| !found) && howManyThreads==0) {
					caseExec = 4;
				}
				else if(!running && ((!success && tmpContr==null)|| !found) && howManyThreads!=0) {
					caseExec = 5;

				}
				found = false;
				break;

			case 4:
				if(running) {
					caseExec = 10;
					break;
				}
				else {
					for(Timer t_i : timer) {
						t_i.cancel();
						t_i.purge();
					}
				}
				System.out.println("Fields at the end of the execution:");
				this.printFields();

				System.out.println("Assets at the end of the execution:");
				this.printAssets();
				flag = false;
				break;


			case 10:
				synchronized (lock) {
					try {
						lock.wait();

					} catch(InterruptedException e) {
					}	
				}
				found = false;
				caseExec = 1;
				break;

			}
		}
		System.out.println("############");
		System.out.println("Execution completed.");
	}


}
