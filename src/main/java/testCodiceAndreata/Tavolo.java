package testCodiceAndreata;

public class Tavolo {
    
    private int num;
    
    public Tavolo(int num){
        this.num = num;
    }
    
    public Tavolo(Tavolo tavolo){
        this.num = tavolo.num;
    }
    
}
