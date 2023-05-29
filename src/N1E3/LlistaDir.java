package N1E3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.TreeSet;

public class LlistaDir {



	public static void llistaDir (String path) {
		Path dir = Paths.get(path);
		TreeSet<Path> llista = null;
		TreeSet<Path> subLlista = null;
		llista = llistaUtilitat(dir);
		Date data = null;
		
		try {
			FileWriter escriptor = new FileWriter("C:\\Users\\formacio\\Desktop\\Directori.txt");
			for (Path i : llista) {
				if (i.toFile().isFile()) {
					data = new Date(i.toFile().lastModified());
					escriptor.write(i.getFileName() + "(F) " + data + "\n");
				} else {
					subLlista = llistaUtilitat (i);
					data = new Date(i.toFile().lastModified());
					escriptor.write(i.getFileName() + "(D) " + data + "\n");
					for (Path j : subLlista) {
						if (Files.exists(j)) {
							data = new Date(i.toFile().lastModified());
							escriptor.write("	" + j.getFileName() + "(F) " + data + "\n");
						} 
						else {
							data = new Date(i.toFile().lastModified());
							escriptor.write("	" + j.getFileName() + "(D) " + data + "\n");
						}
					}
				}
			}
			escriptor.close();
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

}

