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
import vo.Questao;

/**
 *
 * @author robson
 */
public class QuestionarioDAO extends Conexao{

    public QuestionarioDAO() {
        super();
    }
    
    
    public void insere(Questao questao){
     String sql = "insert into Questao (questao) values(?)";
     try{
         PreparedStatement ps = getCon().prepareStatement(sql);
         ps.setString(1, questao.getQuestao());
         ps.execute();
     }catch (SQLException e){
         JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
     }
    }
    
    public void atualiza(Questao questao){
        String sql ="update Questao set questao=? where id=?";
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, questao.getQuestao());
            ps.setInt(2, questao.getId());
           ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
    public void excluir(int questaoId){
        String sql = "delete from Questao where id=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, questaoId);
            ps.execute();            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
     public ArrayList<Questao> pesquisa(){
        String sql = "select * from Questao";
        ArrayList lista = new ArrayList();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Questao registro = new Questao();
                registro.setId(rs.getInt("id"));
                registro.setQuestao(rs.getString("questao"));
                lista.add(registro);
            }           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return lista;
    }
    
     
     public Questao localiza(int questaoId){
        String sql = "select * from Questao where id ='" + questaoId +"'";
        Questao registro = new Questao();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                registro.setQuestao(rs.getString("questao"));
                registro.setId(rs.getInt("id"));
                //FAZER
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return registro;
    }
    
}
