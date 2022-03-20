package com.example.website.classes;
import com.example.website.classes.produit;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUIT")
public class categorie implements Serializable{

    private static final long serialVersionUID = 2284252532274015507L;
    public ArrayList<produit> produits;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORIE_ID", updatable = false, nullable = false)
    private int id;

    @Column(name="¨CATEGORIE_NAME", updatable = true, nullable = false)
    public String categorie_name;

    @Column(name="¨DESCRIPTION", updatable = true, nullable = true)
    public String desc;

    public categorie(){
        super();
    }
    public categorie(String categorie_name){
        super();
        this.categorie_name = categorie_name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getcategorie_name() {
        return categorie_name;
    }
    public void setcategorie_name(String categorie_name) {
        this.categorie_name = categorie_name;
    }
    @Override
    public String toString() {
        return "Produit [id=" + id + ", name=" + categorie_name + "]";
    }
    public void AddProduit(String name){
        produits.add(new produit(name));
        produits.get(produits.size()-1).setIdcat(this.id);
        produits.get(produits.size()-1).setId((this.id*1000000)+produits.size());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        categorie other = (categorie) obj;
        if (id != other.id)
            return false;
        if (categorie_name == null) {
            if (other.categorie_name != null)
                return false;
        } else if (!categorie_name.equals(other.categorie_name))
            return false;
        return true;
    }

    public int compareTo(categorie produit){
        return this.categorie_name.compareTo(produit.getcategorie_name());

    }
}
