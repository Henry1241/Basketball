/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.NBA.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.NBA.persistencia.Conexion;

/**
 * Clase que crea la consulta de las entidades dentro de la tabla de datos de la region oeste.
 * @author Enrique Gonzalez Leyva
 * Jesus Alexis Martan Gallardo
 * Xylan Rodriguez Robles
 */
public class NBAWest {
    
    private int idwest;
    private String equipo;
    private String g;
    private String p;
    private String pct;
    private String pdl;
    private String conf;
    private String loc;
    private String vis;
    private String u10;
    private String rach;
/**
 * Crea una lista que se encarga de almacenar todos los datos de la consulta al DB.
 * @return Todos los datos de nbadb_east de la tabla alumnos.
 */
    public static List<NBAWest> obtenerTodos() {
        List<NBAWest> nbaWest = new ArrayList<>();
        try {

            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT idwest, equipo, g, p, pct, pdl, conf, loc, vis, u10, rach FROM west");

            while (resultSet.next()) {
                NBAWest west = new NBAWest();
                west.setIdwest(resultSet.getInt(1));
                west.setEquipo(resultSet.getString(2));
                west.setG(resultSet.getString(3));
                west.setP(resultSet.getString(4));
                west.setPCT(resultSet.getString(5));
                west.setPDL(resultSet.getString(6));
                west.setConf(resultSet.getString(7));
                west.setLoc(resultSet.getString(8));
                west.setVis(resultSet.getString(9));
                west.setU10(resultSet.getString(10));
                west.setRach(resultSet.getString(11));

                nbaWest.add(west);

            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return nbaWest;
    }
/**
 * Ese método se encarga de buscar los datos a través del campo idwest.
 * @param idwest ID de los equipos de la region oeste.
 * @return Los datos separados por el ID del DB.
 */
    public static NBAWest obtenerPorId(int idwest) {
        NBAWest west = new NBAWest();
        try {
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT idwest, equipo, g, p, pct, pdl, conf, loc, vis, u10, rach FROM west WHERE idwest = ?");
            statement.setInt(1, idwest);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                west.setIdwest(resultSet.getInt(1));
                west.setEquipo(resultSet.getString(2));
                west.setG(resultSet.getString(3));
                west.setP(resultSet.getString(4));
                west.setPCT(resultSet.getString(5));
                west.setPDL(resultSet.getString(6));
                west.setConf(resultSet.getString(7));
                west.setLoc(resultSet.getString(8));
                west.setVis(resultSet.getString(9));
                west.setU10(resultSet.getString(10));
                west.setRach(resultSet.getString(11));
            }

        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return west;
    }

    /**
     *
     * @param equipo El nombre del equipo.
     * @param g Victorias del equipo.
     * @param p Derrotas del equipo.
     * @param pct Porcentaje de victorias del equipo.
     * @param pdl Juegos detras del equipo.
     * @param conf Marca de conferencias del equipo.
     * @param loc Partidas donde el equipo fue local.
     * @param vis Partidas donde el equipo fue visitante.
     * @param u10 Ultimas diez partidas del equipo.
     * @param rach Racha de victorias del equipo.
     * @return Indica si se guardó o no el registro.
     */
    public static boolean guardar(String equipo, String g, String p, String pct, String pdl, String conf, String loc, String vis, String u10, String rach) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO west(equipo, g, p, pct, pdl, conf, loc, vis, u10, rach) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, equipo);
            statement.setString(2, g);
            statement.setString(3, p);
            statement.setString(4, pct);
            statement.setString(5, pdl);
            statement.setString(6, conf);
            statement.setString(7, loc);
            statement.setString(8, vis);
            statement.setString(9, u10);
            statement.setString(10, rach);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
            
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
/**
 * 
 * @param idwest ID de los equipos de la region oeste.
     * @param equipo El nombre del equipo.
     * @param g Victorias del equipo.
     * @param p Derrotas del equipo.
     * @param pct Porcentaje de victorias del equipo.
     * @param pdl Juegos detras del equipo.
     * @param conf Marca de conferencias del equipo.
     * @param loc Partidas donde el equipo fue local.
     * @param vis Partidas donde el equipo fue visitante.
     * @param u10 Ultimas diez partidas del equipo.
     * @param rach Racha de victorias del equipo.
 * @return La columna modificada con los datos propuestos.
 */
    public static boolean editar(int idwest, String equipo, String g, String p, String pct, String pdl, String conf, String loc, String vis, String u10, String rach) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE west SET equipo = ?, g = ?, p = ?, pct = ?, pdl = ?, conf = ?, loc = ?, vis = ?, u10 = ?, rach = ? WHERE idwest = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, equipo);
            statement.setString(2, g);
            statement.setString(3, p);
            statement.setString(4, pct);
            statement.setString(5, pdl);
            statement.setString(6, conf);
            statement.setString(7, loc);
            statement.setString(8, vis);
            statement.setString(9, u10);
            statement.setString(10, rach);
            statement.setInt(11, idwest);
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    /**
     * Metodo que elimina una fila de datos especificando el id del mismo.
     * @param idwest ID de los equipos de la region oeste.
     * @return Un espacio vacio de la tabla del id especificado
     */
    public static boolean eliminar(int idwest) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "DELETE FROM west WHERE idwest = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idwest);
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    /**
     * @return the idwest
     */
    public int getIdwest() {
        return idwest;
    }

    /**
     * @param idwest the idwest to set
     */
    public void setIdwest(int idwest) {
        this.idwest = idwest;
    }

    /**
     * @return the equipo
     */
    public String getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    /**
     * @return the G
     */
    public String getG() {
        return g;
    }

    /**
     * @param g the G to set
     */
    public void setG(String g) {
        this.g = g;
    }

    /**
     * @return the P
     */
    public String getP() {
        return p;
    }

    /**
     * @param p the P to set
     */
    public void setP(String p) {
        this.p = p;
    }

    /**
     * @return the PCT
     */
    public String getPCT() {
        return pct;
    }

    /**
     * @param pct the PCT to set
     */
    public void setPCT(String pct) {
        this.pct = pct;
    }

    /**
     * @return the Conf
     */
    public String getConf() {
        return conf;
    }

    /**
     * @param conf the Conf to set
     */
    public void setConf(String conf) {
        this.conf = conf;
    }

    /**
     * @return the Loc
     */
    public String getLoc() {
        return loc;
    }

    /**
     * @param loc the loc to set
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }

    /**
     * @return the Vis
     */
    public String getVis() {
        return vis;
    }

    /**
     * @param vis the Vis to set
     */
    public void setVis(String vis) {
        this.vis = vis;
    }

    /**
     * @return the U10
     */
    public String getU10() {
        return u10;
    }

    /**
     * @param u10 the U10 to set
     */
    public void setU10(String u10) {
        this.u10 = u10;
    }

    /**
     * @return the Rach
     */
    public String getRach() {
        return rach;
    }

    /**
     * @param rach the Rach to set
     */
    public void setRach(String rach) {
        this.rach = rach;
    }

    /**
     * @return the PDL
     */
    public String getPDL() {
        return pdl;
    }

    /**
     * @param pdl the PDL to set
     */
    public void setPDL(String pdl) {
        this.pdl = pdl;
    }
    
}
