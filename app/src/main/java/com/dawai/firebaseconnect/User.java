package com.dawai.firebaseconnect;

public class User {

    public String userid;
    public String uname;
    public String pass;

    public User()
    {

    }

    public User(String userid, String uname, String pass)
    {
        this.userid = userid;
        this.uname = uname;
        this.pass = pass;
    }

    public String getUserid() {
        return userid;
    }

    public String getUname() {
        return uname;
    }

    public String getPass() {
        return pass;
    }
}
