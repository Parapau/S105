package N1E1;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

public class LlistaDir {
	public static void llistaDir (String path) {
		Path dir = Paths.get(path);
		Set<Path> llista = new TreeSet<Path>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file: stream) {
				llista.add(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
		}
		for (Path i : llista) {
			System.out.println(i);
		}
	}
}

