/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula_13.DAO;

import com.mycompany.aula_13.Model.Curso;
import com.mycompany.aula_13.ConexaoDB;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMSUNG
 */
public class Curso_DAO {

    public void incluir(Curso curso) {

    }

    public void atualizar(Curso curso) {

    }

    public void remover(Curso curso) {

    }

    public ArrayList<Curso> listar() {
        ArrayList<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_curso";
        try ( Connection conn = ConexaoDB.obterConexao();  
                PreparedStatement ps = conn.prepareStatement(sql); 
                ResultSet rs = ps.executeQuery()) {

            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                Curso curso = new Curso(id, nome, tipo);
                lista.add(curso);
            }
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(Curso_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
