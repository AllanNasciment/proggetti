package biblioteca;

public class BibliotecaTest {

    public static void main(String[] args) {
        Libro[] libri = {
            new Libro("000","Facio libri","Roberto Aufonso","1672"),
            new Libro("001","amo libri","Roberto Aufonso dos Santos","1950")
        };
        Biblioteca bib = new Biblioteca(libri);
        System.out.println(bib.getLibroFromCodice("0001")!=null);
    }
    
}
