package RSA;
import java.math.*;
public class fastMod {
	
	private BigInteger base;
	private BigInteger mod;
	private BigInteger expo;
	
	public fastMod()
	{
	}
	public fastMod(BigInteger x,BigInteger y, BigInteger z)
	{
		base=x;
		expo=y;
		mod=z;
	}
	
	public BigInteger fastModding()
	{
		BigInteger dights= BigInteger.valueOf(0);
		BigInteger x = BigInteger.valueOf(1);
		//Turning expo into binary 
		String binary =expo.toString(2);
		BigInteger binary2 = new BigInteger(binary);
		expo=binary2;
		
		BigInteger copy = expo;
					
		//Using copy to get the amount of dights of the binary number 
		while(copy.compareTo(BigInteger.valueOf(0))==1)
		{
			copy=copy.divide(BigInteger.valueOf(10));
			dights=dights.add(BigInteger.valueOf(1));
		}
						
		//The loop to find the answer 
		for(int a=1;a<=dights.intValue();a++)
		{
			if((expo.mod(BigInteger.valueOf(10))).compareTo(BigInteger.valueOf(1))==0)
			{
				x=(x.multiply(base)).mod(mod);
				base=(base.multiply(base)).mod(mod);
			}	
			else
			{
				base=(base.multiply(base)).mod(mod);
			}		
			expo=expo.divide(BigInteger.valueOf(10));			
		}
					
			return x;
	}
	
	
}
