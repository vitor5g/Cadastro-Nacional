/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frb.edu.br.vitor.interfaces;

import frb.edu.br.vitor.entity.Pais;
import java.util.List;

/**
 *
 * @author Vitor
 */
public interface IPais {

    boolean incluir(Pais pais);

    boolean alterar(Pais pais);

    boolean deletar(int id);

    Pais findById(int id);

    List<Pais> findAll();

    List<Pais> findAllFromIndex();
}
