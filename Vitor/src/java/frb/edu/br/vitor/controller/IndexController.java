/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.controller;

import frb.edu.br.vitor.entity.Cidade;
import frb.edu.br.vitor.entity.Endereco;
import frb.edu.br.vitor.entity.Pais;
import frb.edu.br.vitor.interfaces.ICidade;
import frb.edu.br.vitor.interfaces.IEndereco;
import frb.edu.br.vitor.interfaces.IPais;
import frb.edu.br.vitor.repository.CidadeRepository;
import frb.edu.br.vitor.repository.EnderecoRepository;
import frb.edu.br.vitor.repository.PaisRepository;
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
@ManagedBean(name = "IndexController")
@ViewScoped
public class IndexController implements Serializable {

    private Endereco endereco;
    private List<Endereco> enderecos = null;
    private IEndereco enderecoRepository = new EnderecoRepository();

    private Cidade cidade;
    private List<Cidade> cidades = null;
    private ICidade cidadeRepository = new CidadeRepository();

    private Pais pais;
    private List<Pais> paises = null;
    private IPais paisRepository = new PaisRepository();

    /**
     * Creates a new instance of EnderecoController
     */
    public IndexController() {
    }

    public List<Cidade> getCidades() {
        cidades = cidadeRepository.findAllFromIndex();
        return cidades;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public List<Endereco> getEnderecos() {
        enderecos = enderecoRepository.findAllFromIndex();
        return enderecos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Pais> getPaises() {
        paises = paisRepository.findAllFromIndex();
        return paises;
    }

    public Pais getPais() {
        return pais;
    }

}
