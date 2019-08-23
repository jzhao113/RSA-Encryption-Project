package RSA;
import java.math.*;
public class encrypt {
	
	private fastMod calculate = new fastMod();
	private char []charArray;
	
	public encrypt(String a)
	{
		charArray = new char[a.length()];
		for(int p=0;p<a.length();p++)
		{
			charArray[p]=a.charAt(p);
		}
	}
	
	public BigInteger[] encryptData(myPublicKey pub)
	{
		BigInteger outcome []= new BigInteger[charArray.length];
		for(int x=0;x<charArray.length;x++)
		{
			BigInteger intial = BigInteger.valueOf((int)charArray[x]);
			calculate = new fastMod(intial,pub.getE(),pub.getN());
			outcome[x]=calculate.fastModding();

		}
		return outcome;
	}

}
