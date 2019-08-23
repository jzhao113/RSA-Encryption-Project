package RSA;
import java.math.*;
public class myPrivateKey {
	
	private BigInteger n;
	private BigInteger d;
	
	public myPrivateKey(BigInteger x, BigInteger y)
	{
		n=x;
		d=y;
	}
	
	public BigInteger getN()
	{
		return n;
	}
	
	public BigInteger getD()
	{
		return d;
	}
	
	public void showKeys()
	{
		System.out.println(n);
		System.out.println(d);
	}
}
