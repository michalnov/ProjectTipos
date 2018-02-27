package sk.akademiasovy.tipos.server;

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
