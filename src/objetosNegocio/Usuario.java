package objetosNegocio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "sexo", nullable = false, length = 1)
    private Sexo sexo;

    @Column(name = "numeroCelular", nullable = false, length = 10)
    private String numeroCelular;

    @Column(name = "contraseña", nullable = false, length = 20)
    private String contraseña;

    @Column(name = "edad", nullable = false, length = 3)
    private int edad;

    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date fecha;

    @OneToMany(mappedBy = "usuarioCreador", cascade = CascadeType.ALL)
    private List<Publicacion> publicaciones;

    public Usuario() {
    }

    public Usuario(String nombre, String email, Sexo sexo, String numeroCelular, String contraseña, int edad, Date fecha) {
        this.nombre = nombre;
        this.email = email;
        this.sexo = sexo;
        this.numeroCelular = numeroCelular;
        this.contraseña = contraseña;
        this.edad = edad;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario[ id=" + id + " ]";
    }

}
