/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giovanitrevisol.md.domain;

import com.giovanitrevisol.md.domain.enums.EstadoPagamento;
import javax.persistence.Entity;

/**
 *
 * @author Giovani Trevisol
 */
@Entity
public class PagamentoComCartao extends Pagamento{
    
    private Integer nrParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer nrParcelas, Integer id, EstadoPagamento estado, Pedido pedido) {
        super(id, estado, pedido);
        this.nrParcelas = nrParcelas;
    }

    public Integer getNrParcelas() {
        return nrParcelas;
    }

    public void setNrParcelas(Integer nrParcelas) {
        this.nrParcelas = nrParcelas;
    }
    
    
    
}
