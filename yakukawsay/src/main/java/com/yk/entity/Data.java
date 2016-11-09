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
    @NamedQuery(name = "Data.findById", query = "SELECT d FROM Data d WHERE d.dataPK.id = :id"),
    @NamedQuery(name = "Data.findByDate", query = "SELECT d FROM Data d WHERE d.date = :date"),
    @NamedQuery(name = "Data.findByValue", query = "SELECT d FROM Data d WHERE d.value = :value"),
    @NamedQuery(name = "Data.findByDeviceid", query = "SELECT d FROM Data d WHERE d.dataPK.deviceid = :deviceid"),
    @NamedQuery(name = "Data.findByDevicetypeindicatorid", query = "SELECT d FROM Data d WHERE d.dataPK.devicetypeindicatorid = :devicetypeindicatorid")})
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DataPK dataPK;
    @Size(max = 45)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private long value;

    public Data() {
    }

    public Data(DataPK dataPK) {
        this.dataPK = dataPK;
    }

    public Data(DataPK dataPK, long value) {
        this.dataPK = dataPK;
        this.value = value;
    }

    public Data(int id, int deviceid, int devicetypeindicatorid) {
        this.dataPK = new DataPK(id, deviceid, devicetypeindicatorid);
    }

    public DataPK getDataPK() {
        return dataPK;
    }

    public void setDataPK(DataPK dataPK) {
        this.dataPK = dataPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataPK != null ? dataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Data)) {
            return false;
        }
        Data other = (Data) object;
        if ((this.dataPK == null && other.dataPK != null) || (this.dataPK != null && !this.dataPK.equals(other.dataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.Data[ dataPK=" + dataPK + " ]";
    }
    
}
