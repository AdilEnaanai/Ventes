package univ.fac.gcommerce.services;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import univ.fac.gcommerce.entities.CategorieStats;
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

    public Page<Produit> getAllProduits(int page, int size) {
        PageRequest pagination=PageRequest.of(page,size, Sort.by("designation").ascending());
        return produitRepository.findAll(pagination);
    }

    public Produit getProduitById(UUID id) {
        return produitRepository.findById(id).orElse(null);
    }

    public boolean deleteProduitById(UUID id) {
        produitRepository.deleteById(id);
        return !produitRepository.existsById(id);
    }

    public List<CategorieStats> compterProduitsParCategorie() {
       return  produitRepository.compterProduitsParCategorie();
    }
}
