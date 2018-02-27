package sk.akademiasovy.tipos.server;

import java.util.Random;

public class User {
    private String firstname;
    private String lastname;
    private String login;
    private String email;
    private String token;

    public User(String firstname, String lastname, String login, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.email = email;
        generetaToken();
    }


    private void generetaToken() {
        Random random=new Random();
        int lenght = random.nextInt(7)+11;
        char[] text=new char[54];
        int typeofchar = 0;
        for(int i=0;i<lenght;i++){
            for (int j = 0; j < 3; j++) {
                typeofchar = random.nextInt(3);
                if (typeofchar == 1)
                {
                    text[i]=(char) (random.nextInt(10)+30);
                }
                else if (typeofchar == 0)
                {
                    text[i]=(char) (random.nextInt(26)+65);
                }
                else
                {
                    text[i]=(char) (random.nextInt(26)+97);
                }
            }
        }
        token=String.valueOf(text);
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
}
