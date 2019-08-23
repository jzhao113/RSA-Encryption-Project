package RSA;

import java.math.*;

public class keyGenerator {
	
	private BigInteger prime1;
	private BigInteger prime2;
	private BigInteger n;
	private BigInteger PHI;
	private BigInteger e;
	private BigInteger d;
	
	public keyGenerator(BigInteger x, BigInteger y)
	{
		prime1=x;
		prime2=y;
	}
	
	public void generate()
	{
		n =prime1.multiply(prime2);
		System.out.println("n: "+n+"\n");
		PHI = (prime1.subtract(BigInteger.valueOf(1))).multiply((prime2.subtract(BigInteger.valueOf(1))));
		System.out.println("PHI:"+PHI+"\n");
		myTools toolSet = new myTools();
		e = toolSet.oddCoPrime(PHI);
		System.out.println("e: "+e+"\n");
		d = toolSet.getTheD(PHI, e);
		System.out.println("d: "+d+"\n");
	}
	
	public myPublicKey getPublicKey()
	{
		myPublicKey pk = new myPublicKey(n,e);
		return pk;
	}
	
	public myPrivateKey getPrivateKey()
	{
		myPrivateKey pk = new myPrivateKey(n,d);
		return pk;
	}
	

}
