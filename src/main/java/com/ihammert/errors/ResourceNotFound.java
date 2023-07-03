package com.ihammert.errors;

public class ResourceNotFound extends Exception {
    public ResourceNotFound(String resource) {
        super(resource + " nao existe.");
    }
}