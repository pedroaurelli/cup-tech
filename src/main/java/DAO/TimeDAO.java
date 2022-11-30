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
import java.util.ArrayList;

/**
 *
 * @author zpeed
 */
public class TimeDAO {
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
  
  public ArrayList<Time> listar () throws Exception {
    String sql = "SELECT nome, sigla, id FROM time";
    
    try (Connection conn = ConexaoDB.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
      ResultSet results = ps.executeQuery();
      
      ArrayList<Time> arr = new ArrayList();
      
      while (results.next()) {
        Integer id = results.getInt("id");
        String nome = results.getString("nome");
        String sigla = results.getString("sigla");
        
        Time novoTime = new Time(nome, sigla, id);
        
        arr.add(novoTime);
      }
      
      return arr;
    }
  }
  
  public boolean estaCheio () throws Exception {
    String sql = "SELECT count(id) from time";
    
    try (Connection conn = ConexaoDB.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
      ResultSet result = ps.executeQuery();
      result.next();
      
      Integer qntdTimes = result.getInt("count");
      
      return qntdTimes <= 31;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  
  public Time getTimeById (int id) throws Exception {
    String sql = "SELECT * from time WHERE id = ? ";
    try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      ResultSet results = ps.executeQuery();
      results.next();
      
      Integer idResult = results.getInt("id");
      String nome = results.getString("nome");
      String sigla = results.getString("sigla");
      
      Time time = new Time(nome, sigla, idResult);
      return time;
    }
  }
  
  public void atualizarTimeById (int id, String nome) throws Exception {
    String sql = "UPDATE time set nome = ? WHERE id = ?";
    try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, nome);
      ps.setInt(2, id);
      ps.execute();
    }
  }
  
  public void deletarTimeById (int id) throws Exception {
    String sql = "DELETE FROM time WHERE id = ?";
    try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, id);
      ps.execute();
    }
  }
}
