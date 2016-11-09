/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jhamil
 */
@Embeddable
public class ReportHasMetricaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "report_id")
    private int reportId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "metrica_id")
    private int metricaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "metrica_Device_id")
    private int metricaDeviceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "metrica_Device_type_indicator_id")
    private int metricaDevicetypeindicatorid;

    public ReportHasMetricaPK() {
    }

    public ReportHasMetricaPK(int reportId, int metricaId, int metricaDeviceid, int metricaDevicetypeindicatorid) {
        this.reportId = reportId;
        this.metricaId = metricaId;
        this.metricaDeviceid = metricaDeviceid;
        this.metricaDevicetypeindicatorid = metricaDevicetypeindicatorid;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getMetricaId() {
        return metricaId;
    }

    public void setMetricaId(int metricaId) {
        this.metricaId = metricaId;
    }

    public int getMetricaDeviceid() {
        return metricaDeviceid;
    }

    public void setMetricaDeviceid(int metricaDeviceid) {
        this.metricaDeviceid = metricaDeviceid;
    }

    public int getMetricaDevicetypeindicatorid() {
        return metricaDevicetypeindicatorid;
    }

    public void setMetricaDevicetypeindicatorid(int metricaDevicetypeindicatorid) {
        this.metricaDevicetypeindicatorid = metricaDevicetypeindicatorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reportId;
        hash += (int) metricaId;
        hash += (int) metricaDeviceid;
        hash += (int) metricaDevicetypeindicatorid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportHasMetricaPK)) {
            return false;
        }
        ReportHasMetricaPK other = (ReportHasMetricaPK) object;
        if (this.reportId != other.reportId) {
            return false;
        }
        if (this.metricaId != other.metricaId) {
            return false;
        }
        if (this.metricaDeviceid != other.metricaDeviceid) {
            return false;
        }
        if (this.metricaDevicetypeindicatorid != other.metricaDevicetypeindicatorid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.ReportHasMetricaPK[ reportId=" + reportId + ", metricaId=" + metricaId + ", metricaDeviceid=" + metricaDeviceid + ", metricaDevicetypeindicatorid=" + metricaDevicetypeindicatorid + " ]";
    }
    
}
