/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author jhamil
 */
@Entity
@Table(name = "general_report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralReport.findAll", query = "SELECT g FROM GeneralReport g"),
    @NamedQuery(name = "GeneralReport.findById", query = "SELECT g FROM GeneralReport g WHERE g.generalReportPK.id = :id"),
    @NamedQuery(name = "GeneralReport.findByIndicator", query = "SELECT g FROM GeneralReport g WHERE g.indicator = :indicator"),
    @NamedQuery(name = "GeneralReport.findByData", query = "SELECT g FROM GeneralReport g WHERE g.data = :data"),
    @NamedQuery(name = "GeneralReport.findByDate", query = "SELECT g FROM GeneralReport g WHERE g.date = :date"),
    @NamedQuery(name = "GeneralReport.findByPeriodId", query = "SELECT g FROM GeneralReport g WHERE g.generalReportPK.periodId = :periodId")})
public class GeneralReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GeneralReportPK generalReportPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "indicator")
    private String indicator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    private long data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public GeneralReport() {
    }

    public GeneralReport(GeneralReportPK generalReportPK) {
        this.generalReportPK = generalReportPK;
    }

    public GeneralReport(GeneralReportPK generalReportPK, String indicator, long data, Date date) {
        this.generalReportPK = generalReportPK;
        this.indicator = indicator;
        this.data = data;
        this.date = date;
    }

    public GeneralReport(int id, int periodId) {
        this.generalReportPK = new GeneralReportPK(id, periodId);
    }

    public GeneralReportPK getGeneralReportPK() {
        return generalReportPK;
    }

    public void setGeneralReportPK(GeneralReportPK generalReportPK) {
        this.generalReportPK = generalReportPK;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalReportPK != null ? generalReportPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralReport)) {
            return false;
        }
        GeneralReport other = (GeneralReport) object;
        if ((this.generalReportPK == null && other.generalReportPK != null) || (this.generalReportPK != null && !this.generalReportPK.equals(other.generalReportPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.GeneralReport[ generalReportPK=" + generalReportPK + " ]";
    }
    
}
