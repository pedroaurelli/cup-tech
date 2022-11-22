/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula_13.DAO;

import com.mycompany.aula_13.ConexaoDB;
import com.mycompany.aula_13.Model.Time;
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
    
    System.out.println(time.getNome());
    
    try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, time.getNome());
      ps.setString(2, time.getSigla());
      try ( ResultSet rs = ps.executeQuery()) {
        rs.next();
      }
    }
  }
}
