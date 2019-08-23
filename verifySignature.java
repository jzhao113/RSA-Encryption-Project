package RSA;
import java.math.*;
public class verifySignature {
	
	private myPublicKey publicKey;
	private BigInteger[] signature;
	private fastMod fm;
	private String message;
	
	public verifySignature(BigInteger[] sig, myPublicKey pk, String m)
	{
		publicKey =pk;
		signature =sig;
		message=m;
	}
	
	public boolean isSignatureAuth()
	{
		String str="";
		for(int i=0;i<signature.length;i++)
		{
			fm = new fastMod(signature[i],publicKey.getE(),publicKey.getN());
			char a = (char)fm.fastModding().intValue();
			str=str+""+a;
		}
		if(message.equals(str))
		{
			return true;
		}
		return false;
	}

}
