public final class Deposit {

    public static int Client;
    public static int Farm;
    public static int ClientFlour;
    public static int FarmFlour;
    public static int flour;
    public static int cost_flour;
    public static int h;
    public static int c_w;
    public static int c_h;
    public static int counter;
    public static boolean ev_event1;
    public static boolean ev_event2;

    /*@ public normal_behavior
      @ ensures     flour == \old(flour)  + h && FarmFlour == \old(FarmFlour)  - h;
      @ assignable  FarmFlour, flour;
      @*/
    public final static void begin(boolean h) {
        flour += h;
        FarmFlour -= h;
    }

    /*@ public normal_behavior
      @ ensures     flour == \old(flour)  + h && FarmFlour == \old(FarmFlour)  - h;
      @ assignable  FarmFlour, flour;
      @*/
    public final static void send(boolean h) {
        flour += h;
        FarmFlour -= h;
    }

    /*@ public normal_behavior
      @ requires    w/cost_flour<=flour;
      @ ensures     ClientFlour == \old(ClientFlour)  + (w/cost_flour) && flour == \old(flour)  - (w/cost_flour) && Farm == \old(Farm)  + w && Client == \old(Client)  - w;
      @ assignable  Client, ClientFlour, Farm, flour;
      @*/
    public final static void buy(boolean w) {
        ClientFlour += (w*1 / cost_flour);
        flour -= (w*1 / cost_flour);
        Farm += w;
        Client -= w;
    }

    /*@ public normal_behavior
      @ ensures     flour == false && FarmFlour == true;
      @ assignable FarmFlour, flour;
      @*/
    public final static void event1() {
        FarmFlour += flour;
        flour = 0;
    }

    /*@ public normal_behavior
      @ ensures     flour == false && FarmFlour == true;
      @ assignable FarmFlour, flour;
      @*/
    public final static void event2() {
        FarmFlour += flour;
        flour = 0;
    }

    /*@ public normal_behavior
      @ requires counter >= 0;
      @ ensures Client == \old(Client)+ counter * (- w) &&
      @         ClientFlour == \old(ClientFlour)+ counter * (+ (w/cost_flour)) &&
      @         Farm == \old(Farm)+ counter * (+ w) &&
      @         FarmFlour == \old(FarmFlour)- h + counter * (- h) &&
      @         flour == \old(flour)+ h + counter * (- (w/cost_flour)  + h);
      @*/
    public final static void seq1() {
        begin(h);
        if(ev_event1){
            event1();
            return;
        }
        if(ev_event2){
            event2();
            return;
        }
        int i=0;
        /*@ loop_invariant 0 <= i && i <= counter;
          @ loop_invariant c_w/cost_flour<=flour;
          @ loop_invariant ClientFlour == \old(ClientFlour) + i * (+ c_(w/cost_flour));
          @ loop_invariant flour == \old(flour) + i * (- c_(w/cost_flour)  + c_h);
          @ loop_invariant Farm == \old(Farm) + i * (+ c_w);
          @ loop_invariant Client == \old(Client) + i * (- c_w);
          @ loop_invariant FarmFlour == \old(FarmFlour) + i * (- c_h);
          @ assignable Client, ClientFlour, Farm, FarmFlour, flour, i;
          @ decreases counter - i;
         @*/
        while(i < counter) {
            buy(c_w);
            send(c_h);
            i++;
        }
    }

}
