/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.giovanitrevisol.md.resources;

import com.giovanitrevisol.md.domain.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Giovani Trevisol
 */

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @RequestMapping (method = RequestMethod.GET)
    public List<Categoria> listar(){
        
        Categoria cat = new Categoria(1, "Informática");
        Categoria cat2 = new Categoria(2, "Escritório");
        
        List<Categoria> lista = new ArrayList<>();
        lista.add(cat);
        lista.add(cat2);
        
        return lista;
        
    
    }
    
}
