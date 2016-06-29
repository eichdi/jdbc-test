package ru.test.jdbc.user.model;

/**
 * Created by SOTI on 25.05.2016.
 */
public class User {
    private int id;
    private String name;
    private String info;
    private String email;
    private int bornYear;
    private boolean sex; //0-female 1-male
    public User(String name, String info, String email, int id, int bornYear, boolean sex){
        this.name = name;
        this.info = info;
        this.email = email;
        this.id = id;
        this.bornYear = bornYear;
        this.sex = sex;
    }
    public User(String name, String info, String email, int bornYear, boolean sex){
        this.name = name;
        this.info = info;
        this.email = email;
        this.id = id;
        this.bornYear = bornYear;
        this.sex = sex;
    }


    public  String getName() {
        return this.name;
    }
    public  void setName(String name){
        this.name = name;
    }

    public  String getInfo(){
        return this.info;
    }
    public  void setInfo(String info){
        this.info = info;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getBornYear() {
        return bornYear;
    }
    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.format("name=%sinfo=%semail=%sbornyear=%ssex=%s", name, info, email, bornYear, sex)+"\n";
    }
}