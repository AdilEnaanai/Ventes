package univ.fac.gcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import univ.fac.gcommerce.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Categorie findCategorieByNom(String nom);
}
