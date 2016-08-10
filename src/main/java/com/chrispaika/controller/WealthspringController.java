package com.chrispaika.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.chrispaika.DataStore;
import com.chrispaika.dataobjects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WealthspringController {

    @Autowired
    DataStore dataStore;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/user", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody User getUser(@RequestParam(value="uuid", required=true, defaultValue="0") Long UUID) {
        return dataStore.getUser(UUID);
    }

    @RequestMapping(value="/createUser", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Long putUser(@RequestParam(value="fname", required=true, defaultValue="0") String fName, @RequestParam(value="lname", required=true, defaultValue="0") String lname) {
        return dataStore.createUser(fName, lname);
    }
}
