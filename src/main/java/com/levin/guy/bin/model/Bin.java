package com.levin.guy.bin.model;


import java.util.ArrayList;
import java.util.Collection;


/**
 * Skeleton class for the Bin entity.
 * {
 *     "id": "29211f0f-cff1-4d9e-b80d-5c5acab8e5b9",
 *     "requests": [{
 *          <<Request>>
 *     }],
 * }
 *
 * Add whatever you feel is missing.
 * */
public class Bin {

    private Collection<Request> requests;

    private String id;

    public Bin() {
        this.requests = new ArrayList<>();
    }

    public String getId(){
       return id;
    }

    public Collection<Request> getRequests() {
        return requests;
    }

    public void addRequest(Request request) {
       requests.add(request);
    }
    
    public void setId(String id)
    {
    	this.id = id;
    }

}
