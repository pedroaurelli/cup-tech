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
public class Grupos_DAO {
  public boolean existe(Time time) throws Exception {
    String sql = "SELECT * FROM grupos";
    
    try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, time.getNome());
      try ( ResultSet rs = ps.executeQuery()) {
        return rs.next();
      }
    }
  }
}
