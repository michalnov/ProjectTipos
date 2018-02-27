package sk.akademiasovy.tipos.server.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewUser {
    @JsonProperty("login")
    public String login;

    @JsonProperty("password")
    public String password;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("email")
    public String email;

    public String getlogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
