/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhamil
 */
@Entity
@Table(name = "report_has_metrica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportHasMetrica.findAll", query = "SELECT r FROM ReportHasMetrica r"),
    @NamedQuery(name = "ReportHasMetrica.findByReportId", query = "SELECT r FROM ReportHasMetrica r WHERE r.reportHasMetricaPK.reportId = :reportId"),
    @NamedQuery(name = "ReportHasMetrica.findByMetricaId", query = "SELECT r FROM ReportHasMetrica r WHERE r.reportHasMetricaPK.metricaId = :metricaId"),
    @NamedQuery(name = "ReportHasMetrica.findByMetricaDeviceid", query = "SELECT r FROM ReportHasMetrica r WHERE r.reportHasMetricaPK.metricaDeviceid = :metricaDeviceid"),
    @NamedQuery(name = "ReportHasMetrica.findByMetricaDevicetypeindicatorid", query = "SELECT r FROM ReportHasMetrica r WHERE r.reportHasMetricaPK.metricaDevicetypeindicatorid = :metricaDevicetypeindicatorid")})
public class ReportHasMetrica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReportHasMetricaPK reportHasMetricaPK;

    public ReportHasMetrica() {
    }

    public ReportHasMetrica(ReportHasMetricaPK reportHasMetricaPK) {
        this.reportHasMetricaPK = reportHasMetricaPK;
    }

    public ReportHasMetrica(int reportId, int metricaId, int metricaDeviceid, int metricaDevicetypeindicatorid) {
        this.reportHasMetricaPK = new ReportHasMetricaPK(reportId, metricaId, metricaDeviceid, metricaDevicetypeindicatorid);
    }

    public ReportHasMetricaPK getReportHasMetricaPK() {
        return reportHasMetricaPK;
    }

    public void setReportHasMetricaPK(ReportHasMetricaPK reportHasMetricaPK) {
        this.reportHasMetricaPK = reportHasMetricaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportHasMetricaPK != null ? reportHasMetricaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportHasMetrica)) {
            return false;
        }
        ReportHasMetrica other = (ReportHasMetrica) object;
        if ((this.reportHasMetricaPK == null && other.reportHasMetricaPK != null) || (this.reportHasMetricaPK != null && !this.reportHasMetricaPK.equals(other.reportHasMetricaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.ReportHasMetrica[ reportHasMetricaPK=" + reportHasMetricaPK + " ]";
    }
    
}
