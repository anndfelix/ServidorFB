/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Exception.DAOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import objetosNegocio.Publicacion;
import objetosNegocio.RelEtiquetados;

/**
 *
 * @author Andrea
 */
public class PublicacionDAO extends BaseDAO<Publicacion> {

    public ArrayList<Publicacion> consultar() throws DAOException {

        EntityManager em = this.generarConexion();
        Query consulta = em.createQuery("SELECT p FROM Publicacion p");

        List<Publicacion> publicaciones = consulta.getResultList();
        return new ArrayList<>(publicaciones);
    }

    @Override
    public void insertar(Publicacion usuario) throws DAOException {
        try {
            EntityManager em = this.generarConexion();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Publicacion publicacion) throws DAOException {

        EntityManager em = this.generarConexion();
        em.getTransaction().begin();

        Publicacion p = em.find(Publicacion.class, publicacion.getId());

        try {
            if (p != null) {
                p.setComentarios(publicacion.getComentarios());
                p.setRelaciones(publicacion.getRelaciones());

                em.persist(p);

            } else {
                throw new DAOException("El usuario " + publicacion.getId() + " no existe!");
            }
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }

        em.getTransaction().commit();
    }

    @Override
    public Publicacion consultarID(Long id) throws DAOException {

        EntityManager em = this.generarConexion();
        Publicacion publicacion = em.find(Publicacion.class, id);

        try {
            if (publicacion != null) {
                return publicacion;
            } else {
                throw new DAOException("La publicacion " + id + " no existe!");
            }
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
            return publicacion;
        }

    }

    @Override
    public void eliminar(Long id) throws DAOException {

        EntityManager em = this.generarConexion();
        em.getTransaction().begin();

        Publicacion publicacion = em.find(Publicacion.class, id);

        try {

            if (publicacion != null) {
                em.remove(publicacion);
                System.out.println("Se elimino la publicacion: " + publicacion.getId());
            } else {
                throw new DAOException("La publicacion " + id + " no existe!");
            }

        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        em.getTransaction().commit();
    }

    public ArrayList<RelEtiquetados> ventasRelaciones(Long id) throws DAOException {
        Publicacion publicacion = this.consultarID(id);
        List<RelEtiquetados> etiquetados = publicacion.getRelaciones();
        return new ArrayList<>(etiquetados);
    }

}
