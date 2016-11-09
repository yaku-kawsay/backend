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
@Table(name = "Device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"),
    @NamedQuery(name = "Device.findById", query = "SELECT d FROM Device d WHERE d.devicePK.id = :id"),
    @NamedQuery(name = "Device.findByModel", query = "SELECT d FROM Device d WHERE d.model = :model"),
    @NamedQuery(name = "Device.findByDate", query = "SELECT d FROM Device d WHERE d.date = :date"),
    @NamedQuery(name = "Device.findByLatitude", query = "SELECT d FROM Device d WHERE d.latitude = :latitude"),
    @NamedQuery(name = "Device.findByLongitude", query = "SELECT d FROM Device d WHERE d.longitude = :longitude"),
    @NamedQuery(name = "Device.findByTypeIndicatorId", query = "SELECT d FROM Device d WHERE d.devicePK.typeIndicatorId = :typeIndicatorId")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DevicePK devicePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "latitude")
    private String latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "longitude")
    private String longitude;

    public Device() {
    }

    public Device(DevicePK devicePK) {
        this.devicePK = devicePK;
    }

    public Device(DevicePK devicePK, String model, Date date, String latitude, String longitude) {
        this.devicePK = devicePK;
        this.model = model;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Device(int id, int typeIndicatorId) {
        this.devicePK = new DevicePK(id, typeIndicatorId);
    }

    public DevicePK getDevicePK() {
        return devicePK;
    }

    public void setDevicePK(DevicePK devicePK) {
        this.devicePK = devicePK;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (devicePK != null ? devicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.devicePK == null && other.devicePK != null) || (this.devicePK != null && !this.devicePK.equals(other.devicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.Device[ devicePK=" + devicePK + " ]";
    }
    
}
