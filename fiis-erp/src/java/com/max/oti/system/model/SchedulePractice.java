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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author max
 */
@Entity
@Table(name = "schedule_practice", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchedulePractice.findAll", query = "SELECT s FROM SchedulePractice s")})
public class SchedulePractice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Size(max = 2147483647)
    @Column(name = "document_formal")
    private String documentFormal;
    @Size(max = 2147483647)
    @Column(name = "place")
    private String place;
    @JoinColumn(name = "id_practice", referencedColumnName = "id")
    @ManyToOne
    private Practice idPractice;
    @JoinColumn(name = "id_activity", referencedColumnName = "id")
    @ManyToOne
    private Activity idActivity;

    public SchedulePractice() {
    }

    public SchedulePractice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDocumentFormal() {
        return documentFormal;
    }

    public void setDocumentFormal(String documentFormal) {
        this.documentFormal = documentFormal;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Practice getIdPractice() {
        return idPractice;
    }

    public void setIdPractice(Practice idPractice) {
        this.idPractice = idPractice;
    }

    public Activity getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(Activity idActivity) {
        this.idActivity = idActivity;
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
        if (!(object instanceof SchedulePractice)) {
            return false;
        }
        SchedulePractice other = (SchedulePractice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.SchedulePractice[ id=" + id + " ]";
    }
    
}
