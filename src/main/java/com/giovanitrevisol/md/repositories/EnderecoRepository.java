/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giovanitrevisol.md.repositories;

import com.giovanitrevisol.md.domain.Cliente;
import com.giovanitrevisol.md.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Giovani Trevisol
 */

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
    
    
}
