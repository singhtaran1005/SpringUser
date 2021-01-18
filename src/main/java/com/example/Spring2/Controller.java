package com.example.Spring2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    DBUser db= new DBUser();

    @GetMapping("/hey")
    public String sayHi() {
        return "Hello from our server";
    }


//http://api.github.com/users/singhcodes -- path parameter
//http://localhost:8080/search?q=ramu    -- query parameter

//http://localhost:8080/users    --get api
    @GetMapping("/users")
    public List<UserClass> getAllUsers(){
        return db.getAllUsers();
    }

//http://localhost:8080/users/{id}     -- get api
    @GetMapping("/users/{id}")
    public UserClass getAUser(@PathVariable int id){
        return db.getAUser(id);
    }

}