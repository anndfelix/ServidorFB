package mapeoobjetosnegocio;

import DAO.PublicacionDAO;
import DAO.UsuarioDAO;
import Exception.DAOException;
import filtros.RegistrarseFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Scanner;
import net.sf.json.JSONObject;
import objetosNegocio.Publicacion;
import objetosNegocio.Usuario;

public class MenuOperaciones {

    int numerador;
    RegistrarseFilter registrar = new RegistrarseFilter();
    Scanner in = new Scanner(System.in);
    InputStreamReader isr;
    BufferedReader br;
    OutputStreamWriter osw;
    BufferedWriter rw;

    public MenuOperaciones() {
    }

    public MenuOperaciones(int numerador) {
        this.numerador = numerador;
    }

    public JSONObject crearUsuario(Usuario usuario) throws IOException {
        JSONObject obj = JSONObject.fromObject(usuario);
        return obj;
    }

    public void registrarUsuario() throws DAOException, ParseException {

        try {
            ServerSocket serverSocket = new ServerSocket(200);
            Socket socket = serverSocket.accept();
            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);
            String str = br.readLine();
            JSONObject object = JSONObject.fromObject(str);

            registrar.registrarse(object);

            br.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

}
