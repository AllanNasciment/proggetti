package ristoranteEre;

public class Ristorante {
    private Sala[] sale;
    private Magazzino magazzino;
    
    public Ristorante(Sala[] sale){
        Tavolo.resetNumNextTav();
        this.sale = copiaSale(sale);
        magazzino = new Magazzino(this.sale.length*5);
    }
    
    public Ristorante(int numSale){
        Tavolo.resetNumNextTav();
        this.sale = new Sala[numSale];
        this.sale = copiaSale();
    }
    
    private Sala[] copiaSale(Sala[] sale){
        Sala[] risult=new Sala[sale.length];
        for(int i=0 ; i<sale.length ; i++)
            risult[i] = new Sala(sale[i]);
        return risult;
    }
    
    private Sala[] copiaSale(){
        Sala[] risult=new Sala[sale.length];
        for(int i=0 ; i<sale.length ; i++)
            risult[i] = new Sala();
        return risult;
    }
    
    public String numTotPersone(){
        String risult="il numero totale di persone nell ristorante è ";
        int somma=0;
        int i=0;
        while(i<sale.length){
            somma += sale[i].nPersoneTot();
            i++;
        }
        return risult+somma;
    }
    
    public String toString(){
        String risult="";
        for(int i=0 ; i<sale.length ; i++){
            risult+="--- Sala "+(i+1)+" ---\n"+sale[i].toString();
        }
        return risult;
    }

}
