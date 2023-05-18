package N1E4;

import java.io.IOException;

public class Main {
	public static void main (String args[]) {
		
		try {
			LlistaDir.llistaDir("C:\\Users\\formacio\\Desktop");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
