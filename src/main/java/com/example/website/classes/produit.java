package com.example.website.classes;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUIT")
public class produit implements Serializable{

    private static final long serialVersionUID = 2284252532274015507L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUIT_ID", updatable = false, nullable = false)
    private int id = 0;

    @Column(name="¨PRODUIT_NAME", updatable = true, nullable = false)
    public String produit_name;

    @Column(name = "CATEGORIE_ID", updatable = false, nullable = false)
    private int id_cat;

    @Column(name="¨DESCRIPTION", updatable = true, nullable = true)
    public String desc;

    public produit(){
        super();
    }
    public produit(String produit_name){
        super();
        this.produit_name = produit_name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdcat() {
        return id_cat;
    }
    public void setIdcat(int id) {
        this.id_cat = id;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getproduit_name() {
        return produit_name;
    }
    public void setproduit_name(String produit_name) {
        this.produit_name = produit_name;
    }
    @Override
    public String toString() {
        return "Produit [id=" + id + ", name=" + produit_name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        produit other = (produit) obj;
        if (id != other.id)
            return false;
        if (produit_name == null) {
            if (other.produit_name != null)
                return false;
        } else if (!produit_name.equals(other.produit_name))
            return false;
        return true;
    }

    public int compareTo(produit produit){
        return this.produit_name.compareTo(produit.getproduit_name());

    }
}
