/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.controller;

import frb.edu.br.vitor.entity.Pais;
import frb.edu.br.vitor.interfaces.IPais;
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

/**
 *
 * @author Vitor
 */
@ManagedBean(name = "PaisController")
@ViewScoped
public class PaisController implements Serializable {

    private Pais pais;
    private List<Pais> paises = null;

    private IPais paisRepository = new PaisRepository();

    /**
     * Creates a new instance of EnderecoController
     */
    public PaisController() {
    }

    public List<Pais> getPaises() {
        if (paises == null) {
            paises = paisRepository.findAll();
        }
        return paises;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String insert() {
        pais = new Pais();
        return "paisToForm";
    }

    public void finalizaInclusao() {
        pais.setPais(pais.getPais().substring(0,1).toUpperCase().concat(pais.getPais().substring(1)));
        paisRepository.incluir(pais);
        paises = null;
        pais = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Vitor/faces/Pais.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(EnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String finalizaDelecao() {
        Boolean retorno;
        retorno = paisRepository.deletar(pais.getPais_id());
        if (!retorno) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("Erro ao excluir o país " + pais.getPais() + " existem cidades associadas a ele!!"));

            paises = null;
            return "refresh";

        }
        paises = null;
        return "refresh";
    }

    public String finalizaEdicao() {
        paisRepository.alterar(pais);
        paises = null;
        return "formToPais";
    }
}
