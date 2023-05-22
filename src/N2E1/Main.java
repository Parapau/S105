package N2E1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
	public static void main (String args[]) throws IOException {
		String configFilePath = "src/configuracio";
		FileInputStream propsInput = new FileInputStream(configFilePath);
		Properties prop = new Properties ();
		prop.load(propsInput);
		LlistaDir.llistaDir(prop.getProperty("DIRECCIO"));
	}
}
