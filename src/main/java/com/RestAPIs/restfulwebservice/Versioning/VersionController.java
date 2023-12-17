package com.RestAPIs.restfulwebservice.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
//    URI Versioning
    @GetMapping("/v1/person")
    public personV1 personV1() {
        return new personV1("Bob Charlie"); //send Object Class as POJO (Plain Old Java Object) to be JSON
    }

    @GetMapping("/v2/person")
    public personV2 personV2() {
        return new personV2("Bob", "Charlie");
    }
    //URI is used to specify the version
    @GetMapping(value="/person/param", params="version=1")   //http://localhost:8080/person/param?version=1
    public personV1 paramV1() {
        return new personV1("Bob Charlie");
    }

    @GetMapping(value="/person/param", params="version=2")   //http://localhost:8080/person/param?version=2
    public personV2 paramV2() {
        return new personV2("Bob", "Charlie");
    }
    //Header is used to specify the version
    @GetMapping(value="/person/header", headers="X-API-VERSION=1")   //http://localhost:8080/person/header
    public personV1 headerV1() {
        return new personV1("Bob Charlie");
    }

    @GetMapping(value="/person/header", headers="X-API-VERSION=2")   //http://localhost:8080/person/header
    public personV2 headerV2() {
        return new personV2("Bob", "Charlie");
    }
    //Accept header is used to specify the version
    @GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")   //http://localhost:8080/person/produces
    public personV1 producesV1() {
        return new personV1("Bob Charlie");
    }

    @GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")   //http://localhost:8080/person/produces
    public personV2 producesV2() {
        return new personV2("Bob", "Charlie");
    }

}
