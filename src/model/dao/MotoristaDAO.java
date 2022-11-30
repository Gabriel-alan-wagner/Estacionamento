/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Motorista;



public class MotoristaDAO {
    
    public void create(Motorista m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO motorista (nome, genero,RG,CPF,numero,email,senha)VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getGenero());
             stmt.setInt(3, m.getRG());
            stmt.setInt(4, m.getCPF());
            stmt.setInt(5, m.getNumero());
             stmt.setString(6, m.getEmail());
            stmt.setString(7, m.getSenha());
            
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Vaga salva com sucesso!");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar: " + e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Motorista> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Motorista> motoristas = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM motorista;");
            rs = stmt.executeQuery();
            while(rs.next()){
                Motorista m = new Motorista();
                m.setIdMotorista(rs.getInt("idMotorista"));
                m.setNome(rs.getString("nome"));
                m.setNumero(rs.getInt("numero"));
                m.setGenero(rs.getString("genero"));
                m.setRG(rs.getInt("RG"));
                 m.setCPF(rs.getInt("CPF"));
                  m.setEmail(rs.getString("email"));
                   m.setSenha(rs.getString("senha"));
                motoristas.add(m);
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar os dados: ", e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return motoristas;
    }
    
    public void delete(Motorista m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM motorista WHERE idMotorista=?");
            stmt.setInt(1,m.getIdMotorista());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Motorista excluído com sucesso!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public Motorista read(int idMotorista){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Motorista m = new Motorista();
        try{
            stmt = con.prepareStatement("SELECT * FROM motorista WHERE idMotorista=? LIMIT 1;");
            stmt.setInt(1, idMotorista);
            rs = stmt.executeQuery();
            if(rs != null && rs.next()){
                m.setIdMotorista(rs.getInt("idMotorista"));
                m.setNome(rs.getString("nome"));
                m.setNumero(rs.getInt("numero"));
                m.setGenero(rs.getString("genero"));
                m.setRG(rs.getInt("RG"));
                 m.setCPF(rs.getInt("CPF"));
                  m.setEmail(rs.getString("email"));
                   m.setSenha(rs.getString("senha"));
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar os dados", e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return m;
    }
    
    public void update(Motorista m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("UPDATE motorista SET nome=?, genero=?, RG=?, CPF=?,numero=?, email=?, senha=? WHERE idMotorista=?;");
            
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getGenero());
            stmt.setInt(3, m.getRG());
            stmt.setInt(4, m.getCPF());
            stmt.setInt(5, m.getNumero());
            stmt.setString(6, m.getEmail());
            stmt.setString(7, m.getSenha());
            stmt.setInt(8, m.getIdMotorista());
            stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Motorista atualizado com sucesso!");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
