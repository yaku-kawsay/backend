/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.utils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author jhonnyC
 */
class YakuKawsayException extends WebApplicationException {

    public YakuKawsayException(Response response) {
        super(response);
    }
    
}
