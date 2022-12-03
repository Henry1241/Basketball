
package mx.itson.NBA.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.Connection;
import mx.itson.NBA.persistencia.Conexion;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Jesus Alexis Martan Gallardo
 */
public class NBAEast {

    private int id;
    private String nombre;
    private String apellidos;
    private String idCia;
    private Date fechaNacimiento;
    private String apodo;

    public static List<NBAEast> obtenerTodos() {
        List<NBAEast> nbaEast = new ArrayList<>();
        try {

            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("");

            while (resultSet.next()) {
                NBAEast nbaEast = new NBAEast();
                nbaEast.set(resultSet.getInt(1));
                nbaEast.set(resultSet.getString(2));
                nbaEast.set(resultSet.getString(3));
                nbaEast.set(resultSet.getString(4));
                nbaEast.set(resultSet.getDate(5));
                nbaEast.set(resultSet.getString(6));

                nbaEast.add(nbaEast);

            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return nbaEast;
    }

    public static NBAEast obtenerPorId() {
        NBAEast nbaEast = new NBAEast();
        try {
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("");
            statement.setInt(1, );

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                nbaEast.set(resultSet.getInt(1));
                nbaEast.set(resultSet.getString(2));
                nbaEast.set(resultSet.getString(3));
                nbaEast.set(resultSet.getString(4));
                nbaEast.set(resultSet.getDate(5));
                nbaEast.set(resultSet.getString(6));
            }

        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return nbaEast;
    }

    /**
     *
     * @param 
     * @param 
     * @param
     * @param
     * @param 
     * @return Indica si se guardó o no el registro.
     */
    public static boolean guardar() {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, );
            statement.setString(2, );
            statement.setString(3, );
            statement.setString(4, );
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    public static boolean editar() {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, );
            statement.setString(2, );
            statement.setString(3, );
            statement.setString(4, );
            statement.setInt(5, );
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

   
}
