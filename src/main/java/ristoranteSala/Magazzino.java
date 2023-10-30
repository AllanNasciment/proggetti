package ristoranteSala;

public class Magazzino {
    private Tavolo[] tavoli;
    private int dimL;
    
    public Magazzino(int dimF){
        tavoli = new Tavolo[dimF];
        dimL=0;
    }
    
    public void addTavolo(Tavolo tavolo){
        if(dimL < tavoli.length){
            tavoli[dimL] = tavolo;
            dimL++;
        }
    }
    
    public Tavolo getTavFromNum(int numTav){
        Tavolo risult=null;
        int index = getIndexTavFromNum(numTav);
        if(index>=0){
            risult = tavoli[index];
        }
        return risult;
    }
    
    public void rmvTavolo(int numTav){
        int index = getIndexTavFromNum(numTav);
        if(index>=0){
            leftShift(index);
        }
    }
    
    public void leftShift(int index){
        for(int i=index ; i<dimL-1 ; i++){
            tavoli[i] = tavoli[i+1];
        }
        dimL--;
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
    
    public String toString() {
        String risult="";
        for(int i=0 ; i<dimL ; i++){
            risult+=tavoli[i].toString()+"\n";
        }
        return risult;
    }
}
