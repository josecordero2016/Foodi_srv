/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import clases.Conexion_bd;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.transform.OutputKeys;

/**
 *
 * @author PC
 */
@WebService(serviceName = "ws_Procesar")
public class ws_Procesar {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "procesar")
    public String procesar(@WebParam(name = "sentencia") String sentencia) {
        try {
            // No olvidar configurar con su bd local
            Conexion_bd con = new Conexion_bd();
            // Transformación a UTF para que se muestren los acentos
            byte[] setencia_byte = sentencia.getBytes();
            String utf = new String(setencia_byte, StandardCharsets.UTF_8);
            con.ejecutar(utf);
        } catch (Exception e) {
            return "Error, " + e.toString();
        }
        return "OK";
    }

    /**
     * Este es solo para consultar y el resultado sea un dato string
     */
    @WebMethod(operationName = "consultar")
    public String consultar(@WebParam(name = "sentencia") String sentencia) {
        
        try {
            // No olvidar configurar con su bd local
            Conexion_bd con = new Conexion_bd();
            // Transformación a UTF para que se muestren los acentos
            byte[] setencia_byte = sentencia.getBytes();
            String utf = new String(setencia_byte, StandardCharsets.UTF_8);
            return con.consultar_string(sentencia);
        } catch (Exception e) {
            return "Error, " + e.toString();
        }

    }

    

}
