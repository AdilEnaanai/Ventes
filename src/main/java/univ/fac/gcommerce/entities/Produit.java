package univ.fac.gcommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
