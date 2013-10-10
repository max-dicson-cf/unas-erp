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
@Table(name = "jury", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jury.findAll", query = "SELECT j FROM Jury j")})
public class Jury implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "code_teacher")
    private String codeTeacher;
    @Size(max = 2147483647)
    @Column(name = "position")
    private String position;
    @Size(max = 2147483647)
    @Column(name = "document_formal")
    private String documentFormal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_assignment")
    @Temporal(TemporalType.DATE)
    private Date dateAssignment;
    @JoinColumn(name = "id_type_comission", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeComission idTypeComission;
    @JoinColumn(name = "id_practice", referencedColumnName = "id")
    @ManyToOne
    private Practice idPractice;

    public Jury() {
    }

    public Jury(Integer id) {
        this.id = id;
    }

    public Jury(Integer id, Date dateAssignment) {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDocumentFormal() {
        return documentFormal;
    }

    public void setDocumentFormal(String documentFormal) {
        this.documentFormal = documentFormal;
    }

    public Date getDateAssignment() {
        return dateAssignment;
    }

    public void setDateAssignment(Date dateAssignment) {
        this.dateAssignment = dateAssignment;
    }

    public TypeComission getIdTypeComission() {
        return idTypeComission;
    }

    public void setIdTypeComission(TypeComission idTypeComission) {
        this.idTypeComission = idTypeComission;
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
        if (!(object instanceof Jury)) {
            return false;
        }
        Jury other = (Jury) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.Jury[ id=" + id + " ]";
    }
    
}
