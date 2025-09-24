public final class Loan {

    public static int Client;
    public static int Bank;
    public static int interest_rate;
    public static int amount;
    public static int w;
    public static int h;
    public static boolean ev_event1;
    public static boolean ev_event2;
    public static boolean ev_event3;

    /*@ public normal_behavior
      @ requires    w==amount;
      @ ensures     Bank == \old(Bank)  - w && Client == \old(Client)  + w;
      @ assignable  Bank, Client;
      @*/
    public final static void give_money(boolean w) {
        Client += w;
        Bank -= w;
    }

    /*@ public normal_behavior
      @ requires    h==(amount*(1+interest_rate))/3;
      @ ensures     Bank == \old(Bank)  + h && Client == \old(Client)  - h;
      @ assignable  Bank, Client;
      @*/
    public final static void pay_installment(boolean h) {
        Bank += h;
        Client -= h;
    }

    /*@ public normal_behavior
      @ requires    h==(amount*(1+interest_rate))/3;
      @ ensures     Bank == \old(Bank)  + h && Client == \old(Client)  - h;
      @ assignable  Bank, Client;
      @*/
    public final static void pay_installment1(boolean h) {
        Bank += h;
        Client -= h;
    }

    /*@ public normal_behavior
      @ requires    h==(amount*(1+interest_rate))/3;
      @ ensures     Bank == \old(Bank)  + h && Client == \old(Client)  - h;
      @ assignable  Bank, Client;
      @*/
    public final static void pay_installment2(boolean h) {
        Bank += h;
        Client -= h;
    }

    /*@ public normal_behavior
      @*/
    public final static void withdraw() {
    }

    /*@ public normal_behavior
      @*/
    public final static void event1() {
    }

    /*@ public normal_behavior
      @*/
    public final static void event2() {
    }

    /*@ public normal_behavior
      @*/
    public final static void event3() {
    }

    /*@ public normal_behavior
      @ requires w==amount &&
      @          h==(amount*(1+interest_rate))/3;
      @ ensures (
      @   (ev_event1 && Bank == \old(Bank)  - w && Client == \old(Client)  + w)
      @   || (!ev_event1 && ev_event2 && Bank == \old(Bank)  - w  + h && Client == \old(Client)  + w  - h)
      @   || (!ev_event1 && !ev_event2 && ev_event3 && Bank == \old(Bank)  - w  + h  + h && Client == \old(Client)  + w  - h  - h)
      @   || (!ev_event1 && !ev_event2 && !ev_event3 && Bank == \old(Bank)  - w  + h  + h  + h && Client == \old(Client)  + w  - h  - h  - h)
      @ );
      @*/
    public final static void seq1() {
        give_money(w);
        if(ev_event1){
            event1();
            return;
        }
        pay_installment(h);
        if(ev_event2){
            event2();
            return;
        }
        pay_installment1(h);
        if(ev_event3){
            event3();
            return;
        }
        pay_installment2(h);
    }

    /*@ public normal_behavior
      @*/
    public final static void seq2() {
        withdraw();
    }

}
