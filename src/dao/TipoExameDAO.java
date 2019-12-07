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
import vo.TipoExame;

/**
 *
 * @author robson
 */
public class TipoExameDAO extends Conexao{

    public TipoExameDAO() {
        super();
    }
    
    
    public void insere(TipoExame tipoExame){
     String sql = "insert into tipo_exame (tipo) values(?)";
     try{
         PreparedStatement ps = getCon().prepareStatement(sql);
         ps.setString(1, tipoExame.getTipo());
         ps.execute();
     }catch (SQLException e){
         JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
     }
    }
    
    public void atualiza(TipoExame tipoExame){
        String sql ="update tipo_exame set tipo=? where id=?";
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, tipoExame.getTipo());
            ps.setInt(2, tipoExame.getId());
           ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
    public void excluir(int tipoExameId){
        String sql = "delete from tipo_exame where id=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, tipoExameId);
            ps.execute();            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
     public ArrayList<TipoExame> pesquisa(){
        String sql = "select * from tipo_exame";
        ArrayList lista = new ArrayList();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                TipoExame registro = new TipoExame();
                registro.setId(rs.getInt("id"));
                registro.setTipo(rs.getString("tipo"));
                lista.add(registro);
            }           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return lista;
    }
    
     
     public TipoExame localiza(int tipoExameId){
        String sql = "select * from tipo_exame where id ='" + tipoExameId +"'";
        TipoExame registro = new TipoExame();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                registro.setTipo(rs.getString("tipo"));
                registro.setId(rs.getInt("id"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return registro;
    }
    
}
