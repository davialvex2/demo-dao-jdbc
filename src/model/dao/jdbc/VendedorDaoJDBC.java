/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.jdbc;

import java.sql.Connection;
import db.DB;
import db.DbException;
import entidades.Departamento;
import entidades.Vendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.dao.VendedorDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Computador
 */
public class VendedorDaoJDBC implements VendedorDao{
    
    private Connection conn;
    
    public VendedorDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    

    @Override
    public void inserir(Vendedor obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizar(Vendedor obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluirId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vendedor buscarId(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
        st = conn.prepareStatement("SELECT seller.*,department.Name as DepName FROM seller "
                + "INNER JOIN department ON seller.DepartmentId = department.Id "
                + "WHERE seller.Id = ?");
        
        
        st.setInt(1, id);
        rs = st.executeQuery();
        if(rs.next()){
            Departamento dep = instaciarDepartamento(rs);
            
            Vendedor vend = instaciarVendedor(rs, dep);
            
           
            return vend;
        }
        return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Vendedor> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Departamento instaciarDepartamento(ResultSet rs) throws SQLException {
        Departamento dep = new Departamento();    
            dep.setId(rs.getInt("DepartmentId"));
            dep.setNome(rs.getString("DepName"));
            return dep;
    }

    private Vendedor instaciarVendedor(ResultSet rs,  Departamento dep) throws SQLException {
            Vendedor vend = new Vendedor();
            vend.setId(rs.getInt("Id"));
            vend.setNome(rs.getString("Name"));
            vend.setEmail(rs.getString("Email"));
            vend.setBirthDate(rs.getDate("BirthDate"));
            vend.setSalarioBase(rs.getDouble("BaseSalary"));
            vend.setDepartamento(dep);
            return vend;
    }

    @Override
    public List<Vendedor> buscarDepartamento(Departamento departamento) {
        
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
        st = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
                + "FROM seller INNER JOIN department ON "
                + "seller.DepartmentId = department.Id WHERE DepartmentId = ? ORDER BY Name");
        
        
        st.setInt(1, departamento.getId());
        
        rs = st.executeQuery();
        
        List<Vendedor> lista = new ArrayList<>();
        Map<Integer, Departamento> map = new HashMap<>();
        
        while(rs.next()){
            
            Departamento dep = map.get(rs.getInt("DepartmentId"));
            
            if(dep == null){
            dep = instaciarDepartamento(rs); 
            map.put(rs.getInt("DepartmentId"), dep);
            }
            
            
            Vendedor vend = instaciarVendedor(rs, dep);
            lista.add(vend);
            }
        return lista;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
    
}
