import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 6/6/16 1:58 PM
 */
public class HelloWorld {
	public static void main(String[] args) throws IOException, InterruptedException {
		final long initialTime = System.currentTimeMillis();
		System.out.println("started...");

		final File thefile = File.createTempFile("tst", "mg");
		final FileOutputStream out = new FileOutputStream(thefile);

		System.out.printf("writing to %s\n", thefile.getAbsolutePath());
		for(int i=100_000; i > 0; i--){
			byte[] buffer = String.format("linha de teste: %s\n", System.currentTimeMillis()).getBytes();
			out.write(buffer);
		}
		out.close();

		System.out.printf("file writed in %.2fs\n", (System.currentTimeMillis() - initialTime) / 1000.0);

		thefile.delete();
		Thread.sleep(300000000000L);

		System.out.println("exiting...");
	}
}
