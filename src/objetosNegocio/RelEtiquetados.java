package objetosNegocio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "rel_publicacionEtiquetas")
public class RelEtiquetados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_relacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "id_publicacion", nullable = false)
    private Publicacion publicacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RelEtiquetados() {
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
        if (!(object instanceof RelEtiquetados)) {
            return false;
        }
        RelEtiquetados other = (RelEtiquetados) object;
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
