package entities;

import java.util.Date;

public class Utilisateur {

    private int id;
    private String email;
    private String password;
    private String codeVerification;
    private Date codeExpiration;

    public Utilisateur() {}

    public Utilisateur(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    // getters & setters
    public String getCodeVerification() {
        return codeVerification;
    }

    public void setCodeVerification(String codeVerification) {
        this.codeVerification = codeVerification;
    }

    public Date getCodeExpiration() {
        return codeExpiration;
    }

    public void setCodeExpiration(Date codeExpiration) {
        this.codeExpiration = codeExpiration;
    }
}
