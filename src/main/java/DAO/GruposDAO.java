/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import App.ConexaoDB;
import Model.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author zpeed
 */
public class GruposDAO {
  public void existe(Grupo grupo) throws Exception {
    String sql = "INSERT INTO grupos (id_time, grupo) VALUES (?, ?)";
    
    try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, grupo.getNomeGrupo());
      try ( ResultSet rs = ps.executeQuery()) {
        rs.next();
      }
    }
  }
}
