package primeharvester;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PrimeHarvester implements Iterable<BigInteger> {

    public final BigInteger startValue;
    public final BigInteger endValue;


    public PrimeHarvester(BigInteger startValue, BigInteger endValue) {

        if (startValue == null || endValue == null) {
            throw new IllegalArgumentException("startValue and endValue can't be null");
        }

        if (startValue.compareTo(BigInteger.TWO) == -1) {
            throw new IllegalArgumentException("startValue needs to be bigger than 1");
        }

        if (endValue.compareTo(startValue) == -1) {
            throw new IllegalArgumentException("endValue needs to be bigger than startValue");
        }

        this.startValue = startValue;
        this.endValue = endValue;

    }

    private class PrimeHarvesterIterator implements Iterator<BigInteger> {

        BigInteger current = startValue.subtract(BigInteger.ONE);

        @Override
        public boolean hasNext() {
            if (current.nextProbablePrime().compareTo(PrimeHarvester.this.endValue) > 0) {
                return false;
            }
            return true;
            
        }

        @Override
        public BigInteger next() {
            if (!hasNext()) {
                throw new NoSuchElementException("");
            }
            
            current = current.nextProbablePrime();
            return current;
        }
        
        
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return new PrimeHarvesterIterator();
    }

    public long getPrimeCount() {
        long count = 0;
        for (BigInteger prime : this)
            count++;
        return count;
    }
 
}
