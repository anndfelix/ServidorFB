package filtros;

import DAO.PublicacionDAO;
import DAO.UsuarioDAO;
import Exception.DAOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

}
