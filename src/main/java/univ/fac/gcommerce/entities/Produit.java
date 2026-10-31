package univ.fac.gcommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import univ.fac.gcommerce.dtos.ProduitDTO;

import java.util.UUID;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String designation;
    double prix;
    int quantite;
    @ManyToOne()
    Categorie categorie;

    public ProduitDTO toDTO(){
        return new ProduitDTO(id,designation,prix,quantite,categorie.toDTO());
    }
}
