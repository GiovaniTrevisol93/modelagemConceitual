/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giovanitrevisol.md.Services;

import com.giovanitrevisol.md.domain.Cliente;
import com.giovanitrevisol.md.repositories.ClienteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Giovani Trevisol
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;
    
    public Cliente buscar(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new com.giovanitrevisol.md.Services.exception.ObjectNotFoundException("Objeto não encontrado! Id:"
                + id + ", Tipo: " + Cliente.class.getName()));
    }

}
