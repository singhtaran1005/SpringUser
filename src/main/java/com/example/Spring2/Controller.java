package com.example.Spring2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {

    DBUser db = new DBUser();

    @GetMapping("/hey")
    public String sayHi() {
        return "Hello from our server";
    }


//http://api.github.com/users/singhcodes    -- path parameter
//http://localhost:8080/search?q=ramu    -- query parameter


    //http://localhost:8080/users    --get api
    @GetMapping("/users")
    public List<UserClass> getAllUsers() {
        return db.getAllUsers();
    }

    //path param
//http://localhost:8080/users/{id}     -- get api
    @GetMapping("/users/{id}")
    public ResponseEntity<UserClass> getAUser(@PathVariable int id) {
        //adding response entity to add headers and status codes
        UserClass user1 = db.getAUser(id);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();   // to add multiple values for a given key
        headers.put("server", Collections.singletonList("codeoftaran"));   //adding headers
        HttpStatus status = HttpStatus.CREATED;   //adding status code as {201}

        ResponseEntity<UserClass> response = new ResponseEntity<UserClass>(user1, headers, status);   //encapsulating UserClass in entity

        return response;

    }

    //query param
    //http://localhost:8080/users?q="taran"     -- get api
//    @GetMapping("/users")
//    public UserClass getAUser(@RequestParam String a) {
//        return db.getAUserByName(a);
//    }

    //post apis -->
//    to add user
    @PostMapping("/createUser")    //modifying the status code of our api
    @ResponseStatus(HttpStatus.CREATED)
    public UserClass createUser(@RequestBody UserClass user) {
        return db.AddUser(user);
    }


////    delete apis  -->
//    //users/{id}
    @DeleteMapping("/users/{id}")

        public boolean DeleteUser(@PathVariable int id){
            return db.DeleteUser(id);

    }
}


// old way of accessing apis ->
//@RequestMapping(path = "/hi",method = RequestMethod.GET,consumes="application/json",produces="application/json")