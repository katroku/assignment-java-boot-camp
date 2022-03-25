package com.example.RCTS.branch;

public class BranchResponse {
    public BranchResponse(){

    }

    private String data;

    public BranchResponse(String message) {
        this.data = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String message) {
        this.data = message;
    }


}
