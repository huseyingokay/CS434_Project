package com.CS434Project.Model.Student;
import com.CS434Project.Model.User;

import javax.persistence.*;

@Entity
@Table(name = "T_UNDERGRADSTUDENT")
public class UnderGradStudent implements User {
    private static UnderGradStudent INSTANCE = null;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="USERNAME", length = 100)
    private String username;

    @Column(name="PASSWORD", length = 100)
    private String password;

    public static UnderGradStudent getInstance() {
        if (INSTANCE == null){
            synchronized (UnderGradStudent.class){
                if (INSTANCE == null){
                    INSTANCE = new UnderGradStudent();
                }
            }
        }
        return INSTANCE;
    }

    //region Getters&Setters
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

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion
}
