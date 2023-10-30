package varMetodiStatichi;

public class Statichi{
    private static Statichi[] oggetti=new Statichi[10];
    private static int oggDimL=0;
    private static final int x = 0;
    private int num;
    private String nome;
    
    public Statichi(int num){
        this.num = num;
        nome = "";
        oggetti[oggDimL]=this;
        oggDimL++;
    }
    
    public Statichi(String nome, int num){
        this.num = num;
        this.nome = nome;
        oggetti[oggDimL]=this;
        oggDimL++;
    }
    
    public static int getNumOgg(int index){
        return oggetti[index].num;
    }
    
    public static int getNumFromNome(String nome){
        int risult=Integer.MIN_VALUE;
        for(int i=0 ; i<oggDimL ; i++){
            if(oggetti[i].nome.equalsIgnoreCase(nome)){
                risult = oggetti[i].num;
                i=oggDimL;
            }
        }
        return risult;
    }
    
    public static void main(String[] args){
        Statichi test = new Statichi("oggetto0",1);
        for(int i=1 ; i<10 ; i++){
            test = new Statichi("oggetto"+i,2*Statichi.getNumOgg(i-1));
        }
        System.out.println(Statichi.getNumFromNome("oggetto9"));
    }
}
