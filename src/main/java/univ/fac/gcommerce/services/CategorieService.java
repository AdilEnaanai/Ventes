package univ.fac.gcommerce.services;

import org.springframework.stereotype.Service;
import univ.fac.gcommerce.dtos.CategorieDTO;
import univ.fac.gcommerce.dtos.ProduitDTO;
import univ.fac.gcommerce.entities.Categorie;
import univ.fac.gcommerce.entities.Produit;
import univ.fac.gcommerce.repositories.CategorieRepository;
import univ.fac.gcommerce.repositories.ProduitRepository;

import java.util.List;

@Service
public class CategorieService {
    final CategorieRepository categorieRepository;
    final ProduitRepository produitRepository;
    public CategorieService(CategorieRepository categorieRepository, ProduitRepository produitRepository) {
        this.categorieRepository = categorieRepository;
        this.produitRepository = produitRepository;
    }

    public List<CategorieDTO> getAllCategories() {
        return categorieRepository.findAll().stream().map(Categorie::toDTO).toList();
    }

    public Categorie addCategorie(Categorie categorie) {
       return categorieRepository.save(categorie);
    }

    public Produit addProduit(String nomcat, Produit produit) {
        Categorie categorie=categorieRepository.findCategorieByNom(nomcat);
        produit.setCategorie(categorie);
        return produitRepository.save(produit);
    }

    public List<ProduitDTO> getAllProduits(String nomcat) {
        return categorieRepository.findCategorieByNom(nomcat).getProduits().stream().map(Produit::toDTO).toList();
    }

    public boolean deleteCategorieById(Long id) {
        categorieRepository.deleteById(id);
        return !categorieRepository.existsById(id);
    }
}
