package ripassoVerifica;

public class MeleTest {

    public static void main(String[] args) {
        
        Mele testMele = new Mele();
        testMele.addGiornata("lunedi", 80);
        testMele.addGiornata("martedi", 65);
        testMele.addGiornata("sabato", 130);
        System.out.println(testMele.stampa());
        testMele.eliminaGiorno(0);
        System.out.println(testMele.stampa());
        
    }
    
}
