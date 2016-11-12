/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.utils;

import com.yk.entity.ErrorMessage;
import javax.ws.rs.core.Response;

/**
 *
 * @author jhonnyC
 */
public class CustomResponseFactory {
    
    public static Response createResponse(String code, Response.Status status, String documentation) {
        return createResponse(code, status, null, null, documentation);
    }

    public static Response createResponse(String code, Response.Status status, String language, String documentation) {
        return createResponse(code, status, language, null, documentation);
    }

    public static Response createResponse(String code, Response.Status status, String language, String country, String documentation) {
        if (code == null || status == null) {
            throw new IllegalStateException("Params (message, status) can not be null");
        }
        ErrorMessage errorMessage
                = new ErrorMessage(code, language, country, documentation);
        return Response.status(status)
                .entity(errorMessage)
                .build();
    }

}
