package univ.fac.gcommerce.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import univ.fac.gcommerce.dtos.ProduitDTO;
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


    @GetMapping("produits")
    public List<ProduitDTO> getAllProduits(){
        return produitService.getAllProduits().stream().map(Produit::toDTO).toList();
    }
    @GetMapping("produits/{id}")
    public ProduitDTO getProduitById(@PathVariable UUID id){
        return produitService.getProduitById(id).toDTO();
    }
    @DeleteMapping("produits/{id}")
    public boolean deleteProduit(@PathVariable UUID id){
        return produitService.deleteProduitById(id);
    }

}
