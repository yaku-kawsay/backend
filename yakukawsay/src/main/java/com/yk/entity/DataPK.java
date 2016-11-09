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
public class DataPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Device_id")
    private int deviceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Device_type_indicator_id")
    private int devicetypeindicatorid;

    public DataPK() {
    }

    public DataPK(int id, int deviceid, int devicetypeindicatorid) {
        this.id = id;
        this.deviceid = deviceid;
        this.devicetypeindicatorid = devicetypeindicatorid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }

    public int getDevicetypeindicatorid() {
        return devicetypeindicatorid;
    }

    public void setDevicetypeindicatorid(int devicetypeindicatorid) {
        this.devicetypeindicatorid = devicetypeindicatorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) deviceid;
        hash += (int) devicetypeindicatorid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataPK)) {
            return false;
        }
        DataPK other = (DataPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.deviceid != other.deviceid) {
            return false;
        }
        if (this.devicetypeindicatorid != other.devicetypeindicatorid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.DataPK[ id=" + id + ", deviceid=" + deviceid + ", devicetypeindicatorid=" + devicetypeindicatorid + " ]";
    }
    
}
