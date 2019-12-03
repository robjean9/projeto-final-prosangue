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
import vo.Usuario;

/**
 *
 * @author robson
 */
public class UsuarioDAO extends Conexao{

    public UsuarioDAO() {
        super();
    }
    
    
    public void insere(Usuario usuario){
     String sql = "insert into Usuario(nome, email, senha) values(?,?,?)";
     try{
         PreparedStatement ps = getCon().prepareStatement(sql);
         ps.setString(1, usuario.getNome());
         ps.setString(2, usuario.getEmail());
         ps.setString(3, usuario.getSenha());
         ps.execute();
     }catch (SQLException e){
         JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
     }
    }
    
     public void atualiza(Usuario usuario){
        String sql ="update Usuario set nome=?, email=?, senha=? where id=?";
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getId());
           ps.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
    
    public ArrayList<Usuario> pesquisa(){
        String sql = "select * from Usuario";
        ArrayList lista = new ArrayList();
        try{
        Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Usuario registro = new Usuario();
                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setSenha(rs.getString("senha"));
                //FAZER
                lista.add(registro);
            }           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return lista;
    }
    
     public void excluir(int usuarioId){
        String sql = "delete from Usuario where id=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, usuarioId);
            ps.execute();            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
    }
      
}
