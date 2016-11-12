/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.pushNotification.boundary;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

/**
 *
 * @author jhamil
 */
public class PushNotificationAdapter {
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiIzYzk0MzFhOS03ZjY1LTQyZjYtOGM4Ni1lNjljNWIxOTMzNjEifQ.0yKOnqAIS9dSU3xdw_jautZaA0aKCv-REvpzEz1KH_E";
    private static final String PROFILE_NAME = "yakukawsay";
    private static final String URL = "https://api.ionic.io/push/notifications";
  
    @Inject
    Logger logger;
    
    /**
     * Send Post message to https://api.ionic.io/push/notifications service
     *
     * @param message
     * @param tokens
     * @param title
     * @return Response values
     */
    public Response sendPost(final String message, final JsonArrayBuilder tokens,
            final String title, final JsonObjectBuilder payload) {
        return sendPost(message, tokens, title, false, payload);
    }


    private String getPushIdFromResponse(final Response response){
        String id = null;
        if(response.getStatus() == 201){
            JsonObject uuid = response.readEntity(JsonObject.class);
            id = uuid.getJsonObject("data").getString("uuid");
        }
        return id;
    }

    /**
     * Send Post message to https://api.ionic.io/push/notifications service
     *
     * @param message
     * @param tokens
     * @param title
     * @param broadcast
     * @param payload
     * @return Response values
     */
    public Response sendPost(final String message, final JsonArrayBuilder tokens,
                             final String title, final boolean broadcast,
                             final JsonObjectBuilder payload) {
        Response response = null;
        Client client = new ResteasyClientBuilder().
                establishConnectionTimeout(100, TimeUnit.SECONDS).
                socketTimeout(100, TimeUnit.SECONDS).
                build();
        WebTarget target = client.target(URL);
        try {
            response = target.request()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + API_KEY)
                    .post(Entity.json(getContentData(message, tokens, title, broadcast, payload)));
        }
        catch(Exception e){
            logger.log(Level.SEVERE, "Some throuble with IONIC service", e);
        }

        return response;
    }

    public Response getNotification(final String notificationId) {
        Response response = null;
        Client client = new ResteasyClientBuilder().
                establishConnectionTimeout(100, TimeUnit.SECONDS).
                socketTimeout(100, TimeUnit.SECONDS).
                build();
        WebTarget target = client.target("https://api.ionic.io/push/notifications/"+notificationId+"/messages");
        System.out.println("https://api.ionic.io/push/notifications/"+notificationId+"/messages");
        try {
            response = target.request()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + API_KEY)
                    .get();
        }
        catch(Exception e){
            logger.log(Level.SEVERE, "Some throuble with IONIC service", e);
        }
        return response;
    }

    /**
     * Return created data with token, profile, and message of the type JsonObject

     * @param message
     * @param tokens
     * @param title
     * @param broadcast
     * @return
     */
    private JsonObject getContentData(final String message, final JsonArrayBuilder tokens,
                                      final String title, final boolean broadcast, 
                                      final JsonObjectBuilder payload) {
        JsonObjectBuilder notification = Json.createObjectBuilder();
        notification.add("message", message);
        notification.add("title", title);
        
        if(payload != null) {
            notification.add("payload", payload);
        }

        final int generatedID = (new Long (System.currentTimeMillis())).intValue();

        notification.add("android",
                Json.createObjectBuilder().add("data",
                        Json.createObjectBuilder().add("notId", generatedID)));

        JsonObjectBuilder content = Json.createObjectBuilder();
        content.add("profile", PROFILE_NAME);

        if(broadcast) {
            content.add("send_to_all", "true");
        }

        if(tokens != null)
            content.add("tokens", tokens.build());
        content.add("notification", notification.build());
        JsonObject c = content.build();
        System.out.println("Content to send to ionic");
        System.out.println(c.toString());
        return c;
    }

    public void unregister(final String tokenId){
        Response response;
        Client client = new ResteasyClientBuilder().
                establishConnectionTimeout(100, TimeUnit.SECONDS).
                socketTimeout(100, TimeUnit.SECONDS).
                build();
        WebTarget target = client.target("https://api.ionic.io/push/tokens/" + tokenId);
        try {
            response = target.request()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + API_KEY)
                    .delete();
            logger.log(Level.INFO, "Response from IONIC {0}",
                    new Object[]{response.readEntity(JsonObject.class)});
        }
        catch(Exception e){
            logger.log(Level.SEVERE, "Some troubles with IONIC service deleting push token {0}",
                    new Object[]{tokenId});
        }
    }
}
