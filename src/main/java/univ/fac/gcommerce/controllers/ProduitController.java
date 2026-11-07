package univ.fac.gcommerce.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import univ.fac.gcommerce.dtos.ProduitDTO;
import univ.fac.gcommerce.entities.CategorieStats;
import univ.fac.gcommerce.entities.Produit;
import univ.fac.gcommerce.repositories.ProduitRepository;
import univ.fac.gcommerce.services.ProduitService;
import univ.fac.gcommerce.specifications.ProduitSpecification;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("ventes")
public class ProduitController {
    final ProduitService produitService;
    private final ProduitRepository produitRepository;

    public ProduitController(ProduitService produitService, ProduitRepository produitRepository) {
        this.produitService = produitService;
        this.produitRepository = produitRepository;
    }

    @Operation(description = "Renvoyer tous les produits")


    @GetMapping("produits")
    public List<ProduitDTO> getAllProduits(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size){
        return produitService.getAllProduits(page, size).stream().map(Produit::toDTO).toList();
    }
    @GetMapping("produits/{id}")
    public ProduitDTO getProduitById(@PathVariable UUID id){
        return produitService.getProduitById(id).toDTO();
    }
    @DeleteMapping("produits/{id}")
    public boolean deleteProduit(@PathVariable UUID id){
        return produitService.deleteProduitById(id);
    }

    @GetMapping("stats")
    public List<CategorieStats> stats(){
        return produitService.compterProduitsParCategorie();
    }

    @GetMapping("search")
    public List<ProduitDTO> rechercher(
            @RequestParam(required = false) String designation,
            @RequestParam(required = false) Double prixMax,
            @RequestParam(required = false) String categorieNom
    ){
        Specification<Produit> spec=Specification.unrestricted();
        if (designation!=null && !designation.isBlank()){
            spec=spec.and(ProduitSpecification.designationContient(designation));
        }
        if (prixMax!=null){
            spec=spec.and(ProduitSpecification.prixInferieur(prixMax));
        }
        if (categorieNom!=null){
            spec=spec.and(ProduitSpecification.dansCategorie(categorieNom));
        }
        return produitRepository.findAll(spec).stream().map(Produit::toDTO).toList();
    }
}
