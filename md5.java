import java.io.*;
import java.math.*;
import java.security.*;

public class md5{
	
	public static String getMD5(String input)

	{
		try{

			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] messageDigest = md.digest(input.getBytes());
			System.out.println("Byte Representation:" +messageDigest);
			BigInteger number = new BigInteger(1,messageDigest);
			System.out.println("number :- " +number);
			String hashtext = number.toString(16);
			while(hashtext.length() < 32){
				hashtext = "0" + hashtext;
			}
			return hashtext;

		}
		catch(NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws 
	NoSuchAlgorithmException, IOException{
		System.out.println("Enter The String:-");
		BufferReader br = new BufferReader(new InputSt)
		
	}
	
	}
