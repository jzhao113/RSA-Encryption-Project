package RSA;

import java.math.*;
import java.util.Random;
public class XOR {
	
	public static void main(String[]args)
	{
		//This does has NOTHING to do with RSA.
		
		//This is an XOR cipher
		
		String input="Hello there";

		BigInteger []letters = new BigInteger[input.length()];
		Random rnd = new Random();
		BigInteger key= new BigInteger(1024, rnd);
		
		//Encrypt
		for(int i=0;i<input.length();i++)
		{
			letters[i]=BigInteger.valueOf((int)input.charAt(i)).xor(key);
			System.out.println(letters[i]);
		}
		
		//Decrypt
		String str="";
		for(int i=0;i<input.length();i++)
		{
			BigInteger outcome = letters[i].xor(key);
			str=str+""+(char)outcome.intValue();
		}
		System.out.println("\n"+str);
		
		
	}

}
