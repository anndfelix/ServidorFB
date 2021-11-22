package filtros;

import DAO.UsuarioDAO;
import Exception.DAOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import net.sf.json.JSONObject;
import objetosNegocio.Sexo;
import objetosNegocio.Usuario;

public class IniciarSesionFilter {

    UsuarioDAO udao = new UsuarioDAO();

    public void iniciarSesion(JSONObject object) throws DAOException {

        System.out.println("Name:" + object.getString("name"));
        System.out.println("password:" + object.getString("password"));
        System.out.println("email:" + object.getString("email"));

        Usuario usuario = new Usuario();

        usuario.setNombre(object.getString("name"));
        usuario.setContraseña(object.getString("password"));
        usuario.setEmail(object.getString("email"));
        usuario.setFecha(new Date(121, 10, 25));
        usuario.setNumeroCelular(object.getString("numero"));
        usuario.setSexo(Sexo.valueOf(object.getString("sexo")));
        usuario.setEdad(Integer.parseInt(object.getString("edad")));

        System.out.println(usuario.getEmail());
        System.out.println(usuario.getContraseña());

        List<Usuario> usuarios = udao.consultar();

        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(usuario.getEmail())) {

                if (u.getContraseña().equalsIgnoreCase(usuario.getContraseña())) {

                    System.out.println("bienvenido");
                }

            } else {

            }
        }

    }

}
