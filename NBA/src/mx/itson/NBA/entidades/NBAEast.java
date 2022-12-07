
package mx.itson.NBA.entidades;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import mx.itson.NBA.persistencia.Conexion;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * Clase que crea la consulta de las entidades dentro de la tabla de datos "east" de la region este.
 * @author Jesus Alexis Martan Gallardo
 * Enrique Gonzalez Leyva
 * Xylan Rodriguez Robles
 */

public class NBAEast {
    
    private int ideast;
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
 * @return Todos los datos de nbadb.east de la tabla alumnos.
 */
    public static List<NBAEast> obtener() {
        List<NBAEast> nbaEast = new ArrayList<>();
        try {

            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ideast, equipo, g, p, pdl, conf, loc, vis, u10, rach, g / (g + p) FROM east");

            while (resultSet.next()) {
                NBAEast east = new NBAEast();
                east.setIdeast(resultSet.getInt(1));
                east.setEquipo(resultSet.getString(2));
                east.setG(resultSet.getInt(3));
                east.setP(resultSet.getInt(4));
                east.setPDL(resultSet.getString(5));
                east.setConf(resultSet.getString(6));
                east.setLoc(resultSet.getString(7));
                east.setVis(resultSet.getString(8));
                east.setU10(resultSet.getString(9));
                east.setRach(resultSet.getString(10));
                east.setPctv(resultSet.getDouble(11));

                nbaEast.add(east);

            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return nbaEast;
    }
/**
 * Ese método se encarga de buscar los datos a través del campo ideast.
 * @param ideast ID de los equipos de la region este.
 * @return Los datos separados por el ID del DB.
 */
    public static NBAEast seleccion(int ideast) {
        NBAEast east = new NBAEast();
        try {
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT ideast, equipo, g, p, pdl, conf, loc, vis, u10, rach, g / (g + p) FROM east WHERE ideast = ?");
            statement.setInt(1, ideast);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                east.setIdeast(resultSet.getInt(1));
                east.setEquipo(resultSet.getString(2));
                east.setG(resultSet.getInt(3));
                east.setP(resultSet.getInt(4));
                east.setPDL(resultSet.getString(5));
                east.setConf(resultSet.getString(6));
                east.setLoc(resultSet.getString(7));
                east.setVis(resultSet.getString(8));
                east.setU10(resultSet.getString(9));
                east.setRach(resultSet.getString(10));
                east.setPctv(resultSet.getDouble(11));
            }

        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return east;
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
            String consulta = "INSERT INTO east(equipo, g, p, pdl, conf, loc, vis, u10, rach) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
 * Metodo que se encarga de editar una fila de la  tabla.
 * @param ideast ID de los equipos de la region este.
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
    public static boolean editar(int ideast, String equipo, int g, int p, String pdl, String conf, String loc, String vis, String u10, String rach) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE east SET equipo = ?, g = ?, p = ?, pdl = ?, conf = ?, loc = ?, vis = ?, u10 = ?, rach = ? WHERE ideast = ?";
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
            statement.setInt(10, ideast);
            
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
     * @param ideast ID de los equipos de la region este.
     * @return Un espacio vacio de la tabla del id especificado
     */
    public static boolean eliminar(int ideast) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "DELETE FROM east WHERE ideast = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, ideast);
            
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    /**
     * @return the ideast
     */
    public int getIdeast() {
        return ideast;
    }

    /**
     * @param ideast the ideast to set
     */
    public void setIdeast(int ideast) {
        this.ideast = ideast;
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
