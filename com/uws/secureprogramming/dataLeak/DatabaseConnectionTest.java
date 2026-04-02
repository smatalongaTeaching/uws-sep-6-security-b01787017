package com.uws.secureprogramming.dataLeak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {

    private UserDatabase userDatabase;
    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        userDatabase = new UserDatabase();
        // Add example users (Disney characters)
        userDatabase.addUser(new User("mickey", "mm@disney.com", "mouse123"));
        userDatabase.addUser(new User("donald", "dd@disney.com", "duck456"));
        userDatabase.addUser(new User("goofy", "goof@disney.com", "good123"));
        userDatabase.addUser(new User("minnie", "mm01@disney.com", "minnie321"));
        dbConnection = new DatabaseConnection(userDatabase);
    }

    @Test
    void testConnectWithNullUsername() {
        dbConnection.connectToDatabase(null, "password");
    }

    @Test
    void testConnectWithNullPassword() {
        dbConnection.connectToDatabase("mickey", null);
    }

    @Test
    void testUserNotFoundOrIncorrectPassword() {
        dbConnection.connectToDatabase("pluto", "dog123");
        dbConnection.connectToDatabase("donald", "wrongpass");
    }

    @Test
    void testSuccessfulConnection() {
        dbConnection.connectToDatabase("goofy", "goof789");
        dbConnection.connectToDatabase("minnie", "minnie321");
    }

    @Test
    void testAdminConnectionWithIncorrectPassword() {
        dbConnection.connectToDatabase("admin", "wrongpass");
    }

    @Test
    void testAdminConnectionWithCorrectPassword() {
        dbConnection.connectToDatabase("admin", "secr3tP@ss");
    }
}