package mapeoobjetosnegocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetosNegocio.Publicacion;
import objetosNegocio.Sexo;
import objetosNegocio.Usuario;

public class MapeoObjetosNegocio {

    public static void main(String[] args) throws Exception {

        EntityManager em = generarConexion();
        em.getTransaction().begin();

        Usuario usuario = new Usuario("Andrea", "andrea@gmail.com", Sexo.O, "6441714360", "123456a", 20, new GregorianCalendar(2001, 8, 25));

        List<String> etiquetas = new ArrayList<>();
        List<Usuario> usuariosEtiquetados = new ArrayList<>();
        usuariosEtiquetados.add(usuario);

        Publicacion p = new Publicacion();
        p.setUsuarioCreador(usuario);
        p.setContenido("Hola");
        p.setFechaHoraCreacion(new GregorianCalendar());
        p.setEtiquetas(etiquetas);

        em.persist(usuario);
        em.persist(p);
        em.getTransaction().commit();
    }

    protected static EntityManager generarConexion() throws Exception {

        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ObjetosNegocioPU");
            EntityManager em = emf.createEntityManager();
            return em;

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw new Exception(ex.getMessage(), ex);
        }
    }

}
