/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author max
 */
@Entity
@Table(name = "alumn_requirement", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnRequirement.findAll", query = "SELECT a FROM AlumnRequirement a")})
public class AlumnRequirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "code_alumn")
    private String codeAlumn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_state")
    private int idState;
    @Size(max = 2147483647)
    @Column(name = "datail")
    private String datail;
    @JoinColumn(name = "id_requirement", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Requirement idRequirement;

    public AlumnRequirement() {
    }

    public AlumnRequirement(Integer id) {
        this.id = id;
    }

    public AlumnRequirement(Integer id, String codeAlumn, int idState) {
        this.id = id;
        this.codeAlumn = codeAlumn;
        this.idState = idState;
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

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getDatail() {
        return datail;
    }

    public void setDatail(String datail) {
        this.datail = datail;
    }

    public Requirement getIdRequirement() {
        return idRequirement;
    }

    public void setIdRequirement(Requirement idRequirement) {
        this.idRequirement = idRequirement;
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
        if (!(object instanceof AlumnRequirement)) {
            return false;
        }
        AlumnRequirement other = (AlumnRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.AlumnRequirement[ id=" + id + " ]";
    }
    
}
