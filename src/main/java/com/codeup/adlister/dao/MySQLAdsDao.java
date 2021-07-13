package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
  private Connection connection = null;

  public MySQLAdsDao(Config config) {
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

  @Override
  public List<Ad> all() {
//    Were not using a prepared statement here because we are not accepting user input? We're just listing all the ads.
    Statement stmt = null;

    try {
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
      return createAdsFromResults(rs);
    } catch (SQLException e) {
      throw new RuntimeException("Error retrieving all ads.", e);
    }
  }

  @Override
  public Long insert(Ad ad) {
    String sql = "INSERT INTO ads(title, description, user_id) VALUES (?, ?, ?);";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1,ad.getTitle());
      stmt.setString(2,ad.getDescription());
      stmt.setLong(3,ad.getUserId());
      stmt.executeUpdate();
      ResultSet rs = stmt.getGeneratedKeys();
      rs.next();
      return rs.getLong(1);
    } catch (SQLException e) {
      throw new RuntimeException("Error creating a new ad.", e);
    }
  }


  private String createInsertQuery(Ad ad) {
    return "INSERT INTO ads(user_id, title, description) VALUES "
      + "(" + ad.getUserId() + ", "
      + "'" + ad.getTitle() + "', "
      + "'" + ad.getDescription() + "')";
  }

  private Ad extractAd(ResultSet rs) throws SQLException {
    return new Ad(
      rs.getLong("id"),
      rs.getLong("user_id"),
      rs.getString("title"),
      rs.getString("description")
    );
  }

  private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
    List<Ad> ads = new ArrayList<>();
    while (rs.next()) {
      ads.add(extractAd(rs));
    }
    return ads;
  }

  @Override
  public Ad getOne(long id) {
    String sql = "SELECT * FROM ads WHERE id = ?;";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setLong(1,id);
      ResultSet rs = stmt.getGeneratedKeys();
      rs.next();
      return extractAd(rs);
    } catch (SQLException e) {
      throw new RuntimeException("Error creating a new ad.", e);
    }
  }

  public List<Ad> searchByTitle(String query) {
    String sql = "SELECT * FROM ads WHERE title LIKE ?";
    String searchTermWithWildCards = "%" +query +"%";
    PreparedStatement stmt = null;
    try {
      stmt = connection.prepareStatement(sql);
      stmt.setString(1, searchTermWithWildCards);
      ResultSet rs = stmt.executeQuery(sql);
      return createAdsFromResults(rs);
    } catch (SQLException e) {
      throw new RuntimeException("Error retrieving all ads.", e);
    }
  }
}

//@Override
//  public List<Ad> searchByTitle(String query) {
//    String sql = "SELECT * FROM ads WHERE title LIKE ?;";
//    String searchTermWithWildCards = "%" + query + "%";
//    //Notice how we don't need single quotes there.
//    //    String sql = "SELECT * FROM ads WHERE title LIKE '%" + query + "%';";
//    PreparedStatement stmt = null;
////    Statement stmt = null;
//    try {
//      stmt.setString(1,searchTermWithWildCards);
////            stmt = connection.createStatement();
////      Is the old way and can cause issues if 's are used.
//      stmt = connection.prepareStatement(sql);
//      ResultSet rs = stmt.executeQuery(sql);
//      return createAdsFromResults(rs);
//    } catch (SQLException e) {
//      throw new RuntimeException("Error retrieving all ads.", e);
//    }
//  }
