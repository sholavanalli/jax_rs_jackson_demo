package com.srh.server;

import com.srh.server.remote.QueryRemote;

import java.util.Arrays;

public class QueryImpl implements QueryRemote {

    private static final int MAX_LIMIT_ALLOWED = 1000;

    @Override
    public QueryResult runQuery(String expression, int limit, String aggType) throws QueryException {
        if (limit > MAX_LIMIT_ALLOWED) {
            throw new QueryException("Limit too high");
        }
        System.out.println(String.format("In %s.runQuery with args expression: %s, limit: %d, aggType: %s",
                QueryImpl.class.getSimpleName(), expression, limit, aggType));
        QueryOutputRecord r1 = new QueryOutputRecord(1L, "app-1");
        QueryOutputRecord r2 = new QueryOutputRecord(2L, "app-2");
        return new QueryResult(Long.MAX_VALUE, limit, QueryType.OBJECT_TYPE, Arrays.asList(r1, r2), aggType);
    }

    /*@Override
    public QueryResult runQuery(String expression, int limit, int offset) throws QueryException {
        if (limit > MAX_LIMIT_ALLOWED) {
            throw new QueryException("Limit too high");
        }
        System.out.println(String.format("In %s.runQuery with args expression: %s, limit: %d, offset: %d",
                QueryImpl.class.getSimpleName(), expression, limit, offset));
        QueryOutputRecord r1 = new QueryOutputRecord(1L, "app-1");
        QueryOutputRecord r2 = new QueryOutputRecord(2L, "app-2");
        return new QueryResult(Long.MAX_VALUE, limit, offset, QueryType.OBJECT_TYPE, Arrays.asList(r1, r2));
    }*/
}
