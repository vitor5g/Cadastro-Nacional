/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.entity;

import java.util.Date;

/**
 *
 * @author Vitor
 */
public class Cidade {

    private int cidade_id;
    private String cidade;
    private Pais pais_id;
    private Date ultima_atualizacao;

    public Cidade() {
        pais_id = new Pais();

    }

    public Cidade(int cidade_id, String cidade, Pais pais_id, Date ultima_atualizacao) {
        this.cidade_id = cidade_id;
        this.cidade = cidade;
        this.pais_id = pais_id;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public int getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(int cidade_id) {
        this.cidade_id = cidade_id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pais getPais_id() {
        return pais_id;
    }

    public void setPais_id(Pais pais_id) {
        this.pais_id = pais_id;
    }

    public Date getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Date ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }

}
