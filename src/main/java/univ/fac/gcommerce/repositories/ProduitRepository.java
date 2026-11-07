package univ.fac.gcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import univ.fac.gcommerce.dtos.ProduitDTO;
import univ.fac.gcommerce.entities.CategorieStats;
import univ.fac.gcommerce.entities.Produit;

import java.util.List;
import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID>,
        JpaSpecificationExecutor<Produit> {
    @Query("""
    SELECT new univ.fac.gcommerce.entities.CategorieStats(p.categorie.nom, count(p), avg(p.prix))
    FROM Produit p GROUP BY 
        p.categorie.id,p.categorie.nom
        """)
    List<CategorieStats> compterProduitsParCategorie();
    List<Produit> findByCategorieNom(String nomcat);


}
