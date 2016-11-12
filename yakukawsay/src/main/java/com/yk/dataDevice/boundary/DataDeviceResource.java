/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.dataDevice.boundary;

import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.security.RolesAllowed;
import javax.ejb.AccessTimeout;
import javax.ejb.Singleton;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.ws.rs.Consumes;
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
    //@RolesAllowed({"USER"})
    @POST
    @Path("dataDevice")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "Send data ", response = JsonObject.class)
    public JsonObject dataDevice(@PathParam("deviceId") Long id, @Context HttpServletRequest obj) {
        return null;
    }   
}
