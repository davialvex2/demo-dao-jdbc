/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.jdbc;

import java.sql.Connection;
import entidades.Departamento;
import java.util.List;
import model.dao.DepartamentoDao;
import java.sql.Connection;
import db.DB;
import db.DbException;
import entidades.Departamento;
import entidades.Vendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Computador
 */
public class DepartamentoDaoJDBC implements DepartamentoDao{
    
    private Connection conn;
    
    public DepartamentoDaoJDBC (Connection conn){
        this.conn = conn;
    }

    @Override
    public void inserir(Departamento obj) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1,obj.getNome());
            
            int linhas = st.executeUpdate();
            if(linhas > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            }
            else{
                throw new DbException("Não foi inserido nenhum usuário");
                }
            }
            catch(SQLException e){
                    throw new DbException(e.getMessage());
            }
        finally{
            DB.closeStatement(st);
        }
        
        
    }

    @Override
    public void atualizar(Departamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluirId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Departamento buscarId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Departamento> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
