package funzioneClass;
import java.util.function.*;

public class FunzioneClass {
    
    public int test(int num){
        return num*num;
    }
    
    public static void main(String[] args){ 
        Function <Integer,Integer> sqrRoot = x -> x*x;
        System.out.println("La radice quadrata e : "+sqrRoot.apply(3));
        
    }
    
}
