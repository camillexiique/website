package com.example.website.services;
import java.util.Collection;
import java.util.Optional;

import com.example.website.classes.produit;

public interface ProduitService {

    Collection<produit> getAllProduits();

    Optional<produit> findProduitById(int id);

    Optional<produit> findByName(String name);

    produit saveOrUpdateProduit(produit user);

    void deleteProduit(Long id);


}
