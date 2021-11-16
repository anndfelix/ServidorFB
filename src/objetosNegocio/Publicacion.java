package objetosNegocio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "publicaciones")
public class Publicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_publicacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fechaHoraCreacion", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar fechaHoraCreacion;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuarioCreador;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "etiquetas", nullable = false)
    private List<String> etiquetas;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<RelEtiquetados> relaciones;

    public Publicacion() {
    }

    public Publicacion(Calendar fechaHoraCreacion, Usuario usuarioCreador, String contenido, List<String> etiquetas, List<Comentario> comentarios) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.usuarioCreador = usuarioCreador;
        this.contenido = contenido;
        this.etiquetas = etiquetas;
        this.comentarios = comentarios;
    }

    public Calendar getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Calendar fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public List<RelEtiquetados> getRelaciones() {
        return relaciones;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setRelaciones(List<RelEtiquetados> relaciones) {
        this.relaciones = relaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Publicacion)) {
            return false;
        }
        Publicacion other = (Publicacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publicacion[ id=" + id + " ]";
    }

}
