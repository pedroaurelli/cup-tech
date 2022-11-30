/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author zpeed
 */
public class Time {
  
  private String nome;
  private String sigla;
  private Integer id;
  
  public Time(String nome, String sigla, Integer id) {
    this.nome = nome;
    this.sigla = sigla;
    this.id = id;
  }
  
  public Integer getId () {
    return id;
  }
  
  public String getNome() {
    return nome;
  }
  
  public String setNome(String nome) {
    return this.nome = nome;
  }
  
  public String getSigla() {
    return sigla;
  }
  
  public String setSigla (String sigla) {
    return this.sigla = sigla;
  }
}
