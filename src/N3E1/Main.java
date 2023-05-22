package N3E1;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import N1E1.LlistaDir;

public class Main {
	public static void main (String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
		
		
		/*dir = LlistaDir.llistaDir("C:\\Users\\formacio\\Desktop");
		SecretKey clau = new SecretKeySpec(dir.getBytes(), "AES");
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, clau);
		System.out.println(c.doFinal(dir.getBytes()));*/
		

		System.out.println(LlistaDir.llistaDir("C:\\Users\\formacio\\Desktop"));
		
	}
}
