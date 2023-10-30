package usefulInstructions;

public class Printf {

    public static void main(String[] args) {
        // printf è un print che pero puo modificare i dati stampati con
        //%[flags] [precision] [width] [conversion-character]
        //i tipi di [coversion-character] sono :
        // %d int
        // %f float/double
        // %c char
        // %s String
        // %b boolean
        System.out.printf("ciao %d \n",122);
        
        //invecce [width] determina una lunghezza minima per il valore
        System.out.printf("ciao %10d \n",122);
        
        //se vuoi che sia orientato verso sinistra:
        System.out.printf("ciao %-10d \n",122);
        
        //e se inserisci un zero prima di [width] il prntf riempira 
        //lo spazio vuoto con zeri
        System.out.printf("ciao %010d \n",122);
        
        //per la [precision] devi mettere un float/double per funzionare
        //e quello che fa e determinare quanti numeri dopo la virgola inserire
        System.out.printf("ciao %.2f \n",122.00000);
        
        //per numeri molto grandi puoi anche fare in modo che inserisca
        //una virgola nell posto delle centene:
        System.out.printf("ciao %,d",1220000);
    }
    
}
