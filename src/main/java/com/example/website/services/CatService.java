package com.example.website.services;
import java.util.Collection;
import java.util.stream.Stream;

import com.example.website.classes.categorie;

public interface CatService {

    categorie findByRoleName(String roleName);

    Collection<categorie> getAllCat();

}
