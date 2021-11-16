package mapeoobjetosnegocio;

import DAO.UsuarioDAO;
import Exception.DAOException;
import filtros.IniciarSesionFilter;
import filtros.RegistrarseFilter;
import filtros.publicacionFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.GregorianCalendar;
import java.util.Scanner;
import net.sf.json.JSONObject;
import objetosNegocio.Sexo;
import objetosNegocio.Usuario;

public class Servidor {

    public static void main(String[] args) throws DAOException {
        Scanner in = new Scanner(System.in);
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter rw;
        UsuarioDAO udao = new UsuarioDAO();
        RegistrarseFilter registrar = new RegistrarseFilter();
        IniciarSesionFilter iniciarSesion = new IniciarSesionFilter();
        publicacionFilter publicar = new publicacionFilter();

        try {
            ServerSocket serverSocket = new ServerSocket(500);
            Socket socket = serverSocket.accept();
            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);
            String str = br.readLine();
            JSONObject object = JSONObject.fromObject(str);
//
//            object.getString("contenido");
//            object.getString("etiquetas");
//            object.getString("usuarioCreador");
//            object.getString("fechaHoraCreacion");
//            
            System.out.println(object.getString("contenido"));
            System.out.println(object.getString("etiquetas"));
            System.out.println(object.getString("usuarioCreador"));
            System.out.println(object.getString("fechaHoraCreacion"));

//            publicar.publicar(object.getString("contenido"), publicar.listaEtiquetas(object.getString("etiquetas")), object.getString("usuarioCreador"), object.getString("fechaHoraCreacion"));
            br.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
