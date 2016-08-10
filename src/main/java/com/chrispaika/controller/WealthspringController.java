package com.chrispaika.controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import com.chrispaika.DataStore;
import com.chrispaika.dataobjects.Transaction;
import com.chrispaika.dataobjects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WealthspringController {

    Random randomLong;
    public WealthspringController() {
        randomLong = new Random();
    }

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
    public @ResponseBody long putUser(@RequestParam(value="fname", required=true, defaultValue="0") String fName, @RequestParam(value="lname", required=true, defaultValue="0") String lname) {
        return dataStore.createUser(fName, lname);
    }

    @RequestMapping(value="/transaction", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Transaction getTransaction(@RequestParam(value="txid", required=true, defaultValue="0") Long txid) {
        return dataStore.getTransaction(txid);
    }

    @RequestMapping(value="/createTransaction", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Long putTransaction(@RequestParam(value="payee", required=true, defaultValue = "name") String payee,
                                             @RequestParam(value="budgetCategory", required=true, defaultValue = "budget category") String budgetCategory,
                                             @RequestParam(value="memo", required=true, defaultValue = "memo") String memo,
                                             @RequestParam(value="outflow", required=true, defaultValue = "0") int outflow,
                                             @RequestParam(value="inflow", required=true, defaultValue = "0") int inflow,
                                             @RequestParam(value="cleared", required=true, defaultValue = "false") boolean cleared) {
        long txid = randomLong.nextLong();
        Transaction transaction = new Transaction(txid, payee, budgetCategory, memo, outflow, inflow, cleared);
        return dataStore.addTransaction(transaction);
    }
}
