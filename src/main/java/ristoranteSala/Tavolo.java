package ristoranteSala;

public class Tavolo {
    private int num;
    private int capienza;
    private int nPersone;
    private boolean prenotato;
    
    public Tavolo(int num,int capienza,int nPersone,boolean prenotato){
        this.num = num;
        this.nPersone = nPersone;
        this.capienza = capienza;
        this.prenotato = prenotato;
    }
    
    public Tavolo(Tavolo tav){
        this.num = tav.num;
        this.nPersone = tav.nPersone;
        this.capienza = tav.capienza;
        this.prenotato = tav.prenotato;
    }
    
    public int getNPersone(){
        return nPersone;
    }

    public int getNum() {
        return num;
    }
    
    public boolean getPrenotato(){
        return prenotato;
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
        }
        if(nPersone==0){
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
    
    public String toString(){
        return "num: "+num+"  nPersone: "+nPersone+"  capienza: "+capienza+"  prenotato: "+prenotato;
    }
}
