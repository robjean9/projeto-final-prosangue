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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vo.Doador;

/**
 *
 * @author robson
 */
public class DoadorDAO extends Conexao {

    private SimpleDateFormat dateFormat;

    public DoadorDAO() {
        super();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void insere(Doador doador) {
        String sql = "insert into Doador(nome, endereco, nascimento, nome_mae, nome_pai, cpf) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, doador.getNome());
            ps.setString(2, doador.getEndereco());
            ps.setString(3, dateFormat.format(doador.getDataNascimento()));
            ps.setString(4, doador.getNomeMae());
            ps.setString(5, doador.getNomePai());
            ps.setString(6, doador.getCpf());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }

    public void atualiza(Doador doador) {
        String sql = "update Doador set nome=?, endereco=?, nascimento=?, nome_mae=?, nome_pai=?, cpf=? where id=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, doador.getNome());
            ps.setString(2, doador.getEndereco());
            ps.setString(3, dateFormat.format(doador.getDataNascimento()));
            ps.setString(4, doador.getNomeMae());
            ps.setString(5, doador.getNomePai());
            ps.setString(6, doador.getCpf());
            ps.setInt(7, doador.getId());
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }

    public void excluir(int doadorId) {
        String sql = "delete from Doador where id=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, doadorId);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }

    public ArrayList<Doador> pesquisa() throws ParseException {
        String sql = "select * from Doador";
        ArrayList lista = new ArrayList();
        try {
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Doador registro = new Doador();
                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setNomeMae(rs.getString("nome_mae"));
                registro.setNomePai(rs.getString("nome_pai"));
                registro.setCpf(rs.getString("cpf"));
                registro.setDataNascimento(dateFormat.parse(rs.getString("nascimento")));

                //FAZER
                lista.add(registro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
        return lista;
    }

    public Doador localiza(int doadorId) throws ParseException {
        String sql = "select * from Doador where id ='" + doadorId + "'";
        Doador registro = new Doador();
        try {
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                registro.setId(rs.getInt("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setNomeMae(rs.getString("nome_mae"));
                registro.setNomePai(rs.getString("nome_pai"));
                registro.setCpf(rs.getString("cpf"));
                registro.setDataNascimento(dateFormat.parse(rs.getString("nascimento")));
                //FAZER
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
        return registro;
    }

}
