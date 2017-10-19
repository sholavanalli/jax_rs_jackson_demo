package com.srh.server;

import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class QueryExceptionMapper implements ExceptionMapper<QueryException> {

    @Override
    public Response toResponse(QueryException exception) {
        System.out.println(String.format("Inside %s.toResponse", QueryExceptionMapper.class.getSimpleName()));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            byte[] exceptionJson = objectMapper.writeValueAsBytes(exception);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(exceptionJson)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}