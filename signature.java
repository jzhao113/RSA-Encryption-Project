package RSA;
import java.math.*;
public class signature {
	
	private myPrivateKey privateKey;
	private fastMod fm;
	private char[]charArray;
	
	public signature(myPrivateKey pk,String x)
	{
		privateKey=pk;
		charArray = new char[x.length()];
		for(int p=0;p<x.length();p++)
		{
			charArray[p]=x.charAt(p);
		}
	}
	
	
	public BigInteger[] generateSignature()
	{
		BigInteger outcome []= new BigInteger[charArray.length];
		for(int x=0;x<charArray.length;x++)
		{
			BigInteger intial = BigInteger.valueOf((int)charArray[x]);
			fm = new fastMod(intial,privateKey.getD(),privateKey.getN());
			outcome[x]=fm.fastModding();
		}
		return outcome;
	}

}
