package com.codeup.adlister.util;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    private static final int ROUNDS = 12;

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }
//    Above turns the password into a hash using Bcrypt

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
//    Above allows us to CHECK if a password could return the same hash (basically checking the hash stored against the password presented?

}
