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
        Comuna comuna = new Comuna(1,"Santiago",13);
        cliente.setComuna(comuna);
        Iacceso acc = new AccesoImp();
        if(acc.registroCliente(cliente)){
            return "Cliente " + id + " registrado!";
        }else{
            return "Error al registrar";
        }
        
        
    }
    
    @WebMethod(operationName = "RegistroVenta")
    public String RegistroVenta(@WebParam(name = "id") String id,@WebParam(name = "idCliente") String idCliente , @WebParam(name = "neto") String neto, @WebParam(name = "iva") String iva ,@WebParam(name = "total") String total ,@WebParam(name = "fecha") String fecha, @WebParam(name = "vigente") String vigente) {
        String respuesta = "";
        return "Venta " + id + " realizada con exito!";
    }
    
    @WebMethod(operationName = "AnularVenta")
    public String AnularVenta(@WebParam(name = "idVenta") String id,@WebParam(name = "idCliente") String idCliente , @WebParam(name = "vigente") String vigente){
        String respuesta = "";
        return "Venta " + id + " anulada con exito!";
    }
    
}
