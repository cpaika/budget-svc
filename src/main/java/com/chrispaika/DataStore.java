package com.chrispaika;

import org.springframework.stereotype.Component;
import com.chrispaika.dataobjects.Transaction;
import com.chrispaika.dataobjects.User;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DataStore {
    private HashMap<Long, User> userStore;
    private HashMap<Long, Transaction> transactionStore;

    public DataStore() {
         this.initialize();
    }

    public User getUser(Long uuid) {
        return  userStore.get(uuid);
    }

    public long createUser(String fName, String lName) {
        long uuid = ThreadLocalRandom.current().nextLong(100);
         userStore.put(uuid, new User(uuid, fName, lName));
        return uuid;
    }

    public long createTransaction(String payee, String memo) {
        long txid = ThreadLocalRandom.current().nextLong(100);
        transactionStore.put(txid, new Transaction(txid, payee, "Hello", memo, 0, 0, false));
        return txid;
    }

    public Transaction getTransaction(long txid) {
        return transactionStore.get(txid);
    }


    private void initialize() {
        userStore = new HashMap<Long, User>();
        this.createUser("Hello", "World");
        this.createUser("John", "Smith");
        this.createUser("Krabby", "Patty");
    }
}
