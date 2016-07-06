/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cliente;
import dto.Comuna;
import dto.Region;

/**
 *
 * @author Lenovo
 */
public interface Iacceso {
    Boolean registroCliente(Object object);
    Boolean registroVenta(Object object);
    Boolean anularVenta(Object object);
    Comuna getComuna(Integer id);
    Cliente getCliente(Integer id);
    Region getRegion(Integer id);
}
