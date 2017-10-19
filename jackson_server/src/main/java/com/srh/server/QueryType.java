package com.srh.server;

public enum QueryType {

    INTEGRATION("Integration"),
    OBJECT_TYPE("Regular object");

    private String dispName;

    QueryType(String dispName) {
        this.dispName = dispName;
    }

    public String getDispName() {
        return dispName;
    }
}
