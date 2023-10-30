package ristoranteEre;

public class Sala extends ContenitoreTavolo{
    private static int numNextTav=1;
    
    public Sala(Tavolo[] tavoli){
        super(tavoli);
    }
    
    public Sala(Sala sala){
        super(sala);
    }
    
    public Sala(){
        super();
    }
    
    public int nPersoneTot(){
        int risult=0;
        for(int i=0 ; i<this.getDimL() ; i++){
            risult+=this.getTavoli()[i].getNPersone();
        }
        return risult;
    }
    
}
