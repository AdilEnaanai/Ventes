package univ.fac.gcommerce.services;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.stereotype.Service;
import univ.fac.gcommerce.entities.Produit;
import univ.fac.gcommerce.repositories.ProduitRepository;

import java.util.List;

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
}
