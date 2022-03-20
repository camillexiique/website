package com.example.website.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.website.classes.categorie;
import com.example.website.classes.produit;

@Service
public class ProduitServiceImpl implements ProduitService {

    private static final Logger logger = LoggerFactory.getLogger(ProduitServiceImpl.class);
    private produit ProduitRepository;
    private categorie catRepository;

    public ProduitServiceImpl() {
        super();
    }

    @Autowired
    public ProduitServiceImpl(produit Produit, categorie catRepository) {
        super();
        this.ProduitRepository = Produit;
        this.catRepository = catRepository;
    }


    public Optional<produit> findByName(String name) {

        Optional<produit> ProduitFound = ProduitRepository.findByName(name);

        return ProduitFound;
    }

    @Override
    public Collection<produit> getAllProduits() {
        return IteratorUtils.toList(ProduitRepository.findAll().iterator());
    }

    @Override
    public Optional<produit> findProduitById(int id){

        Optional<produit> ProduitFound = ProduitRepository.findById(id);

        return ProduitFound;
    }


    public produit saveOrUpdateProduit(produit produit){

            if(produit.getId() == 0) {//pas d'Id --> création d'un user
                addProduitCat(produit);
            } else {//sinon, mise à jour d'un user

                Optional<produit> produitFromDB = findProduitById(produit.getId());

                updateProduitCat(produit);//On extrait le rôle en cas de mise à jour
            }
            produit result = ProduitRepository.save(produit);
            return  result;

    }

    @Override

    public void deleteProduit(Long id){

            ProduitRepository.deleteById(id);

    }




    private void addProduitCat(produit Produit) {
        Set<categorie> categories= new HashSet<>();
        categorie CatProd = new categorie("ROLE_USER");//initialisation du rôle ROLE_USER
        categories.add(CatProd);

        int catFromDB = extractRole_Java8(categories, catRepository.getAllCat());
        Produit.setIdcat(catFromDB);
    }

    private void updateProduitCat(produit produit) {

        int catFromDB = extractRole_Java8(produit.getIdcat(), catRepository.getAllCat());

        produit.setIdcat(catFromDB);
    }

    private Set<categorie> extractRole_Java8(Set<categorie> rolesSetFromUser, Stream<categorie> roleStreamFromDB) {
        // Collect UI role names
        Set<String> uiRoleNames = rolesSetFromUser.stream()
                .map(categorie::getcategorie_name)
                .collect(Collectors.toCollection(HashSet::new));
        // Filter DB roles
        return roleStreamFromDB
                .filter(role -> uiRoleNames.contains(role.getcategorie_name()))
                .collect(Collectors.toSet());
    }



    @SuppressWarnings("unused")
    private Set<produit>  extractRole_BeforeJava8(Set<produit> catSetFromProduit, Collection<produit> rolesFromDB) {
        Set<produit> rolesToAdd = new HashSet<>();
        for(produit catFromProduit:catSetFromProduit){
            for(produit roleFromDB:rolesFromDB){
                if(roleFromDB.compareTo(catFromProduit)==0){
                    rolesToAdd.add(roleFromDB);
                    break;
                }
            }
        }
        return rolesToAdd;
    }
}