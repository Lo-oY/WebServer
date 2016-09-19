import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Lo_oY on 2016/9/6.
 */
public class SimpleWeb {

    public static void main(String args[]){

        String errorMessage = "HTTP/1.1 200 OK\r\n\r\n"+
//                "Content-Type: text/html\r\n" +
                "hello world";
        ServerSocket server = null;
        try {
             server = new ServerSocket(8080);
            while (true){
                byte[] b = new byte[1024];
                Socket socket = server.accept();
                System.out.println("lianjie");
                InputStream inputStream = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                inputStream.read(b);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new String(b));
                os.write(errorMessage.getBytes("utf-8"));

                socket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
