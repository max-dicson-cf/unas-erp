/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author max
 */
@Entity
@Table(name = "type_comission", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeComission.findAll", query = "SELECT t FROM TypeComission t")})
public class TypeComission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_state")
    private int idState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeComission")
    private List<Comission> comissionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeComission")
    private List<Jury> juryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeComission")
    private List<Requirement> requirementList;

    public TypeComission() {
    }

    public TypeComission(Integer id) {
        this.id = id;
    }

    public TypeComission(Integer id, String name, int idState) {
        this.id = id;
        this.name = name;
        this.idState = idState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    @XmlTransient
    public List<Comission> getComissionList() {
        return comissionList;
    }

    public void setComissionList(List<Comission> comissionList) {
        this.comissionList = comissionList;
    }

    @XmlTransient
    public List<Jury> getJuryList() {
        return juryList;
    }

    public void setJuryList(List<Jury> juryList) {
        this.juryList = juryList;
    }

    @XmlTransient
    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
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
        if (!(object instanceof TypeComission)) {
            return false;
        }
        TypeComission other = (TypeComission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.TypeComission[ id=" + id + " ]";
    }
    
}
