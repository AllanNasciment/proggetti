package partizionamento;

public class Binario {
    private String numBin;
    
    public Binario(char base,String num){
        if(base!='B'){
            numBin = decToBin(num);
        }else{
            numBin = num;
        }
    }
    
    public Binario(char base,String num,int lung){
        if(base!='B'){
            numBin = decToBin(num,lung);
        }else{
            numBin = caricaNumBin(num,lung);
        }
    }
    
    public Binario(Binario bina){
        this.numBin = bina.numBin;
    }
    
    private String caricaNumBin(String num,int lung){
        String risult="";
        for(int i=0 ; i<lung ; i++){
            if(num.length()-i>0){
               risult+=num.charAt(i);
            }else{
                risult+='0';
            }
        }
        return risult;
    }
    
    public String decToBin(String dec){
        String risult = "";
        int quo = strToInt(dec);
        while(quo!=1){
            risult=(quo%2)+risult;
            quo/=2;
        }
        risult=1+risult;
        return risult;
    }
    
    public String decToBin(int dec, int lung){
        String risult = "";
        int quo = dec;
        int i=0;
        while(i<lung){
            risult=(quo%2)+risult;
            quo/=2;
            i++;
        }
        return risult;
    }
    
    public String decToBin(String dec,int lung){
        String risult = "";
        int quo = strToInt(dec);
        int i=0;
        while(i<lung){
            risult=(quo%2)+risult;
            quo/=2;
            i++;
        }
        return risult;
    }
    
    private int strToInt(String str){
        int risult=0;
        int lung = str.length()-1;
        int i = lung;
        while(i>=0){
            risult+=(str.charAt(i)-'0')*Math.pow(10,lung-i);
            i--;
        }
        return risult;
    }
    
    public void add(int add){
        String addendo = decToBin(add,numBin.length());
        String risult="";
        int carry = 0;
        for(int i=numBin.length()-1 ; i>=0 ; i--){
            int add1 = numBin.charAt(i)-'0';
            int add2 = addendo.charAt(i)-'0';
            risult=(add1^add2^carry)+risult;
            if(add1==0 && add2==0){
                carry=0;
            }else if(add1==1 && add2==1){
                carry=1;
            }
        }
        numBin = risult;
    }

    public String getNumBin(){
        return numBin;
    }
    
    public String getNumDec(){
        return binToDec();
    }
    
    public char getBit(int index){
        return numBin.charAt(index);
    }
    
    public void setBit(int ind , char bin){
        String risult = numBin.substring(0, ind)+bin+numBin.substring(ind+1);
        numBin = risult;
    }
    
    public String stampa(){
        return numBin;
    }
    
    public String stampaDec(){
        return binToDec();
    }
    
    private String binToDec(){
        String risult="";
        int somma=0;
        for(int i=0 ; i<numBin.length() ; i++)
            somma+=(int)((numBin.charAt(i)-'0')*Math.pow(2,numBin.length()-i-1));
        risult=""+somma;
        return risult;
    }
}
