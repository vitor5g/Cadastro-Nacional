/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.controller;

import frb.edu.br.vitor.entity.Cidade;
import frb.edu.br.vitor.interfaces.ICidade;
import frb.edu.br.vitor.repository.CidadeRepository;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vitor
 */
@ManagedBean(name = "CidadeController")
@ViewScoped
public class CidadeController implements Serializable {

    private Cidade cidade;
    private List<Cidade> cidades = null;

    private ICidade cidadeRepository = new CidadeRepository();

    /**
     * Creates a new instance of EnderecoController
     */
    public CidadeController() {
    }

    public List<Cidade> getCidades() {
        if (cidades == null) {
            cidades = cidadeRepository.findAll();
        }
        return cidades;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String insert() {
        cidade = new Cidade();
        return "cidadeToForm";
    }

    public void finalizaInclusao() {
        cidade.setCidade(cidade.getCidade().substring(0, 1).toUpperCase().concat(cidade.getCidade().substring(1)));
        cidadeRepository.incluir(cidade);
        cidades = null;
        cidade = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Vitor/faces/Cidade.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(EnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        return "formToEndereco";
    }

    public String finalizaDelecao() {
        Boolean retorno;
        retorno = cidadeRepository.deletar(cidade.getCidade_id());
        if (!retorno) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("Erro ao excluir a cidade " + cidade.getCidade() + " existem endereços associados a ela"));
            cidades = null;
            return "refresh";

        }
        cidades = null;
        return "refresh";
    }

    public String finalizaEdicao() {
        cidadeRepository.alterar(cidade);
        cidades = null;
        return "formToCidade";
    }
}
