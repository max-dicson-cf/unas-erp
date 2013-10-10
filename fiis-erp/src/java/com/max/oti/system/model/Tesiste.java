/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author max
 */
@Entity
@Table(name = "tesiste", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tesiste.findAll", query = "SELECT t FROM Tesiste t")})
public class Tesiste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 18)
    @Column(name = "code_alumn")
    private String codeAlumn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_init")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTesiste")
    private List<PlaningTesis> planingTesisList;

    public Tesiste() {
    }

    public Tesiste(Integer id) {
        this.id = id;
    }

    public Tesiste(Integer id, Date dateInit) {
        this.id = id;
        this.dateInit = dateInit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeAlumn() {
        return codeAlumn;
    }

    public void setCodeAlumn(String codeAlumn) {
        this.codeAlumn = codeAlumn;
    }

    public Date getDateInit() {
        return dateInit;
    }

    public void setDateInit(Date dateInit) {
        this.dateInit = dateInit;
    }

    @XmlTransient
    public List<PlaningTesis> getPlaningTesisList() {
        return planingTesisList;
    }

    public void setPlaningTesisList(List<PlaningTesis> planingTesisList) {
        this.planingTesisList = planingTesisList;
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
        if (!(object instanceof Tesiste)) {
            return false;
        }
        Tesiste other = (Tesiste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.Tesiste[ id=" + id + " ]";
    }
    
}
