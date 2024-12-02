/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacao;

import entidades.DaoFactory;
import entidades.Departamento;
import entidades.Vendedor;
import java.util.ArrayList;
import java.util.List;
import model.dao.VendedorDao;

/**
 *
 * @author Computador
 */
public class Programa {
    
    public static void main(String[] args){
        
        VendedorDao vend = DaoFactory.criarVendedorDao();
        Vendedor vendedor = vend.buscarId(2);
        System.out.println(vendedor);
        
        Departamento departamento = new Departamento(2,null);
        
        
        List<Vendedor> lista = vend.buscarDepartamento(departamento);
        System.out.println("LISTA");
        for(Object list : lista){
            System.out.println(list);
            
        }
        
        
        
        
    }
}
