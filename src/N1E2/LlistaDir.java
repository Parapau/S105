package N1E2;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

public class LlistaDir {



	public static void llistaDir (String path) {
		Path dir = Paths.get(path);
		TreeSet<Path> llista = null;
		TreeSet<Path> subLlista = null;

		llista = llistaUtilitat(dir);

		for (Path i : llista) {
			//System.out.println(i);
			if (Files.notExists(i)) {
				subLlista = llistaUtilitat (i);
				System.out.println(i + "(D)");
				for (Path j : subLlista) {
					if (Files.exists(j)) {
						System.out.println("	" + j + "(F)");
					} else {
						System.out.println("	" + j + "(D)");
					}
				}
			} else {
				System.out.println(i + "(F)");

			}
		}
	}

	private static TreeSet<Path> llistaUtilitat (Path path) {
		TreeSet<Path> llista = new TreeSet<Path>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
			for (Path file: stream) {
				llista.add(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
			System.out.println("awkdgajwdgawgd");
		}
		return llista;
	}

}

