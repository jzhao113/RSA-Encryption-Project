package RSA;
import java.math.*;
import java.util.*;
public class myTools {
	
	private BigInteger PHI;
	private BigInteger e;
	
	public myTools()
	{
	} 
	

	public BigInteger oddCoPrime(BigInteger x)
	{
		Random ran = new Random();
		int indexOfCo = ran.nextInt((20000000-1)+1)+1;
		int count=0;
		PHI=x;
		BigInteger i = BigInteger.valueOf(3);
		for(BigInteger a =i;a.compareTo(x)==-1;a=a.add(BigInteger.valueOf(2)))
		{
			if(PHI.gcd(a).equals(BigInteger.valueOf(1)))
			{
				if(count==indexOfCo)
				{
					e=a;
					break;
				}
				else
				{
					count++;
				}
			}
		}
		
		return e;
	}
	
	public BigInteger getTheD(BigInteger x, BigInteger y)
	{
		PHI=x;
		e=y;
		return e.modInverse(PHI);
	}

}
