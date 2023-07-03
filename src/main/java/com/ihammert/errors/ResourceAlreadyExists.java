package com.ihammert.errors;

public class ResourceAlreadyExists extends Exception {
    public ResourceAlreadyExists(String resource) {
        super(resource+ " ja existe.");
    }
}