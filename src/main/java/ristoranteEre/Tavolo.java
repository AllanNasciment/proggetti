package ristoranteEre;

public class Tavolo {
    private static int numNextTav=1;
    private int num;
    private int capienza;
    private int nPersone;
    private boolean prenotato;
    
    public Tavolo(Tavolo tav){
        this.num = tav.num;
        this.capienza = tav.capienza;
        this.nPersone = tav.nPersone;
        this.prenotato = tav.prenotato;
    }

    public Tavolo(int capienza, int nPersone, boolean prenotato) {
        this.num = numNextTav;
        this.capienza = capienza;
        this.nPersone = nPersone;
        this.prenotato = prenotato;
        numNextTav++;
    }
    
    
    public int getNPersone(){
        return nPersone;
    }

    public int getNum() {
        return num;
    }
    
    public String siedi(){
        String risult="non c'era spazio nell tavolo\n";
        if(nPersone<capienza){
            nPersone++;
            prenotato=true;
            risult="la persone si e seduta\n";
        }
        return risult;
    }
    
    public String alzati(){
        String risult="non c'era nessuno nell tavolo\n";
        if(nPersone>0){
            nPersone--;
            risult="una persona si e alzata\n";
        }else if(nPersone==1){
            prenotato=false;
        }
        return risult;
    }
    
    public String prenota(int persone){
        String risult="il tavolo e gia occupato\n";
        if(capienza-nPersone>=persone && !prenotato){
            nPersone = persone;
            prenotato = true;
            risult="il tavolo è stato prenotato\n";
        }
        return risult;
    }
    
    public static Tavolo getTavFromNum(Tavolo[] tav, int num,int dimL){
        Tavolo risult = null;
        for(int i=0 ; i<dimL ; i++){
            if(tav[i].num==num){
                risult = tav[i];
                i=dimL;
            }
        }
        return risult;
    }
    
    public static int getTavIndexFromNum(Tavolo[] tav, int num,int dimL){
        int risult = 0;
        for(int i=0 ; i<dimL ; i++){
            if(tav[i].num==num){
                risult = i;
                i=dimL;
            }
        }
        return risult;
    }
    
    public static void resetNumNextTav(){
        numNextTav=1;
    }
    
    public String toString() {
        return "num:"+num+"  capienza:"+capienza+"  nPersone:"+nPersone+"  prenotato:"+prenotato;
    }
    
    
}
