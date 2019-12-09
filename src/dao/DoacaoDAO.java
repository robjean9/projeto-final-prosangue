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
import vo.Doacao;
import vo.Doador;

/**
 *
 * @author robson
 */
public class DoacaoDAO extends Conexao{

    public DoacaoDAO() {
        super();
    }
    
    
    public void insere(Doador doador){
     String sql = "insert into Doador(nome, endereco, nascimento, nome_mae, nome_pai, cpf) values(?,?,?,?,?,?)";
     try{
         PreparedStatement ps = getCon().prepareStatement(sql);
         ps.setString(1, doador.getNome());
         ps.setString(2, doador.getEndereco());
         ps.setDate(3, new Date(doador.getDataNascimento().getTime()));
         ps.setString(4, doador.getNomeMae());
         ps.setString(5, doador.getNomePai());
         ps.setString(6, doador.getCpf());
         ps.execute();
     }catch (SQLException e){
         JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
     }
    }
    
    public void atualiza(Doador doador){
        String sql ="update Doador set nome=?, endereco=?, nascimento=?, nome_mae=?, nome_pai=?, cpf=? where id=?";
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, doador.getNome());
            ps.setString(2, doador.getEndereco());
            ps.setDate(3, new Date(doador.getDataNascimento().getTime()));
            ps.setString(4, doador.getNomeMae());
            ps.setString(5, doador.getNomePai());
            ps.setString(6, doador.getCpf());
            ps.setInt(7, doador.getId());
           ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
    public void excluir(int doadorId){
        String sql = "delete from Doador where id=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, doadorId);
            ps.execute();            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
     public ArrayList<Doador> pesquisa(){
        String sql = "select d.nome AS nome_doador, d.cpf AS cpf_doador, d.nascimento AS nascimento_doador, Doacao.*  from  doacao INNER JOIN Doador AS d ON Doacao.doador_id=d.id";
        ArrayList lista = new ArrayList();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Doacao registro = new Doacao();
                registro.setId(rs.getInt("id"));
                registro.setNomeDoador(rs.getString("nome_doador"));
                registro.setCpfDoador(rs.getString("cpf_doador"));
                registro.setDataNacDoador(new java.util.Date(rs.getDate("nascimento_doador").getTime()));
                registro.setDoadorId(rs.getInt("doador_id"));
                registro.setDataHora( new java.util.Date(rs.getDate("data_hora").getTime()));
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
