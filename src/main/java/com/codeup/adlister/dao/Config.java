package com.codeup.adlister.dao;

class Config {
  public String getUrl() {
    return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
  }

  public String getUser() {
    return "adlister_admin";
  }

  public String getPassword() {
    return "codeup";
  }
}