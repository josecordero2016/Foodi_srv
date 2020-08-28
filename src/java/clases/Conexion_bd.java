package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion_bd {

    private Connection connection;
    private boolean okConnection;
    private String ok;
    private ResultSet rs = null;
    private Statement str = null;
    private String estado;

    public Conexion_bd() {
        connection = null;

        try {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/foodi", "postgres", "pa1998");
                okConnection = connection.isValid(1000);
                System.out.println(okConnection ? "TEST OK" : "TEST FAIL");
                ok = okConnection ? "OK" : "TEST FAIL";
            } catch (ClassNotFoundException ex) {
                ok = ex.getMessage();
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            ok = ex.getMessage();
        }
    }

    public ResultSet consultar(String sentencia) {
        try {
            str = this.connection.createStatement();
            ResultSet res = str.executeQuery(sentencia);  // Ejecuta la linea de c.

            return res;
        } catch (SQLException e) {
            estado = "Error " + e;
        }
        return null;
    }

    public String consultar_string(String sentencia) {
        try {
            str = this.connection.createStatement();
            ResultSet res = str.executeQuery(sentencia);  // Ejecuta la linea de c.
            String resultado = "";
            while (res.next()) {
                resultado = res.getString(1);
            }
            return resultado;
        } catch (SQLException e) {
            estado = "Error " + e;
        }
        return estado;
    }

    public boolean ejecutar(String sentencia) {
        try {
            str = this.connection.createStatement();
            str.execute(sentencia);
            return true;
        } catch (SQLException e) {
            estado = "Error " + e;
            return false;
        }
    }

    public ArrayList getArrayList(String sentencia) {
        ArrayList results = null;
        Statement statement;
        ResultSet resultSet;
        Boolean okConexion = isOkConnection();
        //ArrayList results = null;

        if (okConexion) {
            try {
                statement = this.getConnection().createStatement();
                resultSet = statement.executeQuery(sentencia);
                ResultSetMetaData md = resultSet.getMetaData();
                int columns = md.getColumnCount();
                results = new ArrayList();

                while (resultSet.next()) {
                    HashMap row = new HashMap();
                    results.add(row);

                    for (int i = 1; i <= columns; i++) {
                        row.put(md.getColumnName(i), resultSet.getObject(i));
                    }
                }
            } catch (SQLException exp) {
                System.out.println("Error: " + exp);
                results = null;
            }
        }
        return results;
    }

    public void cerrarConexion() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion_bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isOkConnection() {
        return okConnection;
    }

    public void setOkConnection(boolean okConnection) {
        this.okConnection = okConnection;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}
