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
public class ReportPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "general_report_id")
    private int generalReportId;

    public ReportPK() {
    }

    public ReportPK(int id, int generalReportId) {
        this.id = id;
        this.generalReportId = generalReportId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneralReportId() {
        return generalReportId;
    }

    public void setGeneralReportId(int generalReportId) {
        this.generalReportId = generalReportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) generalReportId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportPK)) {
            return false;
        }
        ReportPK other = (ReportPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.generalReportId != other.generalReportId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.ReportPK[ id=" + id + ", generalReportId=" + generalReportId + " ]";
    }
    
}
