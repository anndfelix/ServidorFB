package mapeoobjetosnegocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.GregorianCalendar;
import java.util.Scanner;

import net.sf.json.JSONObject;
import objetosNegocio.Sexo;
import objetosNegocio.Usuario;

public class Cliente {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter rw;
        try {

            Socket socket = new Socket("localhost", 500);
            osw = new OutputStreamWriter(socket.getOutputStream());
            rw = new BufferedWriter(osw);

            Usuario usuario = new Usuario("Elizabeth", "andrea@gmail.com", Sexo.O, "6441714360", "coco", 20, new GregorianCalendar(2001, 8, 25));

            JSONObject obj = new JSONObject();

            obj.put("name", usuario.getNombre());
            obj.put("password", usuario.getContraseña());
            obj.put("fecha",usuario.getFecha());
            obj.put("email",usuario.getEmail());
            obj.put("edad",usuario.getEdad());
            obj.put("numero",usuario.getNumeroCelular());
            obj.put("sexo", usuario.getSexo());
            
            rw.write(obj.toString() + "\n");
            rw.close();
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
