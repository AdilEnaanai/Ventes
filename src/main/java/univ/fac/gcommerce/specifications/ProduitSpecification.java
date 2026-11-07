package univ.fac.gcommerce.specifications;

import org.springframework.data.jpa.domain.Specification;
import univ.fac.gcommerce.entities.Produit;

public class ProduitSpecification {
    public static Specification<Produit> designationContient(String nom){
        return (root, query, cb) ->
                cb.like(root.get("designation"),"%"+nom+"%");
    }

    public static Specification<Produit> prixInferieur(Double prix){
        return (root,query,cb)->
                cb.lessThanOrEqualTo(root.get("prix"),prix);
    }
    public static Specification<Produit> dansCategorie(String nom){
        return (root,query,cb)->
                cb.equal(root.get("categorie").get("nom"),nom);
    }
}
