package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) {
		try { 
			Socket socket = new Socket("127.0.0.1", 6013);
			
			OutputStream outstream = socket.getOutputStream();
			InputStream instream = socket.getInputStream();

			byte[] written = new byte[1];

			while(instream.read(written) != -1) {
				outstream.write(written);

				byte[] printed = new byte[1];
				instream.read(printed);
				System.out.write(printed, 0, 1);
			}
			instream.close();
			outstream.close();
		} catch (IOException err) {
			System.out.println("Yaaaay failure");
			System.err.println(err);
		}
	}
			
}
