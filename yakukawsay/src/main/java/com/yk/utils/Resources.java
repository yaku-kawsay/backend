/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.utils;

import com.yk.entity.utils.CrudService;
import com.yk.entity.utils.CrudServiceBean;
import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jhonnyC
 */
public class Resources {

    @Produces
    @PersistenceContext
    private EntityManager em;
    
    @Produces
    public CrudService produceCrudService() {
        return new CrudServiceBean(this.em);
    }
    
    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
    
}
