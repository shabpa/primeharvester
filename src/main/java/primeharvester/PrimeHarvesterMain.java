package primeharvester;

import java.math.BigInteger;

public class PrimeHarvesterMain {
    public static void main(String[] args) {
        
        PrimeHarvester ph = new PrimeHarvester(new BigInteger("2"),new BigInteger("10000"));
        for(BigInteger current:ph){
            System.out.printf("%s ,",current.toString());
        }
        System.out.printf("\nEs wurden %d Primzahlen gefunden\n",ph.getPrimeCount());
    }
}
