package com.codeup.adlister.dao;

class Config {
  public String getUrl() {
    return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
  }

  public String getUser() {
    return "DB_ADMIN_HERE";
  }

  public String getPassword() {
    return "PASSWORDHERE";
  }
}
