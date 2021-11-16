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
import objetosNegocio.Usuario;

/**
 *
 * @author Andrea
 */
public class UsuarioDAO extends BaseDAO<Usuario> {

    public ArrayList<Usuario> consultar() throws DAOException {

        EntityManager em = this.generarConexion();
        Query consulta = em.createQuery("SELECT u FROM Usuario u");

        List<Usuario> usuarios = consulta.getResultList();
        return new ArrayList<>(usuarios);
    }

    @Override
    public void insertar(Usuario usuario) throws DAOException {
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
    public void actualizar(Usuario usuario) throws DAOException {

        EntityManager em = this.generarConexion();
        em.getTransaction().begin();

        Usuario u = em.find(Usuario.class, usuario.getId());

        try {
            if (u != null) {
                u.setNombre(usuario.getNombre());
                u.setSexo(usuario.getSexo());
                u.setFecha(usuario.getFecha());
                u.setEdad(usuario.getEdad());

                em.persist(u);

            } else {
                throw new DAOException("El usuario " + usuario.getId() + " no existe!");
            }
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }

        em.getTransaction().commit();
    }

    @Override
    public Usuario consultarID(Long id) throws DAOException {

        EntityManager em = this.generarConexion();
        Usuario usuario = em.find(Usuario.class, id);

        try {
            if (usuario != null) {
                return usuario;
            } else {
                throw new DAOException("El usuario " + id + " no existe!");
            }
        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
            return usuario;
        }

    }

    @Override
    public void eliminar(Long id) throws DAOException {

        EntityManager em = this.generarConexion();
        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, id);

        try {

            if (usuario != null) {
                em.remove(usuario);
                System.out.println("Se elimino el usuario: " + usuario.getNombre());
            } else {
                throw new DAOException("El usuario " + id + " no existe!");
            }

        } catch (DAOException ex) {
            System.out.println(ex.getMessage());
        }
        em.getTransaction().commit();
    }

}
