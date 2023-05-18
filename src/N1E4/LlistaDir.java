package N1E4;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TreeSet;

public class LlistaDir {



	public static void llistaDir (String path) throws IOException {
		Path dir = Paths.get(path);
		TreeSet<Path> llista = null;
		TreeSet<Path> subLlista = null;
		llista = llistaUtilitat(dir);

		for (Path i : llista) {
			if (i.toFile().isFile()) {
				if (!elTexte(i).equals(i.getFileName().toString())){
					System.out.println(i.getFileName() + "(F)");
					System.out.println("	" + elTexte(i));
				} else {
					System.out.println(i.getFileName() + "(F)");
				}
			} else {
				subLlista = llistaUtilitat (i);
				System.out.println(i.getFileName() + "(D)");
				for (Path j : subLlista) {
					if (Files.exists(j)) {
						if (elTexte(i).equals(j.getFileName().toString())){
							System.out.println("	" + i.getFileName() + "(F)");
							System.out.println("		" + elTexte(i));
						} else {
							
							System.out.println("	" + i.getFileName() + "(F)");
						}
					} else {
						System.out.println("	" + j.getFileName() + "(D)");
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

