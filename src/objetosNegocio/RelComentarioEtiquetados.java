/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author Andrea
 */
@Entity
@Table(name = "rel_comentarioEtiquetas")
public class RelComentarioEtiquetados implements Serializable {

   private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_relacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "id_comentario", nullable = false)
    private Comentario comentario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RelComentarioEtiquetados() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelComentarioEtiquetados)) {
            return false;
        }
        RelComentarioEtiquetados other = (RelComentarioEtiquetados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.RelEtiquetados[ id=" + id + " ]";
    }
    
}

