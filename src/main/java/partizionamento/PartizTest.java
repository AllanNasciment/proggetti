package partizionamento;

public class PartizTest {

    public static void main(String[] args) {
        Binario testBin = new Binario('D', "0", 8);

        //IndirizzoIP testIndIp = new IndirizzoIP("192.168.0.0");
        
        SottoRete testSR = new SottoRete("80.10.2.128",25,12);
        System.out.println(testSR.stampa());
    }

}
