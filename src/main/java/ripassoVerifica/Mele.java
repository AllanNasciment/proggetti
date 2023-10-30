package ripassoVerifica;

public class Mele {
    private String[] giorno;
    private int[] mele;
    private int dimL;
    
    public Mele(){
        giorno = new String[7];
        mele = new int[7];
        dimL=0;
    }
    
    public void addGiornata(String giorno , int mele){
        //faccio questo controllo per quando finisce la setimana, in tale caso pulisco l'array 
        if(dimL == 7){
            this.giorno[0] = giorno;
            this.mele[0] = mele;
            dimL=1;
        }else{
            this.giorno[dimL] = giorno;
            this.mele[dimL] = mele;
            dimL++;
        }
    }
    
    public String totaleRaccolto(){
        String risult="il raccolto totale e' : "+sommaMele();
        return risult;
    }
    
    private int sommaMele(){
        int somma=0;
        for(int i=0 ; i<dimL ; i++){
            somma+=mele[i];
        }
        return somma;
    }
    
    public String mediaRaccolto(){
        double media=sommaMele()/dimL;
        String risult="la media settimanale e' : "+media;
        return risult;
    }
    
    public String giorniMaggQuantita(int min){
        String risult = "";
        for(int i=0 ; i<dimL ; i++){
            if(mele[i]>min)
                risult+=giorno[i]+" ,";
        }
        return risult+" hanno raccolti sopra "+min;
    }
    
    public String raccoltiSabato(){
        String risult="sabato non e' stato inserito";
        for(int i=0 ; i<dimL ; i++){
            if(giorno[i].equalsIgnoreCase("sabato")){
                risult="il raccolto nel sabato è' di "+mele[i]+" mele";
                i=dimL;
            }
        }
        return risult;
    }
    
    public void eliminaGiorno(int index){
        if(index<dimL){
            shiftLeft(index);
        }
    }
    
    private void shiftLeft(int index){
        for(int i=index ; i<dimL-1 ; i++){
            giorno[i]=giorno[i+1];
            mele[i]=mele[i+1];
        }
        dimL--;
    }
    
    public String stampa(){
        String risult = "";
        for(int i=0 ; i<dimL ; i++){
            risult+=giorno[i]+": "+mele[i]+" mele\n";
        }
        return risult;
    }
}
