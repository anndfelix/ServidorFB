package filtros;

import DAO.UsuarioDAO;
import Exception.DAOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.json.JSONObject;
import objetosNegocio.Sexo;
import objetosNegocio.Usuario;

public class RegistrarseFilter {

    UsuarioDAO udao = new UsuarioDAO();

    public void registrarse(JSONObject object) throws DAOException {

        System.out.println("Name:" + object.getString("name"));
        System.out.println("password:" + object.getString("password"));
        System.out.println("fecha:" + object.getString("fecha"));
        System.out.println("email:" + object.getString("email"));
        System.out.println("edad:" + object.getString("edad"));
        System.out.println("numero:" + object.getString("numero"));
        System.out.println("sexo:" + object.getString("sexo"));

        Usuario usuario = new Usuario();

        usuario.setNombre(object.getString("name"));
        usuario.setContraseña(object.getString("password"));
        usuario.setEmail(object.getString("email"));
        usuario.setFecha(new GregorianCalendar(0, 0, 0));
        usuario.setNumeroCelular(object.getString("numero"));
        usuario.setSexo(Sexo.valueOf(object.getString("sexo")));
        usuario.setEdad(Integer.parseInt(object.getString("edad")));

        udao.insertar(usuario);
    }

   

}
