public final class License {

    public static int Licensor;
    public static int Licensee;
    public static boolean LicensorBalance;
    public static boolean LicenseeBalance;
    public static boolean balance;
    public static boolean LicensorToken;
    public static boolean LicenseeToken;
    public static boolean token;
    public static int t_start;
    public static int t_limit;
    public static int cost;
    public static int code;
    public static int LicenseeCode;
    public static int b;
    public static int x;
    public static int n;
    public static boolean ev_event1;
    public static boolean ev_event2;

    /*@ public normal_behavior
      @ ensures     LicensorToken == false && token == true && code == x;
      @ assignable  LicensorToken, code, token;
      @*/
    public final static void offerLicense(int x, boolean n) {
        token = true;
        LicensorToken = false;
        code = x;
    }

    /*@ public normal_behavior
      @ requires    b==cost;
      @ ensures     balance == true && LicenseeBalance == false && LicenseeCode == code;
      @ assignable  LicenseeBalance, LicenseeCode, balance;
      @*/
    public final static void activateLicense(boolean b) {
        balance = true;
        LicenseeBalance = false;
        LicenseeCode = code;
    }

    /*@ public normal_behavior
      @ ensures     balance == false && LicensorBalance == true && LicenseeToken == true && token == false;
      @ assignable  LicenseeToken, LicensorBalance, balance, token;
      @*/
    public final static void buy() {
        LicensorBalance = true;
        balance = false;
        LicenseeToken = true;
        token = false;
    }

    /*@ public normal_behavior
      @ ensures     LicensorToken == true && token == false;
      @ assignable LicensorToken, token;
      @*/
    public final static void event1() {
        LicensorToken = true;
        token = false;
    }

    /*@ public normal_behavior
      @ ensures     balance == false && LicenseeBalance == true && LicensorToken == true && token == false;
      @ assignable LicenseeBalance, LicensorToken, balance, token;
      @*/
    public final static void event2() {
        LicenseeBalance = true;
        balance = false;
        LicensorToken = true;
        token = false;
    }

    /*@ public normal_behavior
      @ requires b==cost;
      @ ensures (
      @   (ev_event1 && LicensorToken == false && token == true && code == x)
      @   || (!ev_event1 && ev_event2 && LicensorToken == false && token == true && code == x && balance == true && LicenseeBalance == false && LicenseeCode == code)
      @   || (!ev_event1 && !ev_event2 && LicensorToken == false && token == true && code == x && balance == true && LicenseeBalance == false && LicenseeCode == code && LicensorBalance == true && LicenseeToken == true)
      @ );
      @*/
    public final static void seq1() {
        offerLicense(x, n);
        if(ev_event1){
            event1();
            return;
        }
        activateLicense(b);
        if(ev_event2){
            event2();
            return;
        }
        buy();
    }

}
