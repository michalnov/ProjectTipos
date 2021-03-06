package sk.akademiasovy.tipos.server.resources;

import java.util.Random;

public class User {
    private String firstname;
    private String lastname;
    private String login;
    private String email;
    private String token;
    private String pasword;

    public User(String firstname, String lastname, String login, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.email = email;
        this.pasword = password;
        generetaToken();
    }


    private void generetaToken() {
        Random random=new Random();
        int lenght = random.nextInt(7)+11;
        System.out.println(lenght);
        String preparingToken = "T";
        int typeofchar = 0;
        for(int i=0;i<lenght;i++){
            for (int j = 0; j < 3; j++) {
                typeofchar = random.nextInt(3);
                if (typeofchar == 1)
                {
                    preparingToken = preparingToken + (char) (random.nextInt(10)+48);
                }
                else if (typeofchar == 0)
                {
                    preparingToken = preparingToken + (char) (random.nextInt(26)+65);
                }
                else
                {
                    preparingToken = preparingToken + (char) (random.nextInt(26)+97);
                }
            }
        }
        token=preparingToken;
        System.out.println(token);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getPasword() { return pasword; }


}
