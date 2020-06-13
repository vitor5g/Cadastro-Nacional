/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.interfaces;

import frb.edu.br.vitor.entity.Cidade;
import java.util.List;

/**
 *
 * @author Vitor
 */
public interface ICidade {

    boolean incluir(Cidade cidade);

    boolean alterar(Cidade cidade);

    boolean deletar(int id);

    Cidade findById(int id);

    List<Cidade> findAll();

    List<Cidade> findAllFromIndex();
}
