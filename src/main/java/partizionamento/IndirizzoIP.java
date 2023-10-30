package partizionamento;

public class IndirizzoIP {
    private Binario[] ip;
    private Binario[] maschera;
    
    public IndirizzoIP(String ip , String maschera){
        this.ip = caricaInd(ip);
        this.maschera = caricaInd(maschera);
    }
    
    public IndirizzoIP(String ip){
        this.ip = caricaInd(ip);
        maschera = mascheraDefault();
    }
    
    public IndirizzoIP(String ip,int pl){
        this.ip=caricaInd(ip);
        maschera=plToMasc(pl);
    }
    
    public IndirizzoIP(IndirizzoIP indIp){
        this.ip = new Binario[indIp.ip.length];
        this.maschera = new Binario[indIp.maschera.length];
        for(int i=0 ; i<indIp.ip.length ; i++){
            this.ip[i] = new Binario(indIp.ip[i]);
            this.maschera[i] = new Binario(indIp.maschera[i]);
        }
    }
    
    public IndirizzoIP(Binario[] ip , Binario[] maschera){
        this.ip = new Binario[ip.length];
        this.maschera = new Binario[maschera.length];
        for(int i=0 ; i<ip.length ; i++){
            this.ip[i] = new Binario(ip[i]);
            this.maschera[i] = new Binario(maschera[i]);
        }
    }
    
    /*
        usato per caricare l'attributo maschera, restituisce la maschera in base
        al prefix lenght dato da parametro
    */
    private Binario[] plToMasc(int pl){
        Binario[] risult = new Binario[4];
        for(int i=0 ; i<risult.length ; i++){
            if(pl/8 >=1){
                risult[i]=new Binario('D',"255",8);
                pl-=8;
            }else{
                risult[i]=new Binario('B',ultimoByteMasc(pl));
                pl=0;
            }
        }
        return risult;
    }
    
    /*
        restituisce un byte con i bit a sinistra settati a 1, setta i bit in base 
        al parametro:
            num = 3
            risultato = 11100000
    */
    private String ultimoByteMasc(int num){
        String risult="";
        for(int i=0 ; i<8 ; i++){
            if(num==0){
                risult+='0';
            }else{
                risult+='1';
                num--;
            }
        }
        return risult;
    }
    
    /*
        carica la maschera default, 
        192.x.x.x  =  255.255.255.0 
        172.x.x.x  =  255.255.0.0
        10.x.x.x   =  255.0.0.0
    */
    private Binario[] mascheraDefault(){
        String mascA = "255.0.0.0";
        String mascB = "255.255.0.0";
        String mascC = "255.255.255.0";
        Binario[] risult=new Binario[4];
        String primiBit = ip[0].getNumBin().substring(0, 2);
        switch(primiBit){
            case "01":
            case "00":
                risult=caricaInd(mascA);
                break;
            case "10":
                risult=caricaInd(mascB);
                break;
            case "11":
                risult=caricaInd(mascC);
        }
        return risult;
    }
    
    /*
        carica l'attributo ip
    */
    private Binario[] caricaInd(String ind){
        Binario[] risult=new Binario[4];
        int index=0;
        String byteDec="";
        for(int i=0 ; i<ind.length() ; i++){
            if(ind.charAt(i)!='.'){
                byteDec+=ind.charAt(i);
            }else{
                risult[index]=new Binario('D',byteDec,8);
                byteDec="";
                index++;
            }
        }
        risult[index]=new Binario('D',byteDec,8);
        return risult;
    }
    
    /*
        come parametro riceve: 
            indexInizio = da 1 a 32 ,come il prefix lenght, inzio
            indexFine = da 1 a 32 ,come il prefix lenght, fine
        questi parametri definiscono la parte che sarà sostituita da:
            String num = sequenza di bit che sostituisce il range dato
    */
    public void setBitRange(int indexIniz , int indexFine , String num){
        int lung = num.length();
        
        for(int i=0 ; i<(indexFine-indexIniz+1)-lung ; i++)
            num='0'+num;
        
        for(int i=0 ; i<=(indexFine-indexIniz) ; i++){
            int indexByte=(indexIniz-1+i)/8;
            int indexBit=(indexIniz-1+i)%8;
            ip[indexByte].setBit(indexBit, num.charAt(i));
        }
    }
    
