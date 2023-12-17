package com.RestAPIs.restfulwebservice.Server.Security;

public enum thePermissions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    thePermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
