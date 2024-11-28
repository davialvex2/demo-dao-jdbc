/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import entidades.Vendedor;
import java.util.List;

/**
 *
 * @author Computador
 */
public interface VendedorDao {
    
    void inserir(Vendedor obj);
    void atualizar(Vendedor obj);
    void excluirId(Integer id);
    Vendedor buscarId(Integer id);
    List<Vendedor> buscarTodos();
    
}
