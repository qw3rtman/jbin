import java.io.*;
import java.util.Scanner;

public class jbin
{
	public static void jarToBinary(String jar, String binary) throws IOException, InterruptedException
	{
		try {
			// Deletes file if exists.
			Process pClear = Runtime.getRuntime().exec(new String[]{"rm", "-rf", binary});
			pClear.waitFor();

			// Creates blank file.
			Process pTouch = Runtime.getRuntime().exec(new String[]{"touch", binary});
			pTouch.waitFor();

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
			Process pExecute = Runtime.getRuntime().exec(new String[]{"chmod", "+x", binary});
			pExecute.waitFor();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void sourceToJAR()
	{

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		jbin.jarToBinary("HelloWorld.jar", "HelloWorld");
	}
}
