/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacao;

import entidades.DaoFactory;
import entidades.Departamento;
import java.util.ArrayList;
import java.util.List;
import model.dao.DepartamentoDao;

/**
 *
 * @author Computador
 */
public class Programa2 {
    
    public static void main(String[] args){
        
        DepartamentoDao dep = DaoFactory.criarDepartamentoDao();
        
        
        System.out.println("--INSERINDO DEPARTAMENTO--");
        Departamento departamento = new Departamento(null, "SPM");
        dep.inserir(departamento);
        System.out.println("");
        
        System.out.println("--BUSCANDO TODOS OS DEPARTAMENTOS--");
        List<Departamento> list = new ArrayList<>();
        list = dep.buscarTodos();
        for(Departamento depart : list){
            System.out.println(depart);
        }
        System.out.println("");
        
        System.out.println("--BUSCANDO DEPARTAMENTO PELO ID--");
        Departamento depar = dep.buscarId(2);
        System.out.println(depar);
        System.out.println("");
        
        System.out.println("--ATUALIZANDO DEPARTAMENTO--");
        depar.setNome("GTE2");
        dep.atualizar(depar);
        System.out.println("Atualização concluida");
        System.out.println("");
        
        System.out.println("--EXCLUINDO DEPARTAMENTO--");
        dep.excluirId(6);
        System.out.println("Excluido com sucesso");
 
    }
    
}
