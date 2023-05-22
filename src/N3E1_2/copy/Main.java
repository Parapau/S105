package N3E1_2.copy;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

public class Main {
	public static void main (String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
		LlistaDir.llistaDir("C:\\Users\\formacio\\Desktop");
		System.out.println(LlistaDir.llistaDecript("C:\\Users\\formacio\\Desktop\\patata.txt"));
	}
}
