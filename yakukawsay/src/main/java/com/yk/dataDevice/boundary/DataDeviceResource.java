/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.dataDevice.boundary;

import com.yk.entity.Data;
import com.yk.entity.Device;
import com.yk.pushNotification.boundary.PushNotificationAdapter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.AccessTimeout;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author jhamil
 */
@Path("devices")
@Api(value = "API for device operations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AccessTimeout(value = 10, unit = TimeUnit.MINUTES)
@Singleton
public class DataDeviceResource {
    
    @Inject
    DeviceService service;
    
    @Inject
    DeviceControl control;
    
    @Inject
    PushNotificationAdapter pushNotification;

    
    @GET
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "Get all ", response = JsonObject.class)
    public List<Device> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "get device", response = JsonObject.class)
    public Device getDevice(@PathParam("id") Integer id) {
        return service.getDevice(id);
    }
    
    // @RolesAllowed({"USER"})
    @POST
    @Path("/{id}/datas")
    @ApiOperation(value = "Send data ", response = JsonObject.class)
    public JsonObject dataDevice(@PathParam("id") Integer id, JsonObject data) {
        control.validateDeviceData(data);
        
        Data dataEntity = service.registerData(id, data);
        
        JsonObject response = Json.createObjectBuilder()
                .add("message", "success")
                .add("id", dataEntity.getId())
                .build();
        

        pushNotification.sendPost("Sensor" + dataEntity.getDeviceId().getId() + ": " + dataEntity.getValue(), null, "Yakukawsay", true, null);
        return response;
    }
    
    @GET
    @Path("/{id}/datas")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "Get All Datas", response = JsonObject.class)
    public List<Data> getAllDatas(@PathParam("id") Integer id) {
        return service.getAllDatas(id);
    }
    
    @GET
    @Path("/{id}/calculation")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "Calculate", response = JsonObject.class)
    public Double getCalculation(@PathParam("id") Integer id, 
            @QueryParam("iniDate") String iniDate, 
            @QueryParam("endDate") String endDate, 
            @QueryParam("scope") String scope) {
        control.validateCalculationData(iniDate, endDate, scope);
        // return service.calculate(iniDate, endDate);
        return 0.0;
    }

}
