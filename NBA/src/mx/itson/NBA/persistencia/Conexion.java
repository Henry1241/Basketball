/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.NBA.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *Clase que provee la conexion con la base de datos.
 * @author Jesus Alexis Martan Gallardo
 * Enrique Gonzalez Leyva
 * Xylan Rodriguez Robles
 */
public class Conexion {
    
    /**
     * Obtiene una conexión hacia la base de datos utilizando los parámetros proporcionados.
     * @return La conexión inicializada hacia la base de datos.
     */
    public static Connection obtener() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/nbadb?user=root&password=Ninten22");
        } catch (Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return conexion;
    }
}
