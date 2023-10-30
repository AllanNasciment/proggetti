package partizionamento;

public class SottoRete {
    private IndirizzoIP indRete;
    private IndirizzoIP primoInd;
    private IndirizzoIP ultimoInd;
    private IndirizzoIP switchInd;
    private IndirizzoIP defaultGateway;
    private IndirizzoIP broadcast;
    private int nDisp;
    
    public SottoRete(String indRete , String maschera , int nDisp){
        this.indRete = new IndirizzoIP(indRete , maschera);
        this.nDisp = nDisp;
        caricaIndirizzi();
    }
    
    public SottoRete(String indRete,int pl , int nDisp){
        this.indRete=new IndirizzoIP(indRete,pl);
        this.nDisp = nDisp;
        caricaIndirizzi();
    }
    
    private void caricaIndirizzi(){
        this.primoInd = this.indRete.indDispCrescente(1);
        this.ultimoInd = this.indRete.indDispCrescente(nDisp);
        this.switchInd = this.indRete.indDispDecrescente(3);
        this.defaultGateway = this.indRete.indDispDecrescente(2);
        this.broadcast = this.indRete.indDispDecrescente(1);
    }
    
    public String getIndRete(){
        return indRete.readInd();
    }
    
    public String getPrimoInd(){
        return primoInd.readInd();
    }
    
    public String getUltimoInd(){
        return ultimoInd.readInd();
    }
    
    public String getSwitch(){
        return switchInd.readInd();
    }
        
    public String getDefaultGateway(){
        return defaultGateway.readInd();
    }
    
    public String getBroadcast(){
        return broadcast.readInd();
    }
    
    public String getMaschera(){
        return indRete.readMasc();
    }
    
    public String stampa(){
        String risult ="rete : "+getIndRete();
        risult +="\nprimo Dispositivo : "+getPrimoInd();
        risult +="\nultimo Dispositivo : "+getUltimoInd();
        risult +="\nindirizzo switch : "+getSwitch();
        risult +="\nDefault Gateway : "+getDefaultGateway();
        risult +="\nBroadcast : "+getBroadcast();
        risult +="\nMaschera : "+getMaschera();
        risult +="\nNumero di Dispositivi : "+nDisp;
        return risult;
    }
}
