package com.srh.server.controllers;

import com.srh.server.QueryException;
import com.srh.server.QueryImpl;
import com.srh.server.QueryResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/queryImplController")
public class QueryImplController {

    // v1.0
    @GET
    @Path("/runQuery")
    @Produces(MediaType.APPLICATION_JSON)
    public QueryResult runQuery(@QueryParam("expression") String expression, @QueryParam("limit") int limit,
                                @QueryParam("offset") int offset) throws QueryException {
        try {
            System.out.println(String.format("In %s.runQuery with args expression: %s, limit: %d, offset: %d",
                    QueryImplController.class.getSimpleName(), expression, limit, offset));
            return new QueryImpl().runQuery(expression, limit, offset);
        } catch (QueryException e) {
            throw e;
        }
    }

    // v2.0 - added aggType, removed offset
    /*@GET
    @Path("/runQuery")
    @Produces(MediaType.APPLICATION_JSON)
    public QueryResult runQuery(@QueryParam("expression") String expression, @QueryParam("limit") int limit,
                                @QueryParam("offset") int offset, @QueryParam("aggType") String aggType) throws QueryException {
        try {
            System.out.println(String.format("In %s.runQuery with args expression: %s, limit: %d, offset: %d, aggType: %s",
                    QueryImplController.class.getSimpleName(), expression, limit, offset, aggType));
            return new QueryImpl().runQuery(expression, limit, offset, aggType);
        } catch (QueryException e) {
            throw e;
        }
    }*/
}
