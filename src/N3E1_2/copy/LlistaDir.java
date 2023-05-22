package N3E1_2.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.TreeSet;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class LlistaDir {



	public static void llistaDir (String path) throws FileNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		Path dir = Paths.get(path);
		FileOutputStream fileOut = new FileOutputStream ("C:\\Users\\formacio\\Desktop\\patata.txt");
		SecretKey clau = new SecretKeySpec("patatapatatapata".getBytes(), "AES");
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] iv = c.getIV();
		c.init(Cipher.ENCRYPT_MODE, clau);
		CipherOutputStream cipherOut = new CipherOutputStream(fileOut, c);
		TreeSet<Path> llista = null;
		TreeSet<Path> subLlista = null;
		llista = llistaUtilitat(dir);
		try {
			//FileWriter escriptor = new FileWriter("C:\\Users\\formacio\\Desktop\\Directori.txt", true);
			for (Path i : llista) {
				if (i.toFile().isFile()) {

					cipherOut.write((i.getFileName() + "(F)\n").getBytes());
				} else {
					subLlista = llistaUtilitat (i);
					cipherOut.write((i.getFileName() + "(D)\\n").getBytes());
					for (Path j : subLlista) {
						if (Files.exists(j)) {

							cipherOut.write(("	" + j.getFileName() + "(F)\n").getBytes());
						} 
						else {
							cipherOut.write(("	" + j.getFileName() + "(D)\n").getBytes());
						}
					}
				}
			}
			//escriptor.close();
		} catch (IOException e) {
			System.out.println(e);;



		}

	}



	private static TreeSet<Path> llistaUtilitat (Path path) {
		TreeSet<Path> llista = new TreeSet<Path>();

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
			for (Path file: stream) {
				llista.add(file);
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
			System.out.println("awkdgajwdgawgd");
		}
		return llista;
	}


	public static String  llistaDecript (String path) throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException {
		String retorn, linia;
		
		Path dir = Paths.get(path);
		SecretKey clau = new SecretKeySpec("patatapatatapata".getBytes(), "AES");
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] iv = new byte[16];
		FileInputStream fileIn = new FileInputStream(path);
		CipherInputStream cIn = new CipherInputStream(fileIn, c);
		InputStreamReader llegidorInput = new InputStreamReader(cIn);
		BufferedReader llegidor = new BufferedReader (llegidorInput);
		StringBuilder constructorFil = new StringBuilder();
		
		c.init(Cipher.ENCRYPT_MODE, clau);
		fileIn.read(iv);
		
		while ((linia = llegidor.readLine()) != null) {
			constructorFil.append(linia);
		}
		
		retorn = constructorFil.toString();
		
		
		return retorn;
		
	}

}















































