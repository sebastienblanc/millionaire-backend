package com.redhat.developer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.identity.SecurityIdentity;

@Path("/admin-ui")
public class AdminUIResource {
    
    @Inject
    Template admin;

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance render(){
        return admin.data("username", securityIdentity.getPrincipal().getName());
    }
}