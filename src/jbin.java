import java.io.*;
import java.util.Scanner;

public class jbin
{
	public static void jarToBinary(String jar, String binary) throws IOException, InterruptedException
	{
		try {
			try {
				File binaryFile = new File(binary);

				// Deletes file if exists.
				binaryFile.delete();

				// Creates blank file.
				binaryFile.createNewFile();
			} catch (FileNotFoundException e) {

			} catch (IOException e) {
				System.out.println("Error reading file '" + binary + "'.");
			}

			// Creates executable binary.
			try {
				byte[] buffer = new byte[(int) (new File(jar)).length()];

				FileInputStream shebangInputStream = new FileInputStream("shebang.txt");
				FileInputStream jarInputStream = new FileInputStream(jar);

				int shebangRead = 0;
				int jarRead = 0;

				while((jarRead = jarInputStream.read(buffer)) != -1 && (shebangRead = shebangInputStream.read(buffer)) != -1) {
					FileOutputStream outputStream = new FileOutputStream(binary);

          outputStream.write(buffer);
          outputStream.close();
				}

				shebangInputStream.close();
				jarInputStream.close();
			} catch (FileNotFoundException e) {
				System.out.println("Unable to open file '" + jar + "'.");
			} catch (IOException e) {
				System.out.println("Error reading file '" + jar + "'.");
			}

			// Allow execution.
			try {
				File binaryFile = new File(binary);

				binaryFile.setExecutable(true);
			} catch (SecurityException e) { // If permissions are not sufficient.
				System.out.println("Unable to set '" + binary + "' to executable.");
				System.out.println("Do this manually with: chmod +x " + binary);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void sourceToJAR(String main, )
	{

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length == 2) {
			jbin.jarToBinary(args[0], args[1]);
		}
	}
}
