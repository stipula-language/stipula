public final class Bet {

    public static int Better1;
    public static int Better2;
    public static int DataProvider;
    public static boolean Better1Wallet1;
    public static boolean Better2Wallet1;
    public static boolean DataProviderWallet1;
    public static boolean wallet1;
    public static boolean Better1Wallet2;
    public static boolean Better2Wallet2;
    public static boolean DataProviderWallet2;
    public static boolean wallet2;
    public static int val1;
    public static int val2;
    public static int event;
    public static int amount;
    public static int t_before;
    public static int t_after;
    public static int x;
    public static int h;
    public static int z;
    public static boolean ev_event1;
    public static boolean ev_event2;

    /*@ public normal_behavior
      @ requires    h==amount;
      @ ensures     Better1Wallet1 == false && wallet1 == true && val1 == x;
      @ assignable  Better1Wallet1, val1, wallet1;
      @*/
    public final static void place_bet(int x, boolean h) {
        wallet1 = true;
        Better1Wallet1 = false;
        val1 = x;
    }

    /*@ public normal_behavior
      @ requires    h==amount;
      @ ensures     Better2Wallet2 == false && wallet2 == true && val2 == x;
      @ assignable  Better2Wallet2, val2, wallet2;
      @*/
    public final static void place_bet1(int x, boolean h) {
        wallet2 = true;
        Better2Wallet2 = false;
        val2 = x;
    }

    /*@ public normal_behavior
      @ requires    x==event;
      @ ensures     ((z==val1&&z==val2 && Better1Wallet1 == true && wallet1 == false && Better2Wallet2 == true && wallet2 == false) || ((!(z==val1&&z==val2)) && z==val1&&z!=val2 && wallet2 == false && Better1Wallet2 == true && Better1Wallet1 == true && wallet1 == false) || ((!(z==val1&&z!=val2)) && (!(z==val1&&z==val2)) && z!=val1&&z==val2 && Better2Wallet1 == true && wallet1 == false && Better2Wallet2 == true && wallet2 == false) || (!(z==val1&&z==val2) && !(z==val1&&z!=val2) && !(z!=val1&&z==val2) && DataProviderWallet2 == true && wallet2 == false && DataProviderWallet1 == true && wallet1 == false));
      @ assignable  Better1Wallet1, Better1Wallet2, Better2Wallet1, Better2Wallet2, DataProviderWallet1, DataProviderWallet2, wallet1, wallet2;
      @*/
    public final static void data(int x, int z) {
        if (z==val1&&z==val2) {
            Better1Wallet1 = true;
            wallet1 = false;
            Better2Wallet2 = true;
            wallet2 = false;
    } else if (z==val1&&z!=val2) {
            Better1Wallet2 = true;
            wallet2 = false;
            Better1Wallet1 = true;
            wallet1 = false;
    } else if (z!=val1&&z==val2) {
            Better2Wallet1 = true;
            wallet1 = false;
            Better2Wallet2 = true;
            wallet2 = false;
    } else {
            DataProviderWallet2 = true;
            wallet2 = false;
            DataProviderWallet1 = true;
            wallet1 = false;
    }
    }

    /*@ public normal_behavior
      @ ensures     Better1Wallet1 == true && wallet1 == false;
      @ assignable Better1Wallet1, wallet1;
      @*/
    public final static void event1() {
        Better1Wallet1 = true;
        wallet1 = false;
    }

    /*@ public normal_behavior
      @ ensures     Better1Wallet1 == true && wallet1 == false && Better2Wallet2 == true && wallet2 == false;
      @ assignable Better1Wallet1, Better2Wallet2, wallet1, wallet2;
      @*/
    public final static void event2() {
        Better1Wallet1 = true;
        wallet1 = false;
        Better2Wallet2 = true;
        wallet2 = false;
    }

    /*@ public normal_behavior
      @ requires h==amount &&
      @          x==event;
      @ ensures (
      @   (ev_event1 && Better1Wallet1 == false && wallet1 == true && val1 == x)
      @   || (!ev_event1 && ev_event2 && Better1Wallet1 == false && wallet1 == true && val1 == x && Better2Wallet2 == false && wallet2 == true && val2 == x)
      @   || (!ev_event1 && !ev_event2 && Better1Wallet1 == false && wallet1 == true && val1 == x && Better2Wallet2 == false && wallet2 == true && val2 == x && Better1Wallet2 == true && Better2Wallet1 == true && DataProviderWallet1 == true && DataProviderWallet2 == true)
      @ );
      @*/
    public final static void seq1() {
        place_bet(x, h);
        if(ev_event1){
            event1();
            return;
        }
        place_bet1(x, h);
        if(ev_event2){
            event2();
            return;
        }
        data(x, z);
    }

}
