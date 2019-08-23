package RSA;
import java.math.BigInteger;
import java.util.*;

public class PrimeNumber {
	
	public static BigInteger generatePrimeNumber() {
		BigInteger test;
		Random rnd = new Random();
		test = new BigInteger(1024, rnd);
		while(isPrime(test) == false) {
			test = new BigInteger(512, rnd);
		}
		return test;
		
	}
	public static boolean isPrime(BigInteger numToTest) {
		if(numToTest.compareTo(BigInteger.valueOf(1)) <= 0) return false;
		if(numToTest.compareTo(BigInteger.valueOf(2)) == 0) return true;
		if(numToTest.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0)) return false;
		
		BigInteger oddFactorOfNum = numToTest.subtract(BigInteger.valueOf(1));
		
		int r = 0;
		while(numToTest.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0))  {
			oddFactorOfNum.divide(BigInteger.valueOf(2));
			r+= 1;
		}
		for(int time = 1; time < 5; time++) {
			if(millerTest(numToTest, oddFactorOfNum, r) == false) return false;
		}
		
		return true;
	}
	
	public static boolean millerTest(BigInteger numToTest, BigInteger oddFactorOfNum, int r) {
		BigInteger randomNum = randomBigInteger(numToTest);
		fastMod millerNumToTest = new fastMod(randomNum, oddFactorOfNum, numToTest);
		BigInteger x = millerNumToTest.fastModding();
		if(x.compareTo(BigInteger.valueOf(1)) == 0 || 
			x.compareTo(numToTest.subtract(BigInteger.valueOf(1))) == 0) return true;
			
		for(int time = 1; time < r; time++) {
			x = (x.multiply(x)).mod(numToTest);
			if(x.compareTo(BigInteger.valueOf(1)) == 0) return false;
			if(x.compareTo(numToTest.subtract(BigInteger.valueOf(1))) == 0) return true;
		}
		return false;
	}
	
	public static BigInteger randomBigInteger(BigInteger numToTest) {
        Random rnd = new Random();
        int maxNumBitLength = numToTest.bitLength();
        BigInteger aRandomBigInt;
        do {
            aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
            // compare random number lessthan ginven number
        } while (aRandomBigInt.compareTo(numToTest.subtract(BigInteger.valueOf(2))) > 0 && aRandomBigInt.compareTo(BigInteger.valueOf(2)) < 0); 
        return aRandomBigInt;
    }
	
	
}
