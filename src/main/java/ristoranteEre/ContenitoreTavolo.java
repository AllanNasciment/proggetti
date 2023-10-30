package ristoranteEre;

abstract class ContenitoreTavolo {
    private Tavolo[] tavoli;
    private int dimL;
    
    public ContenitoreTavolo(Tavolo[] tavoli){
        this.tavoli = new Tavolo[tavoli.length];
        dimL = tavoli.length;
        for(int i=0 ; i<tavoli.length ; i++){
            this.tavoli[i] = new Tavolo(tavoli[i]); 
        }
    }
    
    public ContenitoreTavolo(ContenitoreTavolo contTav){
        this.tavoli = contTav.tavoli;
        this.dimL = contTav.dimL;
    }
    
    public ContenitoreTavolo(){
        int numTav = 5;
        this.tavoli = new Tavolo[numTav];
        dimL = numTav;
        for(int i=0 ; i<numTav ; i++)
            tavoli[i] = new Tavolo(4,0,false);
    }
    
    public ContenitoreTavolo(int dimF){
        this.tavoli = new Tavolo[dimF];
        this.dimL = 0;
    }

    public int getDimL() {
        return dimL;
    }

    public Tavolo[] getTavoli() {
        return tavoli;
    }
    
    public String toString() {
        String risult="";
        for(int i=0 ; i<dimL ; i++){
            risult+=tavoli[i].toString()+"\n";
        }
        return risult;
    }
    
    public void addTavolo(Tavolo tavolo){
        tavoli[dimL] = tavolo;
        dimL++;
    }
    
    public Tavolo rmvTavolo(int numTav){
        Tavolo risult = Tavolo.getTavFromNum(tavoli, numTav, dimL);
        if(risult!=null){
            leftShift(Tavolo.getTavIndexFromNum(tavoli, numTav, dimL));
        }else{
            risult = null;
        }
        return risult;
    }
    
    public void leftShift(int index){
        for(int i=index ; i<dimL-1 ; i++){
            tavoli[i] = tavoli[i+1];
        }
        dimL--;
    }
}
