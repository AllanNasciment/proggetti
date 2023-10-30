package ristoranteSala;

public class Sala {
    private Tavolo[] tavoli;
    private Magazzino magazzino;
    private int dimL;
    
    public Sala(Tavolo[] tavoli , Magazzino mag){
        this.tavoli = new Tavolo[tavoli.length];
        dimL = tavoli.length;
        for(int i=0 ; i<tavoli.length ; i++){
            this.tavoli[i] = new Tavolo(tavoli[i]); 
        }
        magazzino = mag;
    }
    
    public Sala(Sala sala){
        this.tavoli = sala.tavoli;
        this.dimL = sala.dimL;
        this.magazzino = sala.magazzino;
    }
    
    public Sala(int numTavIniz , Magazzino mag){
        int numTav = 5;
        this.tavoli = new Tavolo[numTav];
        dimL = numTav;
        for(int i=0 ; i<numTav ; i++)
            tavoli[i] = new Tavolo(numTavIniz+i+1,4,0,false);
        magazzino = mag;
    }
    
    public String toString() {
        String risult="";
        for(int i=0 ; i<dimL ; i++){
            risult+=tavoli[i].toString()+"\n";
        }
        return risult;
    }
    
    public String siedi(int numTav){
        String risult="non c'e un tavolo con questo numero nella sala\n";
        int index = getIndexTavFromNum(numTav);
        if(index>=0){
            risult = tavoli[getIndexTavFromNum(numTav)].siedi();
        }
        return risult;
    }
    
    public String prenota(int numTav,int nPersone){
        String risult="non c'e un tavolo con questo numero nella sala\n";
        int index = getIndexTavFromNum(numTav);
        if(index>=0){
            risult = tavoli[getIndexTavFromNum(numTav)].prenota(nPersone);
        }
        return risult;
    }
    
    public String alzati(int numTav){
        String risult="non c'e un tavolo con questo numero nella sala\n";
        int index = getIndexTavFromNum(numTav);
        if(index>=0){
            risult = tavoli[getIndexTavFromNum(numTav)].alzati();
        }
        return risult;
    }
    
    public String addTavolo(int numTav){
        String risult="non c'e spazio per il tavolo nella sala";
        Tavolo tav = magazzino.getTavFromNum(numTav);
        if(tav!=null){
            if(dimL < tavoli.length){
                risult="Il tavolo è stato aggiunto alla sala";
                magazzino.rmvTavolo(numTav);
                tavoli[dimL] = tav;
                dimL++;
            }
        }else{
            risult = "non c'e un tavolo con quel numero nel magazzino";
        }
        return risult;
    }
    
    public String rmvTavolo(int numTav){
        String risult="non c'e un tavolo con questo numero nella sala";
        int index = getIndexTavFromNum(numTav);
        if(dimL>0 && index>=0){
            risult = "il tavolo è stato rimoso";
            magazzino.addTavolo(tavoli[index]);
            leftShift(index);
        }
        return risult;
    }
    
    public void leftShift(int index){
        for(int i=index ; i<dimL-1 ; i++){
            tavoli[i] = tavoli[i+1];
        }
        dimL--;
    }
    
    public int getNumTotTav(){
        return dimL;
    }
    
    private int getIndexTavFromNum(int numTav){
        int risult = -1;
        for(int i=0 ; i<dimL ; i++){
            if(tavoli[i].getNum()==numTav){
                risult = i;
                i=dimL;
            }
        }
        return risult;
    }
}
