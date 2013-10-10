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
@Table(name = "member", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m")})
public class Member1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "code_teacher")
    private String codeTeacher;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_state")
    private int idState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMember")
    private List<Assistance> assistanceList;
    @JoinColumn(name = "id_comission", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comission idComission;
    @JoinColumn(name = "id_charge", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Charge idCharge;

    public Member1() {
    }

    public Member1(Integer id) {
        this.id = id;
    }

    public Member1(Integer id, String codeTeacher, int idState) {
        this.id = id;
        this.codeTeacher = codeTeacher;
        this.idState = idState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeTeacher() {
        return codeTeacher;
    }

    public void setCodeTeacher(String codeTeacher) {
        this.codeTeacher = codeTeacher;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    @XmlTransient
    public List<Assistance> getAssistanceList() {
        return assistanceList;
    }

    public void setAssistanceList(List<Assistance> assistanceList) {
        this.assistanceList = assistanceList;
    }

    public Comission getIdComission() {
        return idComission;
    }

    public void setIdComission(Comission idComission) {
        this.idComission = idComission;
    }

    public Charge getIdCharge() {
        return idCharge;
    }

    public void setIdCharge(Charge idCharge) {
        this.idCharge = idCharge;
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
        if (!(object instanceof Member1)) {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.Member1[ id=" + id + " ]";
    }
    
}
