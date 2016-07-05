/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.java;

import dao.AccesoImp;
import dao.Iacceso;
import dto.Cliente;
import dto.Comuna;
import dto.Region;
import dto.Venta;
import java.sql.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Lenovo
 */
@WebService(serviceName = "WebServiceJava")
public class WebServiceJava {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "RegistroCliente")
    public String RegistroCliente(@WebParam(name = "id") String id,@WebParam(name = "rut") String rut , @WebParam(name = "nombres") String nombres, @WebParam(name = "apellido_p") String apellido_p ,@WebParam(name = "apellido_m") String apellido_m ,@WebParam(name = "email") String email, @WebParam(name = "direccion") String direccion) {
        Cliente cliente= new Cliente(rut,nombres,apellido_p,apellido_m,email,direccion);
        Region region = new Region(13,"RM");
        Comuna comuna = new Comuna(1,"Santiago",region);
        cliente.setComuna(comuna);
        Iacceso acc = new AccesoImp();
        if(acc.registroCliente(cliente)){
            return "Cliente " + id + " registrado!";
        }else{
            return "Error al registrar";
        }
        
        
    }
    
    @WebMethod(operationName = "RegistroVenta")
    public String RegistroVenta(@WebParam(name = "id") String id,@WebParam(name = "idCliente") Integer idCliente , @WebParam(name = "neto") Integer neto, @WebParam(name = "iva") Integer iva ,@WebParam(name = "total") Integer total ,@WebParam(name = "fecha") Date fecha, @WebParam(name = "vigente") Boolean vigente, @WebParam(name = "despacho") Date despacho) {
        Cliente cli = new Cliente();
        cli.setId(idCliente);
        Venta venta= new Venta(cli, neto ,iva, total, fecha, vigente, despacho);
        Iacceso acc = new AccesoImp();
        if(acc.registroVenta(venta)){
            return "Venta " + id + " registrado!";
        }else{
            return "Error al registrar";
        }
    }
    
    @WebMethod(operationName = "AnularVenta")
    public String AnularVenta(@WebParam(name = "idVenta") Integer id,@WebParam(name = "idCliente") Integer idCliente , @WebParam(name = "vigente") String vigente){
        Venta venta = new Venta();
        venta.setId(id);
        Iacceso acc = new AccesoImp();
        if(acc.anularVenta(venta)){
            return "Venta " + id + " anulado!";
        }else{
            return "Error al anular";
        }
    }
    
}
