package sk.akademiasovy.tipos.server.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {
    @JsonProperty("login")
    public String login;

    @JsonProperty("password")
    public String password;


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
