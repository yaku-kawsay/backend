/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhamil
 */
@Entity
@Table(name = "data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Data.findAll", query = "SELECT d FROM Data d"),
    @NamedQuery(name = "Data.findByDate", query = "SELECT d FROM Data d WHERE d.date = :date"),
    @NamedQuery(name = "Data.findByValue", query = "SELECT d FROM Data d WHERE d.value = :value"),
    @NamedQuery(name = Data.FIND_BY_DEVICE, query = "SELECT d FROM Data d WHERE d.deviceId = :device")})
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String FIND_BY_DEVICE = "Data.findByDeviceId";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private long value;

    @JoinColumn(name = "device_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Device deviceId;

    public Data() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
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
        if (!(object instanceof TypeIndicator)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.Data[ dataPK=" + id + " ]";
    }
    
}
