/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Venta implements Serializable{

    
    private Integer id;

    private Cliente cliente;
    private Integer neto;
    private Integer iva;
    private Integer total;
    private Date fecha;
    private Boolean vigente;
    private Date despacho;

    public Venta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDespacho() {
        return despacho;
    }

    public void setDespacho(Date despacho) {
        this.despacho = despacho;
    }

    public Venta(Integer id, Cliente cliente, Integer neto, Integer iva, Integer total, Date fecha, Boolean vigente) {
        this.id = id;
        this.cliente = cliente;
        this.neto = neto;
        this.iva = iva;
        this.total = total;
        this.fecha = fecha;
        this.vigente = vigente;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getNeto() {
        return neto;
    }

    public void setNeto(Integer neto) {
        this.neto = neto;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    public Venta(Cliente cliente, Integer neto, Integer iva, Integer total, Date fecha, Boolean vigente, Date despacho) {
        this.cliente = cliente;
        this.neto = neto;
        this.iva = iva;
        this.total = total;
        this.fecha = fecha;
        this.vigente = vigente;
        this.despacho = despacho;
    }
    
    
}
