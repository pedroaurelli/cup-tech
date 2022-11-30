/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import Model.Usuario;
import App.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public boolean existe(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
        try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            try ( ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    
    public boolean isAdmin(Usuario usuario) throws Exception {
      String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
      try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
          ps.setString(1, usuario.getNome());
          ps.setString(2, usuario.getSenha());
          
          try (ResultSet result = ps.executeQuery();) {
            result.next();
            
            Boolean role = result.getBoolean("is_admin");

            return role;
          }
      }
    }
    
    public void cadastrar (Usuario usuario) throws Exception {
      String sql = "INSERT INTO usuario (nome, senha) VALUES ( ? , ? )";

      try ( Connection conn = ConexaoDB.obterConexao();  PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getSenha());
        ps.execute();
      }
    }
}
