package com.example.RCTS.branch;

public class BranchNotFoundException  extends RuntimeException{

    public BranchNotFoundException(String message) {
        super(message);
    }
}
