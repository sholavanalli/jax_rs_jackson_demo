package com.srh.server;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.ws.rs.ext.Provider;

@Provider
@JsonIgnoreProperties(ignoreUnknown=true)
public class QueryException extends Exception {

    public QueryException() {
        this("No message");
    }

    public QueryException(String msg) {
        super(msg);
    }

}