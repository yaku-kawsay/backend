/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.dataDevice.boundary;

import com.yk.entity.Data;
import com.yk.entity.Device;
import com.yk.entity.utils.CrudService;
import com.yk.utils.ErrorResponseFactory;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.json.JsonObject;

/**
 *
 * @author jhonnyC
 */
@Stateless
public class DeviceService {
    
    @Inject
    CrudService crud;

    @Inject
    Logger log;

            
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Device getDevice(Long id) {
        Device device = crud.find(Device.class, id);
        if (device == null)
            ErrorResponseFactory.throwBadRequest("EV0002");

        return device;
    }

    List<Device> getAll() {
        return crud.findAll(Device.class);
    }

    Device create(JsonObject data) {
        Device device = new Device();
        device.setDate(new Date());
        device.setLatitude(data.getString("latitude"));
        device.setLongitude(data.getString("longitude"));
        device.setModel(data.getString("model"));
        
        try {
            device = crud.createFlush(device);
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Something go wrong with the db", ex);
            ErrorResponseFactory.throwBadRequest("DB0001");
        }
        
        return device;
    }
    
    Data registerData(Long id, JsonObject data) {
        Device device = getDevice(id);
        Data dataEntity = new Data();
        dataEntity.setDate((new Date()).toString()); // TODO: use the correct type
        dataEntity.setValue(Long.parseLong(data.getString("value")));

        try {
            dataEntity = crud.createFlush(dataEntity);
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Something go wrong with the db", ex);
            ErrorResponseFactory.throwBadRequest("DB0001");
        }
        
        return dataEntity;
    }
    
    
}
