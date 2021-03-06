package filtros;

import DAO.PublicacionDAO;
import DAO.UsuarioDAO;
import Exception.DAOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import objetosNegocio.Publicacion;
import objetosNegocio.Usuario;

public class publicacionFilter {

    Publicacion publicacion = new Publicacion();
    PublicacionDAO pdao = new PublicacionDAO();
    UsuarioDAO udao = new UsuarioDAO();
    LocalDateTime fecha = LocalDateTime.now();

    public void publicar(String contenido, List<String> etiquetas, Usuario usuarioCreador, GregorianCalendar fechaHoraCreacion) throws DAOException {

        publicacion.setContenido(contenido);
        publicacion.setEtiquetas(etiquetas);
        publicacion.setUsuarioCreador(usuarioCreador);
        publicacion.setFechaHoraCreacion(fechaHoraCreacion);

        pdao.insertar(publicacion);
    }

    public List<String> listaEtiquetas(String contenido) {

        Pattern p = Pattern.compile("(#[^#\\s]*)");
        Matcher m = p.matcher(contenido);
        List<String> etiquetas = new ArrayList<String>();

        while (m.find()) {
            etiquetas.add(m.group());
        }

        return etiquetas;
    }

    public Usuario usuarioCreador(String usuario) throws DAOException {

        Pattern p = Pattern.compile("(?<=id\":)[\\d]{2,}");
        Matcher m = p.matcher(usuario);
        Usuario u = new Usuario();

        if (m.find()) {
            u = udao.consultarID(Long.valueOf(m.group()));
        }
        return u;

    }
    

}
