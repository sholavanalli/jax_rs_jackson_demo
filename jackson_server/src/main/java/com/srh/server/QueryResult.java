package com.srh.server;

import java.util.List;
import java.util.Objects;

public class QueryResult {

    private long totalHits;
    private int limit;
    private int offset;
    private QueryType queryType;
    private List<QueryOutputRecord> records;

    // Default constructor a must have for Jackson.
    public QueryResult() {
    }

    public QueryResult(long totalHits, int limit, int offset, QueryType queryType, List<QueryOutputRecord> records) {
        this.totalHits = totalHits;
        this.limit = limit;
        this.offset = offset;
        this.queryType = queryType;
        this.records = records;
    }

    public long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(long totalHits) {
        this.totalHits = totalHits;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public void setQueryType(QueryType queryType) {
        this.queryType = queryType;
    }

    public List<QueryOutputRecord> getRecords() {
        return records;
    }

    public void setRecords(List<QueryOutputRecord> records) {
        this.records = records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryResult that = (QueryResult) o;
        return totalHits == that.totalHits &&
                limit == that.limit &&
                offset == that.offset &&
                queryType == that.queryType &&
                Objects.equals(records, that.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalHits, limit, offset, queryType, records);
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "totalHits=" + totalHits +
                ", limit=" + limit +
                ", offset=" + offset +
                ", queryType=" + queryType +
                ", records=" + records +
                '}';
    }
}
