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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author max
 */
@Entity
@Table(name = "practice", catalog = "dbfiis", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Practice.findAll", query = "SELECT p FROM Practice p")})
public class Practice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "code_alumn")
    private String codeAlumn;
    @Column(name = "name_area")
    private Integer nameArea;
    @Size(max = 2147483647)
    @Column(name = "inmmediative_boss")
    private String inmmediativeBoss;
    @Size(max = 2147483647)
    @Column(name = "title_project")
    private String titleProject;
    @Size(max = 2147483647)
    @Column(name = "summary_project")
    private String summaryProject;
    @OneToMany(mappedBy = "idPractice")
    private List<Sustentation> sustentationList;
    @OneToMany(mappedBy = "idPractice")
    private List<SchedulePractice> schedulePracticeList;
    @OneToMany(mappedBy = "idPractice")
    private List<Jury> juryList;
    @OneToMany(mappedBy = "idPractice")
    private List<HistoryPractice> historyPracticeList;
    @OneToMany(mappedBy = "idPractice")
    private List<AdviserPractice> adviserPracticeList;
    @OneToMany(mappedBy = "idPractice")
    private List<ReportPractice> reportPracticeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPractice")
    private List<FunctionPractice> functionPracticeList;
    @OneToMany(mappedBy = "idPractice")
    private List<SupervisionPractice> supervisionPracticeList;
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    @ManyToOne
    private Company idCompany;

    public Practice() {
    }

    public Practice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeAlumn() {
        return codeAlumn;
    }

    public void setCodeAlumn(String codeAlumn) {
        this.codeAlumn = codeAlumn;
    }

    public Integer getNameArea() {
        return nameArea;
    }

    public void setNameArea(Integer nameArea) {
        this.nameArea = nameArea;
    }

    public String getInmmediativeBoss() {
        return inmmediativeBoss;
    }

    public void setInmmediativeBoss(String inmmediativeBoss) {
        this.inmmediativeBoss = inmmediativeBoss;
    }

    public String getTitleProject() {
        return titleProject;
    }

    public void setTitleProject(String titleProject) {
        this.titleProject = titleProject;
    }

    public String getSummaryProject() {
        return summaryProject;
    }

    public void setSummaryProject(String summaryProject) {
        this.summaryProject = summaryProject;
    }

    @XmlTransient
    public List<Sustentation> getSustentationList() {
        return sustentationList;
    }

    public void setSustentationList(List<Sustentation> sustentationList) {
        this.sustentationList = sustentationList;
    }

    @XmlTransient
    public List<SchedulePractice> getSchedulePracticeList() {
        return schedulePracticeList;
    }

    public void setSchedulePracticeList(List<SchedulePractice> schedulePracticeList) {
        this.schedulePracticeList = schedulePracticeList;
    }

    @XmlTransient
    public List<Jury> getJuryList() {
        return juryList;
    }

    public void setJuryList(List<Jury> juryList) {
        this.juryList = juryList;
    }

    @XmlTransient
    public List<HistoryPractice> getHistoryPracticeList() {
        return historyPracticeList;
    }

    public void setHistoryPracticeList(List<HistoryPractice> historyPracticeList) {
        this.historyPracticeList = historyPracticeList;
    }

    @XmlTransient
    public List<AdviserPractice> getAdviserPracticeList() {
        return adviserPracticeList;
    }

    public void setAdviserPracticeList(List<AdviserPractice> adviserPracticeList) {
        this.adviserPracticeList = adviserPracticeList;
    }

    @XmlTransient
    public List<ReportPractice> getReportPracticeList() {
        return reportPracticeList;
    }

    public void setReportPracticeList(List<ReportPractice> reportPracticeList) {
        this.reportPracticeList = reportPracticeList;
    }

    @XmlTransient
    public List<FunctionPractice> getFunctionPracticeList() {
        return functionPracticeList;
    }

    public void setFunctionPracticeList(List<FunctionPractice> functionPracticeList) {
        this.functionPracticeList = functionPracticeList;
    }

    @XmlTransient
    public List<SupervisionPractice> getSupervisionPracticeList() {
        return supervisionPracticeList;
    }

    public void setSupervisionPracticeList(List<SupervisionPractice> supervisionPracticeList) {
        this.supervisionPracticeList = supervisionPracticeList;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
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
        if (!(object instanceof Practice)) {
            return false;
        }
        Practice other = (Practice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.max.oti.system.model.Practice[ id=" + id + " ]";
    }
    
}
