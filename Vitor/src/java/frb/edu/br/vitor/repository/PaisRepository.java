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
import frb.edu.br.vitor.interfaces.IPais;
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
public class PaisRepository extends DaoUtil implements IPais {

    public PaisRepository() {
        super();
    }

    @Override
    public boolean incluir(Pais pais) {
        String sql = "INSERT INTO pais (pais)"
                + " VALUES (?)";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, pais.getPais());
            ret = ps.executeUpdate();
            ps.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaisRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean alterar(Pais pais) {
        String sql = "UPDATE pais SET pais = ? "
                + " WHERE pais_id = ?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, pais.getPais());
            ps.setInt(2, pais.getPais_id());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(PaisRepository.class.getName()).log(Level.SEVERE, null, e);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM pais "
                + " WHERE pais_id = ?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(PaisRepository.class.getName()).log(Level.SEVERE, null, e);
        }
        return ret > 0;
    }

    @Override
    public Pais findById(int id) {
        Pais pais = new Pais();

        String sql = "SELECT pais_id, pais, ultima_atualizacao"
                + " FROM pais WHERE pais_id = ?";

        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pais = new Pais(rs.getInt("pais_id"),
                        rs.getString("pais"),
                        rs.getDate("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(PaisRepository.class.getName()).log(Level.SEVERE, null, e);
        }

        return pais;
    }

    @Override
    public List<Pais> findAll() {
        List<Pais> paises = new LinkedList<Pais>();
        String sql = "SELECT * FROM pais ";

        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paises.add(new Pais(rs.getInt("pais_id"),
                        rs.getString("pais"),
                        rs.getDate("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaisRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return paises;
    }

    @Override
    public List<Pais> findAllFromIndex() {
        List<Pais> paises = new LinkedList<Pais>();
        String sql = "SELECT * FROM pais ORDER BY ultima_atualizacao DESC LIMIT 5 ";

        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paises.add(new Pais(rs.getInt("pais_id"),
                        rs.getString("pais"),
                        rs.getDate("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaisRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return paises;
    }

}
