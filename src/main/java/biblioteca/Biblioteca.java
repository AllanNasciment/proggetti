package biblioteca;

public class Biblioteca {
    private Libro[] libri;
    private int dimL;
    private int dimF;
    
    public Biblioteca(Libro[] lib){
        this.libri = new Libro[lib.length];
        for(int i=0 ; i<libri.length ; i++)
            this.libri[i] = new Libro(lib[i]);
        dimL=lib.length;
        dimF=lib.length;
    }
    
    public Libro getLibroFromCodice(String codice){
        Libro risult = null;
        int i=0;
        while(i<dimL){
            if(codice.trim().equals(libri[i].getCodice())){
                risult=new Libro(libri[i]);
                i=dimL;
            }
            i++;
        }
        return risult;
    }
    
    public String toString(){
        String risult="";
        for(int i=0 ; i<dimL ; i++)
            risult+="Libro["+i+"] : \n"+libri[i].toString()+"\n";
        return risult;
    }
}
