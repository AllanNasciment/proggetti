package classeOggetto;

public class Oggetto {
    /*
    questo codice serve per mostrare come usare la classe Object.
    Cosa è la classe Object? 
        Object è una classe che viene ereditata da tutte le classi 
        create, di conseguenza dato la relazione is-a tra classi ereditate
        anche sotto classi di classi diverse da Object sono di tipo Object.
    Quale l'uso?
        Dato che tutti gli oggetti sono ,anche, di tipo Object si puo
        creare una variabile formale di tipo Object che accetera qualsia 
        oggetto di qualsiasi classe.
    */
    private int a;
    
    public Oggetto(int a){
        this.a = a;
    }
    
    /*
    Override è solo una anotazione per far capire al lettore che 
    stai riscrivendo la definizione di questo metodo.
    */
    @Override
    public boolean equals(Object obj) {
        boolean risult=false;
        if(obj instanceof Oggetto){
            /*
            instanceof è un operatore che ha la sintasi: Object instanceof Class
            ritorna true quando l'oggetto è dell tipo della classe
            */
            Oggetto altroOgg = (Oggetto)obj;
            risult = (altroOgg.a == this.a);
        }
        return risult;
    }
    
    public static void main(String[] args) {
        
        Oggetto ogg1 = new Oggetto(5);
        Oggetto ogg2 = new Oggetto(5);
        System.out.println(ogg1.equals(5));
        /*
        Grazie alle classi Wrapper anche se passo da parametro un tipo 
        primitivo come un int il compilatore lo traduce come un oggetto 
        della classe Wrapper corispondente
        */
    }
    
}
