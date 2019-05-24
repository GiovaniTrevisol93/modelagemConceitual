/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giovanitrevisol.md.repositories;

import com.giovanitrevisol.md.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Giovani Trevisol
 */

@Repository
public interface itemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
    
    
}
