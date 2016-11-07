/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.notification.boundary;

import com.yk.entity.dto.notification.NotificationDTO;
import io.swagger.annotations.Api;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jhamil
 */
@Path("users")
@Api(value = "API for user operations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationResource {
    
    @POST
    @Path("{deviceId}/noti")
    public JsonObject renewToken(@PathParam("userId") Long userId, final NotificationDTO param) {
        //log.log(Level.INFO, "Attempt to renew token manually");
        System.out.println("ingresa a esta funcion");
        return null;
    }
}
