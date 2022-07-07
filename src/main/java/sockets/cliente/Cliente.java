package sockets.cliente;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente{

    public static void main(String[] args) {
        String host= "127.0.0.1";
        int port= 5505;
        DataInputStream in;
        DataOutputStream out;

        try {

            Socket socket = new Socket(host, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("hola servidor");

            String message = in.readUTF();

            System.out.println(message);

            socket.close();

        }catch (IOException e){

            e.printStackTrace();
        }
    }
}
