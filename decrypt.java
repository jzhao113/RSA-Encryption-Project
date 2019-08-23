package RSA;

import java.math.BigInteger;

public class decrypt {
	
	private fastMod calculate;
	private myPrivateKey pri;
	private BigInteger x[];
	
	public decrypt(BigInteger o[], myPrivateKey p)
	{
		x=o;
		pri=p;
	}
	
	public String decryptData()
	{
		String str ="";
		for(int i=0;i<x.length;i++)
		{
			calculate = new fastMod(x[i],pri.getD(),pri.getN());
			char a = (char)calculate.fastModding().intValue();
			str=str+""+a;
		}
		
		return str;
	}

}
