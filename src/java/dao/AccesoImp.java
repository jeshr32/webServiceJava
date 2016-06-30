/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.ConnectMSSQLServer;
import dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Lenovo
 */
public class AccesoImp extends ConnectMSSQLServer implements Iacceso {

    @Override
    public Boolean registroCliente(Object object) {
        Cliente cliente = (Cliente)object;
        
        try {
            Connection con = super.getCon();
            String query = "insert into cliente (rut,nombres,apellido_p,apellido_m,email,direccion,comuna)"
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getRut());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getPaterno());
            ps.setString(4, cliente.getMaterno());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getAddress());
            ps.setString(7, "1");
            try {
                ps.executeUpdate();
                desconectar();
                return true;                
            } catch (Exception e) {
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        
        
    }

    @Override
    public Boolean registroVenta(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean anularVenta(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
