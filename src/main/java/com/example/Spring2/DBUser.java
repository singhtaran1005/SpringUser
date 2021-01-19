package com.example.Spring2;


import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class DBUser {

    //list of users
    private List<UserClass> userTable = new ArrayList<UserClass>();

    //constructor class
    public DBUser() {
        //{adding dummy data to own created db}
        userTable.add(new UserClass(1, "taran", 30));
        userTable.add(new UserClass(2, "ankit", 40));
    }

    public List<UserClass> getAllUsers() {
        return userTable;
    }

    public UserClass getAUser(int id) {
        for (UserClass user : userTable) {
            //found
            if (user.getId() == id)
                return user;
        }
        //not found
        return null;
    }

    public UserClass getAUserByName(String name) {
        for (UserClass user : userTable) {
            //found
            if (user.getName().equals(name))
                return user;
        }
        //not found
        return null;
    }

    //adding new users
    public UserClass AddUser(UserClass user) {
        userTable.add(user);
        return user;
    }
}
