package RSA;

import java.math.BigInteger;

public class RSAmain {
	
	public static void main(String[]args)
	{
		//Generating prime numbers
		System.out.println("Generating first pair of keys");
		BigInteger prime1 = PrimeNumber.generatePrimeNumber();
		BigInteger prime2 = PrimeNumber.generatePrimeNumber();
		
		//Calling the key generator
		keyGenerator kg = new keyGenerator(prime1,prime2);
		kg.generate();
		myPublicKey pub =kg.getPublicKey();
		myPrivateKey pri = kg.getPrivateKey();
		
		//Encrypting the string "Hello there"
		String x="Hello there";
		encrypt eng = new encrypt(x);
		BigInteger[] encrypted = eng.encryptData(pub);
		
		System.out.print("Encrypted: ");
		for(BigInteger o: encrypted)
		{
			System.out.println(o);
		}
		System.out.println("");
		
		//Decrypting the Big Integer array 
		decrypt decry = new decrypt(encrypted,pri);
		String decrypted = decry.decryptData();
		System.out.println("Decrypted: "+decrypted+"\n");
		
		
		//Creating another pair of keys, trying to use new private key to decrypt other public key
		//This will NOT decrypt properly
		//This is an example on how using the wrong private key for a public key will not
		//decrypt the message correctly
		System.out.println("Generating second pair of keys");
		BigInteger prime3 = PrimeNumber.generatePrimeNumber();
		BigInteger prime4 = PrimeNumber.generatePrimeNumber();
		keyGenerator kg2 = new keyGenerator(prime3, prime4);
		kg2.generate();
		myPrivateKey pri2 = kg2.getPrivateKey();
		decrypt decry2 = new decrypt(encrypted,pri2);
		String decrypted2 = decry2.decryptData();
		System.out.println("Decrypted with wrong key: "+decrypted2+"\n");
		
		
		
		//Creating a signature for the signature "This is my message"
		String a ="This is my message";
		System.out.println("The message I send out \""+a+"\"\n");
		signature sig = new signature(pri,a);
		BigInteger[] signature = sig.generateSignature();
		System.out.print("Signature: ");
		for(BigInteger u: signature)
		{
			System.out.println(u);
		}
		System.out.println("");
		
		//Verifying the signature
		System.out.println("Verification of Signature");
		verifySignature verify = new verifySignature(signature,pub,a);
		if(verify.isSignatureAuth())
		{
			System.out.println("The signature is authentic");
		}
		else
		{
			System.out.println("The signature is NOT authentic");
		}
		
	}

}
