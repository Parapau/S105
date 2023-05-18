package N1E5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Seriealitzador {
		public static void serielitzacio (Serie serie, String dir) throws IOException {
			FileOutputStream fileOut = new FileOutputStream(dir);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(serie);
			out.close();
			fileOut.close();
		}
		
		public static Serie deserialitzacio (String dir) throws IOException, ClassNotFoundException {
			File file = new File(dir);
			Serie serie = null;
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			serie = (Serie) in.readObject();
			in.close();
			fileIn.close();
			return serie;
		}

			
		
	
}
