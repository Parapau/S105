package N1E4;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class LlistaDir {



	public static void llistaDir (String path) throws IOException {
		Date data = null;
		Path dir = Paths.get(path);
		TreeSet<Path> llista = null;
		TreeSet<Path> subLlista = null;
		llista = llistaUtilitat(dir);
		
		
		for (Path i : llista) {
			if (i.toFile().isFile()) {
				if (!elTexte(i).equals(i.getFileName().toString())){
					data = new Date(i.toFile().lastModified());
					System.out.println(i.getFileName() + "(F) " + data);
					System.out.println("	" + elTexte(i));
				} else {
					data = new Date(i.toFile().lastModified());
					System.out.println(i.getFileName() + "(F) " + data);
				}
			} else {
				subLlista = llistaUtilitat (i);
				data = new Date(i.toFile().lastModified());
				System.out.println(i.getFileName() + "(D) " + data);
				for (Path j : subLlista) {
					if (Files.exists(j)) {
						if (elTexte(i).equals(j.getFileName().toString())){
							data = new Date(i.toFile().lastModified());
							System.out.println("	" + i.getFileName() + "(F) " + data);
							System.out.println("		" + elTexte(i));
						} else {
							data = new Date(i.toFile().lastModified());
							System.out.println("	" + i.getFileName() + "(F) " + data);
						}
					} else {
						data = new Date(i.toFile().lastModified());
						System.out.println("	" + j.getFileName() + "(D) " + data);
					}
				}
			}
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

	private static String elTexte (Path path) throws IOException {
		String texte = path.getFileName().toString();
		if (comprovaTxt(path.getFileName().toString())) {
			texte = Files.readString(path);
		}
		return texte;
	}

	private static boolean comprovaTxt (String nom) {
		int llarg = nom.length() - 4, i = 0;
		String punt = ".txt";
		boolean es = true;
		while (i < 3 && es) {
			if (nom.charAt(llarg) == (punt.charAt(i))) {
				i++;
				llarg++;
			} else {
				es = false;
			}
		}

		return es;

	}
}

