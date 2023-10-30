package ristoranteSala;

public class Ristorante {
    private Sala[] sale;
    private Magazzino magazzino;
    
    public Ristorante(int nSale, int dimFmagazzino){
        int i=0;
        this.magazzino = new Magazzino(dimFmagazzino);
        this.sale = new Sala[nSale]; 
        while(i<nSale){
            sale[i] = new Sala(5*i,magazzino);
            i++;
        }
    }
    
    public String siedi(int nTavolo,int nSala){
        return sale[nSala-1].siedi(nTavolo);
    }
    
    public String alzati(int nTavolo,int nSala){
        return sale[nSala-1].alzati(nTavolo);
    }
    
    public String prenota(int nTavolo,int nPersone,int nSala){
        return sale[nSala-1].prenota(nTavolo,nPersone);
    }
    
    public String takeTavoloMag(int numTav,int nSala){
        return sale[nSala-1].addTavolo(numTav);
    }
    
    public String putTavoloMag(int nTavolo,int nSala){
        return sale[nSala-1].rmvTavolo(nTavolo);
    }
    
    private int tavoliTotale(){
        int risult=0;
        for(int i=0 ; i<sale.length ; i++)
            risult+=sale[i].getNumTotTav();
        return risult;
    }
    
    public String toString(){
        String risult="";
        for(int i=0 ; i<sale.length ; i++){
            risult+="--- Sala "+(i+1)+" ---\n"+sale[i].toString();
        }
        risult+="- - - Magazzino - - -\n"+magazzino.toString();
        return risult;
    }
}
