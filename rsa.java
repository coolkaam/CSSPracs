import java.io.*;
import java.util.*;
import java.math.*;

public class rsa {

    private BigInteger p, q;
    private BigInteger n;
    private BigInteger PhiN;
    private BigInteger e, d;

    public rsa() {
        initialize();
    }

public void initialize() {
        int SIZE = 512;

        p = new BigInteger(SIZE, 15, new Random());
        q = new BigInteger(SIZE, 15, new Random());

        n = p.multiply(q);

        PhiN = p.subtract(BigInteger.valueOf(1));
        PhiN = PhiN.multiply(q.subtract(BigInteger.valueOf(1)));

        do {
            e = new BigInteger(2 * SIZE, new Random());
        } while ((e.compareTo(PhiN) != 1)|| (e.gcd(PhiN).compareTo(BigInteger.valueOf(1)) != 0));

        d = e.modInverse(PhiN);
    }

    public BigInteger encrypt(BigInteger plaintext) {
        return plaintext.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(d, n);
    }

    public static void main(String[] args){
        rsa app = new rsa();
        int plaintext;
        System.out.println("Enter any character : ");
        plaintext = System.in.read();
        BigInteger bplaintext, bciphertext;
        bplaintext = BigInteger.valueOf((long) plaintext);
        bciphertext = app.encrypt(bplaintext);
        System.out.println("Plaintext : " + bplaintext.toString());
        System.out.println("Ciphertext : " + bciphertext.toString());
        bplaintext = app.decrypt(bciphertext);
        System.out.println("After Decryption Plaintext : "
                + bplaintext.toString());
    }
}

/*
class rsa{
	
	public static void main(String args[])
	{
	BigInteger p,q;
	//BigInteger bitlength= 1024;            
	
	Random rnd = new Random(); 
	p = BigInteger.probablePrime(1024, rnd);
	q = BigInteger.probablePrime(1024, rnd);
	
	System.out.println("First Integer No : " +p);
	System.out.println("Second Integer No : "+q);
	
	BigInteger n = p.multiply(q);
	System.out.println("Multiplication of P and Q : "+n);
	
	
	p = p.subtract(BigInteger.ONE);
	//n = p1.multiply(q1);
	System.out.println("(P-1) : "+p);
	
	q = q.subtract(BigInteger.ONE);
	System.out.println("(Q-1) : "+q);
		
	BigInteger phi = p.multiply(q);	
	System.out.println("Phi(n) : "+phi);
	
	BigInteger e = BigInteger.probablePrime(1024 / 2, rnd);
		System.out.println("Public Key : "+e);
	
	
	while(phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 )
	{
		e.add(BigInteger.ONE);
		
	}
	
	BigInteger d = e.modInverse(phi);
	System.out.println("Private Key : "+d);
	
	
	
	int plaintext;
        System.out.println("Enter any character : ");
        plaintext = System.in.read();
        BigInteger bplaintext, bciphertext;
        bplaintext = BigInteger.valueOf((long) plaintext);
        bciphertext = app.encrypt(bplaintext);
        System.out.println("Plaintext : " + bplaintext.toString());
        System.out.println("Ciphertext : " + bciphertext.toString());
        bplaintext = app.decrypt(bciphertext);
        System.out.println("After Decryption Plaintext : "+ bplaintext.toString());
	
	
	}
	
	public BigInteger encrypt(BigInteger plaintext) {
        return plaintext.modPow(e,n);
    }

    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(d,n);
    }

}*/


