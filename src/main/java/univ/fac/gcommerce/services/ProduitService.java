package univ.fac.gcommerce.services;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.stereotype.Service;
import univ.fac.gcommerce.entities.Produit;
import univ.fac.gcommerce.repositories.ProduitRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProduitService {
    final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit addProduit( Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(UUID id) {
        return produitRepository.findById(id).orElse(null);
    }

    public boolean deleteProduitById(UUID id) {
        produitRepository.deleteById(id);
        return !produitRepository.existsById(id);
    }
}
