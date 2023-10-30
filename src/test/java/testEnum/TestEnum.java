package testEnum;

public class TestEnum {
    
    enum Voto{
        DIECI(true),
        NOVE(true),
        OTTO(true),
        SETTE(true),
        SEI(true),
        CINQUE(false),
        QUATTRO(false);
        
        private Voto(boolean pos){
            positivo =pos;
        }

        public boolean isPositivo() {
            return positivo;
        }
        
        public String toString(){
            return this.name()+" positivo:"+positivo;
        }
        
        private final boolean positivo;
    }

    public static void main(String[] args) {
        Voto voto = Voto.QUATTRO;
        System.out.println(voto.toString());
    }
    
}
