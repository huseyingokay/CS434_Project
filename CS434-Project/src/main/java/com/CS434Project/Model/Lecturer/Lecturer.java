package com.CS434Project.Model.Lecturer;

import com.CS434Project.Model.User;

import javax.persistence.*;

@Entity
@Table(name = "T_LECTURER")
public class Lecturer implements User {
    private static Lecturer INSTANCE = null;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="USERNAME", length = 100, unique=true)
    private String username;

    @Column(name="PASSWORD", length = 100)
    private String password;

    public static Lecturer getInstance() {
        if (INSTANCE == null){
            synchronized (Lecturer.class){
                if (INSTANCE == null){
                    INSTANCE = new Lecturer();
                }
            }
        }
        return INSTANCE;
    }

    //region Getter&Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion

    public void createExam(){

    }
}
