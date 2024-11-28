/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import entidades.Departamento;
import java.util.List;

/**
 *
 * @author Computador
 */
public interface DepartamentoDao {
    
    void inserir(Departamento obj);
    void atualizar(Departamento obj);
    void excluirId(Integer id);
    Departamento buscarId(Integer id);
    List<Departamento> buscarTodos();
    
}
