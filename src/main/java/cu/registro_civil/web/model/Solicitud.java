/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.registro_civil.web.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Solicitud {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombres_apellidos")
    private String nombresApellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "surtir_efecto")
    private Character surtirEfecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_certif")
    private int cantCertif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cod")
    private String cod;
    @Column(name = "tipo", insertable = false, updatable = false)
    private String tipo;
    @Size(max = 2147483647)
    @Column(name = "otros_datos")
    private String otrosDatos;
    @Basic(optional = false)
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy' 'HH:mm:ss")
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estado")
    private String estado;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "movil")
    private String movil;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @JoinColumn(name = "id_ofic_reg_civil_inscrito", referencedColumnName = "id")
    @ManyToOne(optional = false)
    protected OficinaRegistroCivil idOficRegCivilInscrito;

    @JoinColumn(name = "id_ofic_reg_civil_a_recoger", referencedColumnName = "id")
    @ManyToOne(optional = false)
    protected OficinaRegistroCivil idOficRegCivilARecoger;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
//    protected Collection<HistorialEstadoSolicitud> historialEstadoSolicitudCollection;
    public Solicitud() {
    }

    public Solicitud(Integer id) {
        this.id = id;
    }

    public Solicitud(Integer id, String nombresApellidos, Character surtirEfecto, int cantCertif, String cod, String tipo, Date fechaSolicitud, String estado) {
        this.id = id;
        this.nombresApellidos = nombresApellidos;
        this.surtirEfecto = surtirEfecto;
        this.cantCertif = cantCertif;
        this.cod = cod;
        this.tipo = tipo;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public Character getSurtirEfecto() {
        return surtirEfecto;
    }

    public void setSurtirEfecto(Character surtirEfecto) {
        this.surtirEfecto = surtirEfecto;
    }

    public int getCantCertif() {
        return cantCertif;
    }

    public void setCantCertif(int cantCertif) {
        this.cantCertif = cantCertif;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOtrosDatos() {
        return otrosDatos;
    }

    public void setOtrosDatos(String otrosDatos) {
        this.otrosDatos = otrosDatos;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public OficinaRegistroCivil getIdOficRegCivilInscrito() {
        return idOficRegCivilInscrito;
    }

    public void setIdOficRegCivilInscrito(OficinaRegistroCivil idOficRegCivilInscrito) {
        this.idOficRegCivilInscrito = idOficRegCivilInscrito;
    }

    public OficinaRegistroCivil getIdOficRegCivilARecoger() {
        return idOficRegCivilARecoger;
    }

    public void setIdOficRegCivilARecoger(OficinaRegistroCivil idOficRegCivilARecoger) {
        this.idOficRegCivilARecoger = idOficRegCivilARecoger;
    }

//    @XmlTransient
//    public Collection<HistorialEstadoSolicitud> getHistorialEstadoSolicitudCollection() {
//        return historialEstadoSolicitudCollection;
//    }
//
//    public void setHistorialEstadoSolicitudCollection(Collection<HistorialEstadoSolicitud> historialEstadoSolicitudCollection) {
//        this.historialEstadoSolicitudCollection = historialEstadoSolicitudCollection;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public void generarCod() {
        // Creating a random UUID (Universally unique identifier).
        String uuid = UUID.randomUUID().toString();
        /*ejemplo de UUID : 5fc03087-d265-11e7-b8c6-83e29cd24f4c
         Seleccionar solamente los caracteres que sean numeros y eliminando los espacios en blanco*/
        String uuidNumeros = String.format("%040d", new BigInteger(uuid.replace("-", ""), 16));
        String ultimos7 = uuidNumeros.substring(uuidNumeros.length() - 7);
        String codSolicitud = "RC" + ultimos7 + getIdOficRegCivilInscrito().getDescr().substring(0, 3).toUpperCase();
        setCod(codSolicitud);
    }

    @Override
    public String toString() {
        return "cu.registro_civil.web.model.Solicitud[ id=" + id + " ]";
    }

}
