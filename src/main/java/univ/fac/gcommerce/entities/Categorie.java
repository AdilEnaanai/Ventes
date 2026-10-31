package univ.fac.gcommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import univ.fac.gcommerce.dtos.CategorieDTO;
import univ.fac.gcommerce.dtos.ProduitDTO;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    @OneToMany(mappedBy ="categorie" )
    List<Produit> produits;

    public CategorieDTO toDTO(){
        return new CategorieDTO(id,nom);
    }
}
