package com.srh.server.remote;

import com.srh.server.QueryException;
import com.srh.server.QueryResult;

public interface QueryRemote {

    // v1.0
    QueryResult runQuery(String expression, int limit, int offset) throws QueryException;

    // v2.0
//    QueryResult runQuery(String expression, int offset, String aggType) throws QueryException;
}
