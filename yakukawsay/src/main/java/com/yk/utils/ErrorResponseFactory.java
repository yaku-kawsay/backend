/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.utils;

import javax.ws.rs.core.Response;

/**
 *
 * @author jhonnyC
 */
public class ErrorResponseFactory {

    public static void throwBadRequest(String errorCode, Exception e) {
        throwBadRequest(errorCode);;
    }
    
    public static void throwBadRequest(String errorCode) {
        Response response = CustomResponseFactory.createResponse(errorCode,
            Response.Status.BAD_REQUEST,
            "http://yakukawsay.com");
        throw new YakuKawsayException(response);
    }

}
