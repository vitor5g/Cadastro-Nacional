/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.repository;

import frb.edu.br.vitor.connection.DaoUtil;
import frb.edu.br.vitor.entity.Cidade;
import frb.edu.br.vitor.entity.Endereco;
import frb.edu.br.vitor.interfaces.IEndereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vitor
 */
public class EnderecoRepository extends DaoUtil implements IEndereco {

    public EnderecoRepository() {
        super();
    }

    @Override
    public boolean incluir(Endereco endereco) {
        String sql = "INSERT INTO endereco (endereco, endereco2, bairro, cidade_id, cep, telefone)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, endereco.getEndereco());
            ps.setString(2, endereco.getEndereco2());
            ps.setString(3, endereco.getBairro());
            ps.setInt(4, endereco.getCidade_id().getCidade_id());
            ps.setString(5, endereco.getCep());
            ps.setString(6, endereco.getTelefone());
            ret = ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnderecoRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean alterar(Endereco endereco) {
        String sql = "UPDATE endereco SET endereco=?, endereco2=?, bairro=?, cidade_id=?, cep=?, telefone=? "
                + " WHERE endereco_id=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, endereco.getEndereco());
            ps.setString(2, endereco.getEndereco2());
            ps.setString(3, endereco.getBairro());
            ps.setInt(4, endereco.getCidade_id().getCidade_id());
            ps.setString(5, endereco.getCep());
            ps.setString(6, endereco.getTelefone());
            ps.setInt(7, endereco.getEndereco_id());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(EnderecoRepository.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM endereco "
                + " WHERE endereco_id = ?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(EnderecoRepository.class.getName()).log(Level.SEVERE, null, e);
        }
        return ret > 0;
    }

    @Override
    public Endereco findById(int id) {
        Endereco endereco = new Endereco();

        String sql = "SELECT endereco_id, endereco, endereco2, bairro, cidade_id, cep, telefone, ultima_atualizacao"
                + " FROM endereco WHERE endereco_id = ?";

        CidadeRepository cidade = new CidadeRepository();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                endereco = new Endereco(rs.getInt("endereco_id"),
                        rs.getString("endereco"),
                        rs.getString("endereco2"),
                        rs.getString("bairro"),
                        cidade.findById(rs.getInt("cidade_id")),
                        rs.getString("cep"),
                        rs.getString("telefone"),
                        rs.getDate("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(EnderecoRepository.class.getName()).log(Level.SEVERE, null, e);
        }

        return endereco;
    }

    @Override
    public List<Endereco> findAll() {
        List<Endereco> ends = new LinkedList<Endereco>();
        String sql = "SELECT * FROM endereco ";
        CidadeRepository city = new CidadeRepository();

        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade cidade = city.findById(rs.getInt("cidade_id"));
                ends.add(new Endereco(rs.getInt("endereco_id"),
                        rs.getString("endereco"),
                        rs.getString("endereco2"),
                        rs.getString("bairro"),
                        cidade,
                        rs.getString("cep"),
                        rs.getString("telefone"),
                        rs.getDate("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ends;
    }

    @Override
    public List<Endereco> findAllFromIndex() {
        List<Endereco> ends = new LinkedList<Endereco>();
        String sql = "SELECT * FROM endereco ORDER BY ultima_atualizacao DESC LIMIT 5 ";
        CidadeRepository city = new CidadeRepository();

        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade cidade = city.findById(rs.getInt("cidade_id"));
                ends.add(new Endereco(rs.getInt("endereco_id"),
                        rs.getString("endereco"),
                        rs.getString("endereco2"),
                        rs.getString("bairro"),
                        cidade,
                        rs.getString("cep"),
                        rs.getString("telefone"),
                        rs.getDate("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ends;
    }
}
