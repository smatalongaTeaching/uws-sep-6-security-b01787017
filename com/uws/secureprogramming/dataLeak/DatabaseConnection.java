package com.uws.secureprogramming.dataLeak;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private UserDatabase userDatabase;
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    public DatabaseConnection(UserDatabase users) {
        userDatabase = users;
        userDatabase.addUser(new User("admin", "admin@disney.com", "secr3tP@ss"));
    }

    public void connectToDatabase(String username, String password) throws Exception {
        try {
            // Simulating database connection

            if (username == null || password == null) {
                throw new IllegalArgumentException("Username or password is null");
            }
            if (username.equals("admin") && !password.equals("secr3tP@ss")) {
                throw new Exception("Authentication failed: Incorrect password for user admin");
            }
            if (!this.userDatabase.AcceptUserLogin(username, password)) {
                throw new Exception("Authentication failed: User not found or incorrect password");
            }
            System.out.println("Connected successfully to database as " + username);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during database connection", e);
            throw e;
        }
    }
}