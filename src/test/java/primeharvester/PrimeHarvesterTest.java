package primeharvester;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PrimeHarvesterTest {


    @Test
    public void test_constructorValid(){
        assertThrows("Must throw IllegalArgumentException on null value for startValue", IllegalArgumentException.class, () -> new PrimeHarvester(null, new BigInteger("10")));
        assertThrows("Must throw IllegalArgumentException on null value for endValue", IllegalArgumentException.class, () -> new PrimeHarvester(new BigInteger("10"),null));
        assertThrows("Must throw IllegalArgumentException on startValue < 2", IllegalArgumentException.class, () -> new PrimeHarvester(new BigInteger("1"),new BigInteger("10")));
        assertThrows("Must throw IllegalArgumentException on startValue < 2", IllegalArgumentException.class, () -> new PrimeHarvester(new BigInteger("-10"),new BigInteger("10")));
        assertThrows("Must throw IllegalArgumentException on startValue > endValue", IllegalArgumentException.class, () -> new PrimeHarvester(new BigInteger("10"),new BigInteger("2")));
        try{
            PrimeHarvester equalPrimeStartEnd = new PrimeHarvester(new BigInteger("2"),new BigInteger("2"));
        }catch(Exception e){
            fail("Equal startValue and endValue should be valid!");
        }
    }

    @Test
    public void test_startEqualsEnd(){
        PrimeHarvester equalPrimeStartEnd = new PrimeHarvester(new BigInteger("2"),new BigInteger("2"));
        PrimeHarvester equalNonPrimeStartEnd = new PrimeHarvester(new BigInteger("4"),new BigInteger("4"));
        assertEquals("Between 2 and 2 should be exactly one prime number", 1, equalPrimeStartEnd.getPrimeCount());
        assertEquals("Between 4 and 4 should be no prime number", 0, equalNonPrimeStartEnd.getPrimeCount());
    }

    @Test
    public void test_correctNumber(){
        PrimeHarvester ph = new PrimeHarvester(new BigInteger("2"),new BigInteger("10000"));
        assertEquals("Between 2 and 10000 must be 1229 prime numbers",1229, ph.getPrimeCount());
    }

    @Test
    public void test_iterator(){
        PrimeHarvester ph = new PrimeHarvester(new BigInteger("2"),new BigInteger("10"));
        Iterator<BigInteger> it = ph.iterator();
        while(it.hasNext()){
            it.next();
        }
        assertThrows("Must throw NoSuchElementException when end is reached and is next() called", NoSuchElementException.class, () -> it.next());
    }

    
}
