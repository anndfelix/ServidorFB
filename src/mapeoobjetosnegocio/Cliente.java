package mapeoobjetosnegocio;

import DAO.PublicacionDAO;
import DAO.UsuarioDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import net.sf.json.JSONObject;
import objetosNegocio.Publicacion;
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

            Publicacion publicacion = new Publicacion();
            PublicacionDAO pdao = new PublicacionDAO();
            UsuarioDAO udao = new UsuarioDAO();
            LocalDateTime fecha = LocalDateTime.now();

            Usuario usuario = udao.consultarID(14L);
            List<String> etiquetas = new ArrayList<>();

            etiquetas.add("#Hola");

            publicacion.setContenido("Hola hola");
            publicacion.setEtiquetas(etiquetas);
            publicacion.setUsuarioCreador(usuario);
            publicacion.setFechaHoraCreacion(new GregorianCalendar(fecha.getYear(), fecha.getMonthValue() - 1, fecha.getDayOfMonth(), fecha.getHour(), fecha.getMinute(), fecha.getSecond()));

//            Usuario usuario = new Usuario("Elizabeth", "eli@gmail.com", Sexo.O, "6441714360", "coco", 20, new GregorianCalendar(2001, 8, 25));

            JSONObject obj = JSONObject.fromObject(publicacion);
            
            

//            obj.put("name", usuario.getNombre());
//            obj.put("password", usuario.getContraseña());
//            obj.put("fecha", usuario.getFecha());
//            obj.put("email", usuario.getEmail());
//            obj.put("edad", usuario.getEdad());
//            obj.put("numero", usuario.getNumeroCelular());
//            obj.put("sexo", usuario.getSexo());

            rw.write(obj.toString() + "\n");
            rw.close();
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
