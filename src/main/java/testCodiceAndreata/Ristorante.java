package testCodiceAndreata;

public class Ristorante {
    private Tavolo[] tavoli;
    
    public Ristorante(Tavolo[] tavoli){
        this.tavoli = new Tavolo[tavoli.length];
        for(int i=0 ; i<tavoli.length ; i++){
            this.tavoli[i] = new Tavolo(tavoli[i]);
        }
    }
}
