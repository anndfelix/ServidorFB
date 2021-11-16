package DAO;

import Exception.DAOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import objetosNegocio.RelEtiquetados;

public class RelEtiquetadosDAO extends BaseDAO<RelEtiquetados> {

    @Override
    public ArrayList<RelEtiquetados> consultar() throws DAOException {
        EntityManager em = this.generarConexion();
        Query consulta = em.createQuery("SELECT r FROM RelEtiquetados r");
        List<RelEtiquetados> relaciones = consulta.getResultList();
        return new ArrayList<>(relaciones);
    }

    @Override
    public void insertar(RelEtiquetados rel) throws DAOException {
        try {
            EntityManager em = this.generarConexion();
            em.getTransaction().begin();
            em.persist(rel);
            em.getTransaction().commit();
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(RelEtiquetados rels) throws DAOException {
        EntityManager em = this.generarConexion();
        em.getTransaction().begin();

        RelEtiquetados rel = em.find(RelEtiquetados.class, rels.getId());

        try {
            if (rel != null) {
                em.persist(rel);
            } else {
                throw new DAOException("La relacion " + rels.getId() + " no existe!");
            }
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }

        em.getTransaction().commit();
    }

    @Override
    public RelEtiquetados consultarID(Long id) throws DAOException {
        EntityManager em = this.generarConexion();
        RelEtiquetados rel = em.find(RelEtiquetados.class, id);

        try {
            if (rel != null) {
                System.out.println(rel);
                return rel;
            } else {
                throw new DAOException("La relacion " + id + " no existe!");
            }
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
            return rel;
        }

    }

    @Override
    public void eliminar(Long id) throws DAOException {
        EntityManager em = this.generarConexion();
        em.getTransaction().begin();

        RelEtiquetados rel = em.find(RelEtiquetados.class, id);

        try {
            if (rel != null) {
                em.remove(rel);
                System.out.println("Se elimino la relacion: " + rel.getId());
            } else {
                throw new DAOException("La relacion " + id + " no existe!");
            }

        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        em.getTransaction().commit();
    }

    public ArrayList<RelEtiquetados> etiquetasRelaciones(Long id) throws DAOException {

        ArrayList<RelEtiquetados> etiquetas = new ArrayList<>();
        List<RelEtiquetados> relaciones = this.consultar();

        for (RelEtiquetados rel : relaciones) {

            if (rel.getPublicacion().getId().equals(id)) {
                etiquetas.add(rel);
            }
        }

        if (etiquetas.isEmpty()) {
            throw new DAOException("La publicacion " + id + " no tiene etiquetas!");
        } else {
            return etiquetas;
        }
    }
}
