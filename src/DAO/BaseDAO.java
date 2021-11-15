package DAO;

import Exception.*;
import java.util.ArrayList;
import javax.persistence.*;

public abstract class BaseDAO<T> {

    protected EntityManager generarConexion() throws DAOException {

        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ObjetosNegocioPU");
            EntityManager em = emf.createEntityManager();
            return em;

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public abstract ArrayList<T> consultar() throws DAOException;

    public abstract void insertar(T entidad) throws DAOException;

    public abstract void actualizar(T entidad) throws DAOException;

    public abstract T consultarID(Long id) throws DAOException;

    public abstract void eliminar(Long id) throws DAOException;

}
