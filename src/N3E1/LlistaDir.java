package N3E1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class LlistaDir {



	public static ArrayList<byte[]> llistaDir (String path) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
		SecretKey clau = null;
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, clau);
		ArrayList <byte[]> xifrats = new ArrayList<byte[]>();//Esto puede que sea una guarrada
		
		Path dir = Paths.get(path);
		String retorn;
		byte[] xifra;
		TreeSet<Path> llista = null;
		TreeSet<Path> subLlista = null;
		llista = llistaUtilitat(dir);

		FileWriter escriptor = new FileWriter("C:\\Users\\formacio\\Desktop\\Directori.txt", true);
		for (Path i : llista) {
			if (i.toFile().isFile()) {
				retorn = (i.getFileName() + "(F)\n");
				xifra = c.doFinal(retorn.getBytes());
				xifrats.add(xifra);
			} else {
				subLlista = llistaUtilitat (i);
				retorn = (i.getFileName() + "(D)\\n");
				for (Path j : subLlista) {
					if (Files.exists(j)) {

						retorn = ("	" + j.getFileName() + "(F)\n");
						xifra = c.doFinal(retorn.getBytes());
						xifrats.add(xifra);
					} 
					else {
						retorn = ("	" + j.getFileName() + "(D)\n");
						xifra = c.doFinal(retorn.getBytes());
						xifrats.add(xifra);
					}
				}
			}
		}
		return xifrats;





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

}

