/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacao;

import entidades.DaoFactory;
import entidades.Departamento;
import entidades.Vendedor;
import java.util.ArrayList;
import java.util.Date;
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
        System.out.println("Buscar de Vendedor pelo ID");
        System.out.println(vendedor);
        System.out.println("");
        
       
        
        Departamento departamento = new Departamento(2,null);
        List<Vendedor> lista = vend.buscarDepartamento(departamento);
        System.out.println("Busca de Vendedores pelo departamento");
        for(Object list : lista){
            System.out.println(list);
        }
        System.out.println("");
        
        lista = vend.buscarTodos();
        System.out.println("Busca de Vendedores");
        for(Object list : lista){
            System.out.println(list);
        }
        System.out.println("");
        System.out.println("--INSERINDO NOVO VENDEDOR--");
        Vendedor novoVendedor = new Vendedor(null, "Daniel Miranda", "daniel@gmail.com", new Date(), 8000.0, departamento);
        vend.inserir(novoVendedor);
        System.out.println("Novo Vendedor Inserido ID: " + novoVendedor.getId());
        System.out.println("");
        
        System.out.println("--ATUALIZANDO VENDEDOR--");
        vendedor = vend.buscarId(8);
        vendedor.setNome("Paulo Ricardo");
        vendedor.setEmail("paulo@gmail.com");
        vend.atualizar(vendedor);
        System.out.println("Atualização concluída");
        
    }
}
