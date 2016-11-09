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
@Table(name = "metric")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metric.findAll", query = "SELECT m FROM Metric m"),
    @NamedQuery(name = "Metric.findById", query = "SELECT m FROM Metric m WHERE m.metricPK.id = :id"),
    @NamedQuery(name = "Metric.findByIndicator", query = "SELECT m FROM Metric m WHERE m.indicator = :indicator"),
    @NamedQuery(name = "Metric.findByData", query = "SELECT m FROM Metric m WHERE m.data = :data"),
    @NamedQuery(name = "Metric.findByDate", query = "SELECT m FROM Metric m WHERE m.date = :date"),
    @NamedQuery(name = "Metric.findByUnity", query = "SELECT m FROM Metric m WHERE m.unity = :unity"),
    @NamedQuery(name = "Metric.findByMetric", query = "SELECT m FROM Metric m WHERE m.metric = :metric"),
    @NamedQuery(name = "Metric.findByDeviceid", query = "SELECT m FROM Metric m WHERE m.metricPK.deviceid = :deviceid"),
    @NamedQuery(name = "Metric.findByDevicetypeindicatorid", query = "SELECT m FROM Metric m WHERE m.metricPK.devicetypeindicatorid = :devicetypeindicatorid")})
public class Metric implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MetricPK metricPK;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "unity")
    private String unity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "metric")
    private String metric;

    public Metric() {
    }

    public Metric(MetricPK metricPK) {
        this.metricPK = metricPK;
    }

    public Metric(MetricPK metricPK, String indicator, long data, Date date, String unity, String metric) {
        this.metricPK = metricPK;
        this.indicator = indicator;
        this.data = data;
        this.date = date;
        this.unity = unity;
        this.metric = metric;
    }

    public Metric(int id, int deviceid, int devicetypeindicatorid) {
        this.metricPK = new MetricPK(id, deviceid, devicetypeindicatorid);
    }

    public MetricPK getMetricPK() {
        return metricPK;
    }

    public void setMetricPK(MetricPK metricPK) {
        this.metricPK = metricPK;
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

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metricPK != null ? metricPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metric)) {
            return false;
        }
        Metric other = (Metric) object;
        if ((this.metricPK == null && other.metricPK != null) || (this.metricPK != null && !this.metricPK.equals(other.metricPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.Metric[ metricPK=" + metricPK + " ]";
    }
    
}
