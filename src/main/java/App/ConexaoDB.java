/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoDB {
  
    private static String host = "ec2-54-163-34-107.compute-1.amazonaws.com";
    private static String porta = "5432";
    private static String db = "d6ppvf29o2mfuq";
    private static String usuario = "weqjmvgczeesvn";
    private static String senha = "b1682dbf60d7a90a7ab0721a1e585f884b64daac2719ed66fc7591a4f85c1473";

    public static Connection obterConexao() throws Exception {
        String url = String.format(
                "jdbc:postgresql://%s:%s/%s",
                host,
                porta,
                db
        );
        return DriverManager.getConnection(url, usuario, senha);
    }
}
