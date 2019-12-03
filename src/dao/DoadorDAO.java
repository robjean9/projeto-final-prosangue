/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vo.Doador;

/**
 *
 * @author robson
 */
public class DoadorDAO extends Conexao{

    public DoadorDAO() {
        super();
    }
    
    
    public void insere(Doador doador){
     String sql = "insert into Animal(nome, raca, idade, porte, dono) values(?,?,?,?,?)";
     try{
         PreparedStatement ps = getCon().prepareStatement(sql);
         ps.setString(1, doador.getNome());
         ps.setString(2, doador.getEndereco());
         ps.setString(3, doador.getNomeMae());
         ps.setString(4, doador.getNomePai());
         ps.setString(5, doador.getCpf());
         ps.execute();
     }catch (SQLException e){
         JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
     }
    }
    
    public void atualiza(Doador doador){
        String sql ="update Animal set nome=?, raca=?, idade=?, porte=?, dono=? where codigo=?";
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, doador.getNome());
            ps.setString(2, doador.getEndereco());
            ps.setString(3, doador.getNomeMae());
            ps.setString(4, doador.getNomePai());
            ps.setString(5, doador.getCpf());
            ps.setInt(6, doador.getId());
           ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
    public void excluir(int doadorId){
        String sql = "delete from Animal where codigo=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, doadorId);
            ps.execute();            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
     public ArrayList<Doador> pesquisa(){
        String sql = "select * from Doador";
        ArrayList lista = new ArrayList();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Doador registro = new Doador();
                registro.setId(rs.getInt("id"));
                //FAZER
                lista.add(registro);
            }           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return lista;
    }
    
     
     public Doador localiza(int doadorId){
        String sql = "select * from Doador where id ='" + doadorId +"'";
        Doador registro = new Doador();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                registro.setNome(rs.getString("nome"));
                //FAZER
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return registro;
    }
    
}
