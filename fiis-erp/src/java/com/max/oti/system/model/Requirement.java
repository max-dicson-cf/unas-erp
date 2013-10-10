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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "requirement", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requirement.findAll", query = "SELECT r FROM Requirement r")})
public class Requirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number")
    private int number;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequirement")
    private List<AlumnRequirement> alumnRequirementList;
    @JoinColumn(name = "id_type_comission", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeComission idTypeComission;
    @JoinColumn(name = "id_modality", referencedColumnName = "id")
    @ManyToOne
    private Modality idModality;

    public Requirement() {
    }

    public Requirement(Integer id) {
        this.id = id;
    }

    public Requirement(Integer id, int number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<AlumnRequirement> getAlumnRequirementList() {
        return alumnRequirementList;
    }

    public void setAlumnRequirementList(List<AlumnRequirement> alumnRequirementList) {
        this.alumnRequirementList = alumnRequirementList;
    }

    public TypeComission getIdTypeComission() {
        return idTypeComission;
    }

    public void setIdTypeComission(TypeComission idTypeComission) {
        this.idTypeComission = idTypeComission;
    }

    public Modality getIdModality() {
        return idModality;
    }

    public void setIdModality(Modality idModality) {
        this.idModality = idModality;
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
        if (!(object instanceof Requirement)) {
            return false;
        }
        Requirement other = (Requirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.Requirement[ id=" + id + " ]";
    }
    
}
