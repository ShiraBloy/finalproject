package com.example.ex4.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 *  create a data-base.
 **/
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String email;
    private String name;
    private String identify;
    private String hmo;
    private String pswd;

    /**
     * default constructor.
     */
    public User() {}

    /**
     * constructor to init the paramter
     * @param name of the user
     */
    public User(String email, String name, String id, String hmo, String password) {
        this.email = email;
        this.name = name;
        this.identify = id;
        this.hmo = hmo;
        this.pswd = password;
    }


    public  String getEmail() { return  email;}
    public String getUserName()
    {
        return name;
    }
    public String getIdentify(){return identify;}
    public String getHmo(){return hmo;}
    public String getPswd()
    {
        return pswd;
    }

    public void setEmail(String email) {this.email = email;}
    public void setUserName(String username)
    {
        this.name = username;
    }
    public void setId(String id){this.identify = id;}
    public void setHmo(String hmo){this.hmo=hmo;}
    public void setPswd(String password) {this.pswd = password; }


    @Override
    public  String toString(){ return name + "  " ; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
