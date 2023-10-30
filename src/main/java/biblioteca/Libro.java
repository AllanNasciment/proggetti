package biblioteca;

public class Libro {
    private String codice;
    private String casaEditrice;
    private String autore;
    private String annoPubb;

    public Libro(String codice, String casaEditrice, String autore, String annoPubb) {
        this.codice = codice;
        this.casaEditrice = casaEditrice;
        this.autore = autore;
        this.annoPubb = annoPubb;
    }
    
    public Libro(Libro libro){
        this.codice = libro.codice;
        this.casaEditrice = libro.casaEditrice;
        this.autore = libro.autore;
        this.annoPubb = libro.annoPubb;
    }

    public String getCodice() {
        return codice;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public String getAutore() {
        return autore;
    }

    public String getAnnoPubb() {
        return annoPubb;
    }
    
    public String toString() {
        return "codice:"+codice+"  casaEditrice:"+casaEditrice+"  autore:"+autore+"  annoPubb:"+annoPubb;
    }
}