    /*
        RITONA UN OGGETTO INDIRIZZOIP CON LA PARTE HOST UGUALE ALLA PARTE HOST
        DEL OGGETTO ORIGINALE + IL NUMERO PASSATO DA PARAMETRO ES:
            ORIGINALE 192.168.0.128  255.255.255.128
            NIND = 53
            RISULTATO 192.168.0.181 255.255.255.128
    */
    public IndirizzoIP indDispCrescente(int nInd){
        return indDisp(+nInd);
    }
    
    /*
        RITONA UN OGGETTO INDIRIZZOIP CON LA PARTE HOST del indirizzo originale
        con tutti i bit settati a 1 - nInd:
            ORIGINALE 192.168.0.0  255.255.255.128
            NIND = 1
            RISULTATO 192.168.0.127 255.255.255.128
    */
    public IndirizzoIP indDispDecrescente(int nInd){
        return indDisp(-nInd);
    }
    
    /*
        Restituisce una copia del attributo ip con la parte host modificata in 
        base al numero pasato da parametro.
        se il numero è positivo la parte host sara uguale al parametro
        se il numero è negativo la parte host sara uguale a:
        broadcast-nInd+1
    */
    private IndirizzoIP indDisp(int nInd){
        IndirizzoIP risult = new IndirizzoIP(ip,maschera);
        String bin = parteHost();
        Binario somma =  new Binario('B',bin);
        somma.add((int)Math.pow(2,bin.length())+nInd);
        String sost = somma.getNumBin();
        risult.setBitRange(32-sost.length()+1, 32, sost);
        return risult;
    }
    
    /*
            RESTITUISCE UNA STRING DI BIT DELLA PARTE HOST SENZA I PUNTI ES:
            MASC 255.255.0.0
            IP   192.168.0.128
            RISULTATO 0000000010000000
    */
    private String parteHost(){
        String risult="";
        int i=32;
        char bitMasc=' ';
        while(i>0){
            bitMasc = maschera[(i-1)/8].getBit((i-1)%8);
            if(bitMasc == '0'){
                risult = ip[(i-1)/8].getBit((i-1)%8) + risult;
                i--;
            }else{
                i=0;
            }
        }
        return risult;
    }

    /*
            RESTITUISCE L'INDIRZZO IN DECIMALE ES: 192.168.0.0
    */
    public String readInd(){
        String risult=ip[0].getNumDec()+'.'+ip[1].getNumDec()+'.'+ip[2].getNumDec()+'.'+ip[3].getNumDec();
        return risult;
    }
    
    /*
            RESTITUISCE LA MASCHERA IN DECIMALE ES: 255.255.255.0
    */
    public String readMasc(){
        return maschera[0].getNumDec()+'.'+maschera[1].getNumDec()+'.'+maschera[2].getNumDec()+'.'+maschera[3].getNumDec();
    }
    
    /*
            METODO TOSTRING RESTITUISCE I NUMERI IN DECIMALE
    */
    public String stampaBin(){
        String risult="";
        for(int i=0 ; i<ip.length ; i++)
            risult+="ip["+i+"] : "+ip[i].stampa()+"\n";
        
        for(int i=0 ; i<ip.length ; i++)
            risult+="maschera["+i+"] : "+maschera[i].stampa()+"\n";
        
        return risult;
    }
    
    
    /*
            METODO TOSTRING PERO RESTITUISCE I NUMERI IN DECIMALE
    */
    public String stampaDec(){
        String risult="";
        for(int i=0 ; i<ip.length ; i++)
            risult+="ip["+i+"] : "+ip[i].stampaDec()+"\n";
        
        for(int i=0 ; i<maschera.length ; i++)
            risult+="maschera["+i+"] : "+maschera[i].stampaDec()+"\n";
        
        return risult;
    }
}
