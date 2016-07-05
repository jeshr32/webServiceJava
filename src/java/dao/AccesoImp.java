/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.ConnectMSSQLServer;
import db.ConnectMySql;
import dto.Cliente;
import dto.Comuna;
import dto.Region;
import dto.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class AccesoImp extends ConnectMySql implements Iacceso {

    @Override
    public Boolean registroCliente(Object object) {
        Cliente cliente = (Cliente)object;
        
        try {
            Connection con = super.getCon();
            String query = "insert into cliente (rut,nombres,apellido_p,apellido_m,email,direccion,comuna_id)"
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getRut());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getPaterno());
            ps.setString(4, cliente.getMaterno());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getAddress());
            ps.setInt(7, cliente.getComuna().getId());
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
        Venta venta = (Venta)object;
        
        try {
            Connection con = super.getCon();
            String query = "insert into venta (cliente_id,neto,iva,total,fecha,vigente,fecha_despacho)"
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, venta.getCliente().getId());
            ps.setInt(2, venta.getNeto());
            ps.setInt(3, venta.getIva());
            ps.setInt(4, venta.getTotal());
            ps.setDate(5, venta.getFecha());
            ps.setInt(6, Integer.parseInt(venta.getVigente().toString()));
            ps.setDate(7, venta.getDespacho());
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
    public Boolean anularVenta(Object object) {
        Venta venta = (Venta)object;
        
        try {
            Connection con = super.getCon();
            String query = "update venta set vigente = 0 where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, venta.getId());            
            
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
    
    public Cliente getCliente(String id){
        Cliente cliente = null;
        try {
            Connection con = super.getCon();
            String query = "select * from cliente where id = ?";
                    
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
               cliente = new Cliente(rs.getInt("id"),rs.getString("rut"),rs.getString("nombres"), rs.getString("apellido_p"), rs.getString("apellido_m "), rs.getString("email"),rs.getString("direccion"));
               cliente.setComuna(getComuna(rs.getString("comuna_id")));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return cliente;
    }
    
    public Comuna getComuna(String id){
        Comuna comuna = null;
        try {
            Connection con = super.getCon();
            String query = "select * from comuna where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);            
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
               comuna = new Comuna(rs.getInt("id"),rs.getString("nombre")); 
               comuna.setRegion(getRegion(rs.getString("region_id")));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return comuna;
    }
    
    public Region getRegion(String id){
        Region region = null;
        try {
            Connection con = super.getCon();
            String query = "select * from region where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);            
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
               region = new Region(rs.getInt("id"),rs.getString("nombre"));                 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return region;
    }
    
    
}
