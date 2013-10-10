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
@Table(name = "supervision_practice", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupervisionPractice.findAll", query = "SELECT s FROM SupervisionPractice s")})
public class SupervisionPractice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 12)
    @Column(name = "code_teacher")
    private String codeTeacher;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 2147483647)
    @Column(name = "document_formal")
    private String documentFormal;
    @Size(max = 2147483647)
    @Column(name = "detail")
    private String detail;
    @JoinColumn(name = "id_practice", referencedColumnName = "id")
    @ManyToOne
    private Practice idPractice;

    public SupervisionPractice() {
    }

    public SupervisionPractice(Integer id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDocumentFormal() {
        return documentFormal;
    }

    public void setDocumentFormal(String documentFormal) {
        this.documentFormal = documentFormal;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        if (!(object instanceof SupervisionPractice)) {
            return false;
        }
        SupervisionPractice other = (SupervisionPractice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.SupervisionPractice[ id=" + id + " ]";
    }
    
}
