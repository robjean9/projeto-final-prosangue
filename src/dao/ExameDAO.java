/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vo.Doador;
import vo.Exame;
import vo.Questao;

/**
 *
 * @author robson
 */
public class ExameDAO extends Conexao{

    public ExameDAO() {
        super();
    }
    
    
    public void insere(Exame exame){
     String sql = "insert into exame (resultado,docao_id,tipo_exame_id) values(?,?,?)";
     try{
         PreparedStatement ps = getCon().prepareStatement(sql);
         ps.setString(1, exame.getResultado());
         ps.setInt(2, exame.getDoacaoId());
         ps.setInt(3, exame.getTipoExameId());
         ps.execute();
     }catch (SQLException e){
         JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
     }
    }
    
    public void atualiza(Exame exame){
        String sql ="update Exame set resultado=?,docao_id=?,tipo_exame_id=? where id=?";
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, exame.getResultado());
            ps.setInt(2, exame.getDoacaoId());
            ps.setInt(3, exame.getTipoExameId());
            ps.setInt(4, exame.getId());
           ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
    public void excluir(int exameId){
        String sql = "delete from Exame where id=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, exameId);
            ps.execute();            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
     public ArrayList<Exame> pesquisa(int doacaoId){
        String sql = "select * from Exame where docao_id=?";
        ArrayList lista = new ArrayList();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, doacaoId);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                Exame registro = new Exame();
                registro.setId(rs.getInt("id"));
                registro.setDoacaoId(rs.getInt("doacao_id"));
                registro.setTipoExameId(rs.getInt("tipo_exame_id"));
                registro.setResultado(rs.getString("resultado"));
                lista.add(registro);
            }           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return lista;
    }
    
     
     public Exame localiza(int id){
        String sql = "select * from Exame where id='" + id +"'";
        Exame registro = new Exame();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                registro.setId(rs.getInt("id"));
                registro.setDoacaoId(rs.getInt("doacao_id"));
                registro.setTipoExameId(rs.getInt("tipo_exame_id"));
                registro.setResultado(rs.getString("resultado"));
                //FAZER
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return registro;
    }
    
}
