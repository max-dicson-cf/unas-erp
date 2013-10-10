/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author max
 */
@Entity
@Table(name = "adviser_practice", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdviserPractice.findAll", query = "SELECT a FROM AdviserPractice a")})
public class AdviserPractice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 12)
    @Column(name = "code_teacher")
    private String codeTeacher;
    @Size(max = 2147483647)
    @Column(name = "document_formal")
    private String documentFormal;
    @Size(max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_assignment")
    @Temporal(TemporalType.DATE)
    private Date dateAssignment;
    @JoinColumn(name = "id_practice", referencedColumnName = "id")
    @ManyToOne
    private Practice idPractice;

    public AdviserPractice() {
    }

    public AdviserPractice(Integer id) {
        this.id = id;
    }

    public AdviserPractice(Integer id, Date dateAssignment) {
        this.id = id;
        this.dateAssignment = dateAssignment;
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

    public String getDocumentFormal() {
        return documentFormal;
    }

    public void setDocumentFormal(String documentFormal) {
        this.documentFormal = documentFormal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateAssignment() {
        return dateAssignment;
    }

    public void setDateAssignment(Date dateAssignment) {
        this.dateAssignment = dateAssignment;
    }

    public Practice getIdPractice() {
        return idPractice;
    }

    public void setIdPractice(Practice idPractice) {
        this.idPractice = idPractice;
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
        if (!(object instanceof AdviserPractice)) {
            return false;
        }
        AdviserPractice other = (AdviserPractice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.AdviserPractice[ id=" + id + " ]";
    }
    
}
