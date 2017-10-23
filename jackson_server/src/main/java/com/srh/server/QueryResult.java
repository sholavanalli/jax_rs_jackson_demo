package com.srh.server;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown=true)
public class QueryResult {

    private long totalHits;
    private int limit;
//    private int offset;
    private QueryType queryType;
    private List<QueryOutputRecord> records;
    private String aggType;

    // Default constructor a must have for Jackson.
    public QueryResult() {
    }

    public QueryResult(long totalHits, int limit, QueryType queryType, List<QueryOutputRecord> records, String aggType) {
        this.totalHits = totalHits;
        this.limit = limit;
        this.queryType = queryType;
        this.records = records;
        this.aggType = aggType;
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

    public String getAggType() {
        return aggType;
    }

    public void setAggType(String aggType) {
        this.aggType = aggType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryResult that = (QueryResult) o;
        return totalHits == that.totalHits &&
                limit == that.limit &&
                queryType == that.queryType &&
                Objects.equals(records, that.records) &&
                Objects.equals(aggType, that.aggType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalHits, limit, queryType, records, aggType);
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "totalHits=" + totalHits +
                ", limit=" + limit +
                ", queryType=" + queryType +
                ", records=" + records +
                ", aggType='" + aggType + '\'' +
                '}';
    }
}
