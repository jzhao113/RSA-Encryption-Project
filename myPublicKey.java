package RSA;
import java.math.*;
public class myPublicKey {
	
	private BigInteger n;
	private BigInteger e;
	
	public myPublicKey(BigInteger a, BigInteger b)
	{
		n=a;
		e=b;
	}
	
	public BigInteger getN()
	{
		return n;
	}
	
	public BigInteger getE()
	{
		return e;
	}

	
	public void showKeys()
	{
		System.out.println(n);
		System.out.println(e);
	}

}
