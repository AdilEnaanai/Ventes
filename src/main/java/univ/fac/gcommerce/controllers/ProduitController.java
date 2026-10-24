package univ.fac.gcommerce.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import univ.fac.gcommerce.entities.Produit;
import univ.fac.gcommerce.services.ProduitService;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("ventes")
public class ProduitController {
    final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @Operation(description = "Renvoyer tous les produits")
    @PostMapping("produits")
    public Produit addProduit(@Parameter(description = "Introduire un nouveau produit") @RequestBody Produit produit){
        return this.produitService.addProduit(produit);
    }
    @GetMapping("produits")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }
    @GetMapping("produits/{id}")
    public Produit getProduitById(@PathVariable UUID id){
        return new Produit();
    }
    @DeleteMapping("produits/{id}")
    public boolean deleteProduit(@PathVariable UUID id){
        return true;
    }

}
