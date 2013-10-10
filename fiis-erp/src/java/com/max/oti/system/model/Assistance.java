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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author max
 */
@Entity
@Table(name = "assistance", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assistance.findAll", query = "SELECT a FROM Assistance a")})
public class Assistance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "input_time")
    @Temporal(TemporalType.TIME)
    private Date inputTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "output_time")
    @Temporal(TemporalType.TIME)
    private Date outputTime;
    @JoinColumn(name = "id_session", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Session idSession;
    @JoinColumn(name = "id_member", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Member1 idMember;

    public Assistance() {
    }

    public Assistance(Integer id) {
        this.id = id;
    }

    public Assistance(Integer id, Date inputTime, Date outputTime) {
        this.id = id;
        this.inputTime = inputTime;
        this.outputTime = outputTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Date getOutputTime() {
        return outputTime;
    }

    public void setOutputTime(Date outputTime) {
        this.outputTime = outputTime;
    }

    public Session getIdSession() {
        return idSession;
    }

    public void setIdSession(Session idSession) {
        this.idSession = idSession;
    }

    public Member1 getIdMember() {
        return idMember;
    }

    public void setIdMember(Member1 idMember) {
        this.idMember = idMember;
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
        if (!(object instanceof Assistance)) {
            return false;
        }
        Assistance other = (Assistance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.Assistance[ id=" + id + " ]";
    }
    
}
