/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.interfaces;

import frb.edu.br.vitor.entity.Endereco;
import java.util.List;

/**
 *
 * @author Vitor
 */
public interface IEndereco {

    boolean incluir(Endereco endereco);

    boolean alterar(Endereco endereco);

    boolean deletar(int id);

    Endereco findById(int id);

    List<Endereco> findAll();

    List<Endereco> findAllFromIndex();

}
