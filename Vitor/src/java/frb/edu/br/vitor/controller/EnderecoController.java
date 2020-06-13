/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.controller;

import frb.edu.br.vitor.entity.Endereco;
import frb.edu.br.vitor.interfaces.IEndereco;
import frb.edu.br.vitor.repository.EnderecoRepository;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
@ManagedBean(name = "EnderecoController")
@ViewScoped
public class EnderecoController implements Serializable {

    private Endereco endereco;
    private List<Endereco> enderecos = null;

    private IEndereco enderecoRepository = new EnderecoRepository();

    /**
     * Creates a new instance of EnderecoController
     */
    public EnderecoController() {
    }

    public List<Endereco> getEnderecos() {
        if (enderecos == null) {
            enderecos = enderecoRepository.findAll();
        }
        return enderecos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String insert() {
        endereco = new Endereco();
        return "enderecoToForm";
    }

    public void finalizaInclusao() {
        
        enderecoRepository.incluir(endereco);
        enderecos = null;
        endereco = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Vitor/faces/Endereco.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(EnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        return "formToEndereco";
    }

    public String finalizaDelecao() {
        Boolean retorno;
        retorno = enderecoRepository.deletar(endereco.getEndereco_id());
        if (!retorno) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("Erro ao excluir o endereço"));

            enderecos = null;
            return "refresh";

        }
        enderecos = null;
        return "refresh";
    }

    public String finalizaEdicao() {
        enderecoRepository.alterar(endereco);
        enderecos = null;
        return "formToEndereco";
    }
}
