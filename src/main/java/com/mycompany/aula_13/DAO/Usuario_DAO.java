/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.aula_13.DAO;

import com.mycompany.aula_13.Model.*;
import com.mycompany.aula_13.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author SAMSUNG
 */
public class Usuario_DAO {

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
}
