/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacao;

import entidades.DaoFactory;
import entidades.Departamento;
import model.dao.DepartamentoDao;

/**
 *
 * @author Computador
 */
public class Programa2 {
    
    public static void main(String[] args){
        
        DepartamentoDao dep = DaoFactory.criarDepartamentoDao();
        
        Departamento departamento = new Departamento(null, "SPM");
        dep.inserir(departamento);
        
        
    }
    
}
