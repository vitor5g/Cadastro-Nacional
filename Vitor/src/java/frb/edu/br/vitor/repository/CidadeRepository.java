/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.repository;

import frb.edu.br.vitor.connection.DaoUtil;
import frb.edu.br.vitor.entity.Cidade;
import frb.edu.br.vitor.entity.Endereco;
import frb.edu.br.vitor.entity.Pais;
import frb.edu.br.vitor.interfaces.ICidade;
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
public class CidadeRepository extends DaoUtil implements ICidade {

    public CidadeRepository() {
        super();
    }

    @Override
    public boolean incluir(Cidade cidade) {
        String sql = "INSERT INTO cidade (cidade, pais_id)"
                + " VALUES (?, ?)";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, cidade.getCidade());
            ps.setInt(2, cidade.getPais_id().getPais_id());
            ret = ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaisRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean alterar(Cidade cidade) {
        String sql = "UPDATE cidade SET cidade=?, pais_id=? "
                + " WHERE cidade_id=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, cidade.getCidade());
            ps.setInt(2, cidade.getPais_id().getPais_id());
            ps.setInt(3, cidade.getCidade_id());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(CidadeRepository.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(CidadeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM cidade "
                + " WHERE cidade_id = ?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(CidadeRepository.class.getName()).log(Level.SEVERE, null, e);
        }
        return ret > 0;
    }

    @Override
    public Cidade findById(int id) {
        Cidade cidade = new Cidade();

        String sql = "SELECT cidade_id, cidade, pais_id, ultima_atualizacao"
                + " FROM cidade WHERE cidade_id = ?";

        PaisRepository pais = new PaisRepository();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cidade = new Cidade(rs.getInt("cidade_id"),
                        rs.getString("cidade"),
                        pais.findById(rs.getInt("pais_id")),
                        rs.getDate("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(EnderecoRepository.class.getName()).log(Level.SEVERE, null, e);
        }

        return cidade;
    }

    @Override
    public List<Cidade> findAll() {
        List<Cidade> cidades = new LinkedList<Cidade>();
        String sql = "SELECT * FROM cidade ORDER BY cidade ";
        PaisRepository pais = new PaisRepository();

        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pais paisn = pais.findById(rs.getInt("pais_id"));
                cidades.add(new Cidade(rs.getInt("cidade_id"),
                        rs.getString("cidade"),
                        paisn,
                        rs.getDate("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CidadeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidades;
    }

    @Override
    public List<Cidade> findAllFromIndex() {
        List<Cidade> cidades = new LinkedList<Cidade>();
        String sql = "SELECT * FROM cidade ORDER BY ultima_atualizacao DESC LIMIT 5 ";
        PaisRepository pais = new PaisRepository();

        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pais paisn = pais.findById(rs.getInt("pais_id"));
                cidades.add(new Cidade(rs.getInt("cidade_id"),
                        rs.getString("cidade"),
                        paisn,
                        rs.getDate("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CidadeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidades;
    }

}
