package com.example.Spring2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    DBUser db= new DBUser();

    @GetMapping("/hey")
    public String sayHi() {
        return "Hello from our server";
    }


//http://api.github.com/users/singhcodes    -- path parameter
//http://localhost:8080/search?q=ramu    -- query parameter


//http://localhost:8080/users    --get api
    @GetMapping("/users")
    public List<UserClass> getAllUsers(){
        return db.getAllUsers();
    }
//path param
//http://localhost:8080/users/{id}     -- get api
    @GetMapping("/users/{id}")
    public UserClass getAUser(@PathVariable int id){
        return db.getAUser(id);
    }
//query param
    //http://localhost:8080/users?q="taran"     -- get api
    @GetMapping("/user")
    public UserClass getAUser(@RequestParam String q)
    {
        return db.getAUserByName(q);
    }

    //post apis -->
//    to add user
    @PostMapping("/createUser")
    public UserClass createUser(@RequestBody UserClass user){
        return db.AddUser(user);
    }
}