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
import vo.Doacao;

/**
 *
 * @author robson
 */
public class DoacaoDAO extends Conexao {
    
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat dateHourFormat;

    public DoacaoDAO() {
        super();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateHourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public void insere(Doacao doacao) {
        String sql = "insert into doacao(data_hora, doador_id) values(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, dateFormat.format(doacao.getDataHora()));
            ps.setInt(2, doacao.getDoadorId());
            
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }

    public void atualiza(Doacao doacao) {
        String sql = "update doacao set data_hora=?, doador_id=? where id = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, dateFormat.format(doacao.getDataHora()));
            ps.setInt(2, doacao.getDoadorId());
            ps.setInt(3, doacao.getId());

            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }

    public void excluir(int doacaoId) {
        String sql = "delete from doacao where id=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, doacaoId);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
    }

    public ArrayList<Doacao> pesquisa() throws ParseException {
        String sql = "select d.nome as nome_doador\n"
                + "        , d.cpf as cpf_doador\n"
                + "        , d.nascimento as nascimento_doador\n"
                + "        , doacao.*\n"
                + "     from doacao\n"
                + "    inner join doador as d\n"
                + "       on doacao.doador_id = d.id\n";
        ArrayList lista = new ArrayList();
        try {
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Doacao registro = new Doacao();
                registro.setId(rs.getInt("id"));
                registro.setNomeDoador(rs.getString("nome_doador"));
                registro.setCpfDoador(rs.getString("cpf_doador"));
                registro.setDataNacDoador(dateFormat.parse(rs.getString("nascimento_doador")));
                registro.setDoadorId(rs.getInt("doador_id"));
                registro.setDataHora(dateHourFormat.parse(rs.getString("data_hora")));
                //FAZER
                lista.add(registro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
        return lista;
    }

    public Doacao localiza(int doacaoId) throws ParseException {
        String sql = "select * from doacao where id ='" + doacaoId + "'";
        Doacao registro = new Doacao();
        try {
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                registro.setId(rs.getInt("id"));
                registro.setDataHora(dateFormat.parse(rs.getString("data_hora")));
                registro.setDoadorId(rs.getInt("doador_id"));
                //FAZER
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + e.getMessage());
        }
        return registro;
    }

}
