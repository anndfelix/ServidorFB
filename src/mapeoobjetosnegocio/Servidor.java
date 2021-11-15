package mapeoobjetosnegocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import net.sf.json.JSONObject;

public class Servidor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter rw;

        try {
            ServerSocket serverSocket = new ServerSocket(500);
            Socket socket = serverSocket.accept();
            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);
            String str = br.readLine();
            JSONObject object = JSONObject.fromObject(str);

            System.out.println("Name:" + object.getString("name"));
            System.out.println("password:" + object.getString("password"));
            System.out.println("fecha:" + object.getString("fecha"));
            System.out.println("email:" + object.getString("email"));
            System.out.println("edad:" + object.getString("edad"));
            System.out.println("numero:" + object.getString("numero"));
            System.out.println("sexo:" + object.getString("sexo"));

            br.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
