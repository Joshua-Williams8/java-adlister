package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users{
  private Connection connection = null;


  public MySQLUsersDao(Config config) {
  try {
    DriverManager.registerDriver(new Driver());
    connection = DriverManager.getConnection(
      config.getUrl(),
      config.getUser(),
      config.getPassword()
    );
  } catch (SQLException e) {
    throw new RuntimeException("Error connecting to the database!", e);
    }
  }
  private User extractUser(ResultSet rs) throws SQLException {
    return new User(
      rs.getLong("id"),
      rs.getString("username"),
      rs.getString("email"),
      rs.getString("password")
    );
  }


  private List<User> createUsersFromResults(ResultSet rs) throws SQLException {
    List<User> users = new ArrayList<>();
    while (rs.next()){
      users.add(extractUser(rs));
    }
    return users;
  }


//  public User findByUsername(String username) {
//    String sql = "SELECT * FROM users WHERE username LIKE ?";
//    String searchWildCards = "%" + username + "%";
//    PreparedStatement stmt = null;
//    try{
//      stmt = connection.prepareStatement(sql);
//      stmt.setString(1,searchWildCards);
//      ResultSet rs = stmt.executeQuery(sql);
//
//      return createUsersFromResults(rs);
//
//    } catch (SQLException e) {
//      throw new RuntimeException("Error retrieving all ads.", e);
//    }
//  }



  @Override
  public List<User> findByUsername(String username) {
    String sql = "SELECT * FROM users WHERE username = '" + username + "';";
    PreparedStatement stmt = null;
    try{
      stmt = connection.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery(sql);

      return createUsersFromResults(rs);

    } catch (SQLException e) {
      throw new RuntimeException("Error retrieving all users.", e);
    }
  }


  @Override
  public Long insert(User user) {
    String sql = "INSERT INTO users(username, email, password) VALUES (?, ?, ?);";
    try{
      PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1,user.getUsername());
      stmt.setString(2,user.getEmail());
      stmt.setString(3,user.getPassword());
      stmt.executeUpdate();
//      Not sure why we need stuff below? maybe to set the id of the user?
      ResultSet rs = stmt.getGeneratedKeys();
      rs.next();
      return rs.getLong(1);
    } catch (SQLException e) {
      throw new RuntimeException("Error creating a new User.", e);
    }
  }

  public User getOne(String username) {
    String sql = "SELECT * FROM users WHERE username = ?;";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setString(1,username);
      ResultSet rs = stmt.getGeneratedKeys();
      rs.next();
      return extractUser(rs);
    } catch (SQLException e) {
      throw new RuntimeException("Error creating finding User.", e);
    }
  }

  public User findByUsernameNoList(String username) {
    String sql = "SELECT * FROM users WHERE username = '" + username + "';";
    PreparedStatement stmt = null;
    try{
      stmt = connection.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery(sql);
      return new User(extractUser(rs).getUsername(),extractUser(rs).getPassword(),extractUser(rs).getEmail());
    } catch (SQLException e) {
      throw new RuntimeException("Error retrieving a user.", e);
    }
  }
}