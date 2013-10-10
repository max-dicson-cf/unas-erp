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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "comission", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comission.findAll", query = "SELECT c FROM Comission c")})
public class Comission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "document_formal")
    private String documentFormal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_state")
    private int idState;
    @JoinColumn(name = "id_type_comission", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeComission idTypeComission;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComission")
    private List<Member1> member1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComission")
    private List<Session> sessionList;

    public Comission() {
    }

    public Comission(Integer id) {
        this.id = id;
    }

    public Comission(Integer id, Date startDate, Date endDate, int idState) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idState = idState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentFormal() {
        return documentFormal;
    }

    public void setDocumentFormal(String documentFormal) {
        this.documentFormal = documentFormal;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public TypeComission getIdTypeComission() {
        return idTypeComission;
    }

    public void setIdTypeComission(TypeComission idTypeComission) {
        this.idTypeComission = idTypeComission;
    }

    @XmlTransient
    public List<Member1> getMember1List() {
        return member1List;
    }

    public void setMember1List(List<Member1> member1List) {
        this.member1List = member1List;
    }

    @XmlTransient
    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
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
        if (!(object instanceof Comission)) {
            return false;
        }
        Comission other = (Comission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.Comission[ id=" + id + " ]";
    }
    
}
