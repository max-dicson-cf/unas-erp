/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author max
 */
@Entity
@Table(name = "modality", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modality.findAll", query = "SELECT m FROM Modality m")})
public class Modality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mane")
    private int mane;
    @OneToMany(mappedBy = "idModality")
    private List<Sustentation> sustentationList;
    @OneToMany(mappedBy = "idModality")
    private List<Requirement> requirementList;

    public Modality() {
    }

    public Modality(Integer id) {
        this.id = id;
    }

    public Modality(Integer id, int mane) {
        this.id = id;
        this.mane = mane;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMane() {
        return mane;
    }

    public void setMane(int mane) {
        this.mane = mane;
    }

    @XmlTransient
    public List<Sustentation> getSustentationList() {
        return sustentationList;
    }

    public void setSustentationList(List<Sustentation> sustentationList) {
        this.sustentationList = sustentationList;
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
        if (!(object instanceof Modality)) {
            return false;
        }
        Modality other = (Modality) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.Modality[ id=" + id + " ]";
    }
    
}
