package univ.fac.gcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import univ.fac.gcommerce.entities.Produit;

import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {
}
