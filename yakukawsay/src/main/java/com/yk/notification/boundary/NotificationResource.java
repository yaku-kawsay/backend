/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.notification.boundary;

import io.swagger.annotations.Api;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jhonC
 */
@Path("notifications")
@Api(value = "API for notification operations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class NotificationResource {
    
    @GET
    @Path("")
    public JsonObject get(@QueryParam("scope") String params) {
        //log.log(Level.INFO, "Attempt to renew token manually");

        return null;
    }
}
