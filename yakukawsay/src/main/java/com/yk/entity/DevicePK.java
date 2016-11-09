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
public class DevicePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type_indicator_id")
    private int typeIndicatorId;

    public DevicePK() {
    }

    public DevicePK(int id, int typeIndicatorId) {
        this.id = id;
        this.typeIndicatorId = typeIndicatorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeIndicatorId() {
        return typeIndicatorId;
    }

    public void setTypeIndicatorId(int typeIndicatorId) {
        this.typeIndicatorId = typeIndicatorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) typeIndicatorId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevicePK)) {
            return false;
        }
        DevicePK other = (DevicePK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.typeIndicatorId != other.typeIndicatorId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yk.DevicePK[ id=" + id + ", typeIndicatorId=" + typeIndicatorId + " ]";
    }
    
}
