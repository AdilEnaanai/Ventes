package univ.fac.gcommerce.dtos;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import univ.fac.gcommerce.entities.Categorie;

import java.util.UUID;

@NoArgsConstructor @AllArgsConstructor @Data
public class ProduitDTO {
    UUID id;
    String designation;
    double prix;
    int quantite;
    public CategorieDTO categorie;
}
