/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giovanitrevisol.md.repositories;

import com.giovanitrevisol.md.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Giovani Trevisol
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
