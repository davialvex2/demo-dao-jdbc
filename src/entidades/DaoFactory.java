/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import db.DB;
import model.dao.VendedorDao;
import model.dao.jdbc.VendedorDaoJDBC;

/**
 *
 * @author Computador
 */
public class DaoFactory {
    
    public static VendedorDao criarVendedorDao(){
        return new VendedorDaoJDBC(DB.getConnection());
    }
    
}
