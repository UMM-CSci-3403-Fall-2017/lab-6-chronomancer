package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String[] args) {
	try {
		//See EchoClient because the comments are almost identical
		ServerSocket socket = new ServerSocket(6013);
		byte[] in = new byte[1];
		while(true) {
		Socket socket_client = socket.accept();

		InputStream IN = socket_client.getInputStream();
		OutputStream out = socket_client.getOutputStream();
	
		while(IN.read(in) != -1) {
			out.write(in);
		}
		}

	} catch (IOException err) {
		System.out.println("yay more failure");
		System.err.println(err);
	}
}
}
