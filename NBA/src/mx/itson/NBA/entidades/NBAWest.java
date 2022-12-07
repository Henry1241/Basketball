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
 * Clase que crea la consulta de las entidades dentro de la tabla de datos "west" de la region oeste.
 * @author Enrique Gonzalez Leyva
 * Jesus Alexis Martan Gallardo
 * Xylan Rodriguez Robles
 */
public class NBAWest {
    
    private int idwest;
    private String equipo;
    private int g;
    private int p;
    private String pdl;
    private String conf;
    private String loc;
    private String vis;
    private String u10;
    private String rach;
    private double pctv;
/**
 * Crea una lista que se encarga de almacenar todos los datos de la consulta al DB.
 * @return Todos los datos de nbadb.west de la tabla alumnos.
 */
    public static List<NBAWest> obtener() {
        List<NBAWest> nbaWest = new ArrayList<>();
        try {

            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT idwest, equipo, g, p, pdl, conf, loc, vis, u10, rach, g / (g + p) FROM west");

            while (resultSet.next()) {
                NBAWest west = new NBAWest();
                west.setIdwest(resultSet.getInt(1));
                west.setEquipo(resultSet.getString(2));
                west.setG(resultSet.getInt(3));
                west.setP(resultSet.getInt(4));
                west.setPDL(resultSet.getString(5));
                west.setConf(resultSet.getString(6));
                west.setLoc(resultSet.getString(7));
                west.setVis(resultSet.getString(8));
                west.setU10(resultSet.getString(9));
                west.setRach(resultSet.getString(10));
                west.setPctv(resultSet.getDouble(11));

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
    public static NBAWest seleccion(int idwest) {
        NBAWest west = new NBAWest();
        try {
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT idwest, equipo, g, p, pdl, conf, loc, vis, u10, rach, g / (g + p) FROM west WHERE idwest = ?");
            statement.setInt(1, idwest);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                west.setIdwest(resultSet.getInt(1));
                west.setEquipo(resultSet.getString(2));
                west.setG(resultSet.getInt(3));
                west.setP(resultSet.getInt(4));
                west.setPDL(resultSet.getString(5));
                west.setConf(resultSet.getString(6));
                west.setLoc(resultSet.getString(7));
                west.setVis(resultSet.getString(8));
                west.setU10(resultSet.getString(9));
                west.setRach(resultSet.getString(10));
                west.setPctv(resultSet.getDouble(11));
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
     * @param pdl Juegos detras del equipo.
     * @param conf Marca de conferencias del equipo.
     * @param loc Partidas donde el equipo fue local.
     * @param vis Partidas donde el equipo fue visitante.
     * @param u10 Ultimas diez partidas del equipo.
     * @param rach Racha de victorias del equipo.
     * @return Indica si se guardó o no el registro.
     */
    public static boolean guardar(String equipo, int g, int p, String pdl, String conf, String loc, String vis, String u10, String rach) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO west(equipo, g, p, pdl, conf, loc, vis, u10, rach) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, equipo);
            statement.setInt(2, g);
            statement.setInt(3, p);
            statement.setString(4, pdl);
            statement.setString(5, conf);
            statement.setString(6, loc);
            statement.setString(7, vis);
            statement.setString(8, u10);
            statement.setString(9, rach);
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
     * @param pdl Juegos detras del equipo.
     * @param conf Marca de conferencias del equipo.
     * @param loc Partidas donde el equipo fue local.
     * @param vis Partidas donde el equipo fue visitante.
     * @param u10 Ultimas diez partidas del equipo.
     * @param rach Racha de victorias del equipo.
 * @return La columna modificada con los datos propuestos.
 */
    public static boolean editar(int idwest, String equipo, int g, int p, String pdl, String conf, String loc, String vis, String u10, String rach) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE west SET equipo = ?, g = ?, p = ?, pdl = ?, conf = ?, loc = ?, vis = ?, u10 = ?, rach = ? WHERE idwest = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, equipo);
            statement.setInt(2, g);
            statement.setInt(3, p);
            statement.setString(4, pdl);
            statement.setString(5, conf);
            statement.setString(6, loc);
            statement.setString(7, vis);
            statement.setString(8, u10);
            statement.setString(9, rach);
            statement.setInt(10, idwest);
            
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
    public int getG() {
        return g;
    }

    /**
     * @param g the G to set
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * @return the P
     */
    public int getP() {
        return p;
    }

    /**
     * @param p the P to set
     */
    public void setP(int p) {
        this.p = p;
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

    /**
     * @return the pctv
     */
    public double getPctv() {
        return pctv;
    }

    /**
     * @param pctv the pctv to set
     */
    public void setPctv(double pctv) {
        this.pctv = pctv;
    }
    
}
