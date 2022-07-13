package sockets.servidor;

import sockets.cypher.Cypher;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{


    Cypher cypher = new Cypher();
    public static void main(String[] args) {
        //clave de encriptacion

        ServerSocket server = null;
        Socket socket = null;
        int port = 5505;
        DataInputStream in;
        DataOutputStream out;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            while(true){
                socket = server.accept();
                System.out.println("Client connect");

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println(message);

                out.writeUTF("Output");

                socket.close();

                System.out.println("Client disconnect");

            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
