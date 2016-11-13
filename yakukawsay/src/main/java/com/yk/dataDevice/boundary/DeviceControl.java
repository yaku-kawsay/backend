/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.dataDevice.boundary;

import com.yk.entity.Data;
import com.yk.entity.TypeIndicator;
import javax.json.JsonObject;

/**
 *
 * @author jhonnyC
 */
public class DeviceControl {
    
    void validateDeviceData(JsonObject json) {
        // TODO: validate data
    }

    void validateCalculationData(String iniDate, String endDate, String scope) {
        // TODO: validate data
    }
    
    boolean ableToTriggerNotification(Long value, String type ){
        if (type.equals(TypeIndicator.HUMIDITY)) {
            if (value > NotificationMockConfiguration.MIN_HUMIDITY
                    && value < NotificationMockConfiguration.MAX_HUMIDITY) {
                return true;
            }
        } else if (type.equals(TypeIndicator.TEMPERATURE)) {
            if (value > NotificationMockConfiguration.MIN_TEMPERATURE
                    && value < NotificationMockConfiguration.MAX_TEMPERATURE) {
                return true;
            }
        }

        return false;
    }

    String buldGoodNotification(Data dataEntity) {
        return "Temperatura optima para que germinen las semillas. " 
                + dataEntity.getDeviceId().getTypeIndicatorId().getType() + " " + dataEntity.getValue() 
                + " " + dataEntity.getDeviceId().getTypeIndicatorId().getUnity();
    }
    
    String buldBadNotification(Data dataEntity) {
        return "Los indices estan por debajo de lo ideal, toma precauciones.  " 
                + dataEntity.getDeviceId().getTypeIndicatorId().getType() + " " + dataEntity.getValue() 
                + " " + dataEntity.getDeviceId().getTypeIndicatorId().getUnity();
    }

    boolean ableToTriggerBadNotification(long value, String type) {
        if (type.equals(TypeIndicator.HUMIDITY)) {
            if (value < NotificationMockConfiguration.MIN_HUMIDITY) {
                return true;
            }
        } else if (type.equals(TypeIndicator.TEMPERATURE)) {
            if (value < NotificationMockConfiguration.MIN_TEMPERATURE) {
                return true;
            }
        }

        return false;
    }

    boolean ableToTriggerGoodNotification(long value, String type) {
        if (type.equals(TypeIndicator.HUMIDITY)) {
            if (value > NotificationMockConfiguration.MIN_HUMIDITY
                    && value < NotificationMockConfiguration.MAX_HUMIDITY) {
                return true;
            }
        } else if (type.equals(TypeIndicator.TEMPERATURE)) {
            if (value > NotificationMockConfiguration.MIN_TEMPERATURE
                    && value < NotificationMockConfiguration.MAX_TEMPERATURE) {
                return true;
            }
        }

        return false;
    }
    
}
