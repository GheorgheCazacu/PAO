package com.fmi.laborator.auth;

public interface Authenticable {
    String DEFAULT_TOKEN = "my token";
    String getHashPassword();
    String getUserName();
    String getToken();
}
