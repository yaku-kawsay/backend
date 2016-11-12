/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.dataDevice.boundary;

import com.yk.entity.Device;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.AccessTimeout;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jhamil
 */
@Singleton
@AccessTimeout(value = 10, unit = TimeUnit.MINUTES)
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataDeviceResource {
    
    @Inject
    DeviceService service;
    
    @Inject
    DeviceControl control;
    
    // @RolesAllowed({"USER"})
    @POST
    @Path("")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "Send data ", response = JsonObject.class)
    public JsonObject dataDevice(@PathParam("deviceId") Long id, JsonObject data) {
        control.validateDeviceData(data);
        
        Device device = service.create(data);
        
        JsonObject response = Json.createObjectBuilder()
                .add("message", "success")
                .add("id", device.getId())
                .build();
        return response;
    }

    @GET
    @Path("")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "Get all ", response = JsonObject.class)
    public List<Device> getAll(@PathParam("id") Long id) {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "get device", response = JsonObject.class)
    public Device getDevice(@PathParam("id") Long id) {
        return service.getDevice(id);
    }
    
}
