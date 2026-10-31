package univ.fac.gcommerce.controllers;

import org.springframework.web.bind.annotation.*;
import univ.fac.gcommerce.dtos.CategorieDTO;
import univ.fac.gcommerce.dtos.ProduitDTO;
import univ.fac.gcommerce.entities.Categorie;
import univ.fac.gcommerce.entities.Produit;
import univ.fac.gcommerce.services.CategorieService;

import java.util.List;

@RestController
@RequestMapping("ventes")
public class CategorieController {
    final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("categories")
    public List<CategorieDTO> getAllCategories(){
        return categorieService.getAllCategories();
    }

    @PostMapping("categories")
    public  CategorieDTO addCategorie(@RequestBody Categorie categorie){
        return categorieService.addCategorie(categorie).toDTO();
    }

    @PostMapping("categories/{nomcat}/produits")
    public ProduitDTO addProduit(@PathVariable String nomcat,@RequestBody Produit produit){
        return categorieService.addProduit(nomcat,produit).toDTO();
    }

    @GetMapping("categories/{nomcat}/produits")
    public List<ProduitDTO> getAllProduits(@PathVariable String nomcat){
        return categorieService.getAllProduits(nomcat);
    }

    @DeleteMapping("categories/{id}")
    public boolean deleteCategorieById(@PathVariable Long id){
        return categorieService.deleteCategorieById(id);
    }
}
