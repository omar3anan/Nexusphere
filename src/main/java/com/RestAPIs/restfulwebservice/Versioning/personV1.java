package com.RestAPIs.restfulwebservice.Versioning;

public class personV1 {
    private String name;

    public personV1(String name) {
        super();
        this.name = name;
    }

    public personV1() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
