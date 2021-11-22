package mapeoobjetosnegocio;

import DAO.UsuarioDAO;
import Exception.DAOException;
import filtros.IniciarSesionFilter;
import filtros.RegistrarseFilter;
import filtros.publicacionFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Scanner;


public class Servidor {

    public static void main(String[] args) throws DAOException, ParseException {
        Scanner in = new Scanner(System.in);
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter rw;
        UsuarioDAO udao = new UsuarioDAO();
        RegistrarseFilter registrar = new RegistrarseFilter();
        IniciarSesionFilter iniciarSesion = new IniciarSesionFilter();
        publicacionFilter publicar = new publicacionFilter();
        MenuOperaciones menu = new MenuOperaciones();

        menu.registrarUsuario();

    }

}
