/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import App.ConexaoDB;
import Model.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author zpeed
 */
public class Time_DAO {
  public boolean existe(Time time) throws Exception {
    String sql = "SELECT * FROM time WHERE nome = ?";
    
    try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, time.getNome());
      try ( ResultSet rs = ps.executeQuery()) {
        return rs.next();
      }
    }
  }
  public void cadastrar (Time time) throws Exception {
    String sql = "INSERT INTO time (nome, sigla) VALUES ( ? , ? )";
    
    try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, time.getNome());
      ps.setString(2, time.getSigla());
      ps.execute();
    }
  }
  
  public String listar () throws Exception {
    String sql = "SELECT nome, sigla FROM time";
    
    try (Connection conn = ConexaoDB.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
      ResultSet results = ps.executeQuery();
      String msg = "";
      
      while (results.next()) {
        String nome = results.getString("nome");
        String sigla = results.getString("sigla");

        msg += nome + " - " + sigla + "\n";
      }
      
      return msg;
    } catch (Exception e) {
      e.printStackTrace();
      return "Erro";
    }
  }
}
