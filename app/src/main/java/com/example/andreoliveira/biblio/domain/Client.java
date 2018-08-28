package com.example.andreoliveira.biblio.domain;

import java.io.Serializable;

public class Client implements Serializable
{
    private int idClient;
    private String nom;
    private String telephone;
    private String rue;
    private int nombre;
    private String quartier;
    private String ville;
    private String province;
    private String usager;
    private String motDePasse;

    public int getIdClient()
    {
        return idClient;
    }

    public void setIdClient(int idClient)
    {
        this.idClient = idClient;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getRue()
    {
        return rue;
    }

    public void setRue(String rue)
    {
        this.rue = rue;
    }

    public int getNombre()
    {
        return nombre;
    }

    public void setNombre(int nombre)
    {
        this.nombre = nombre;
    }

    public String getQuartier()
    {
        return quartier;
    }

    public void setQuartier(String quartier)
    {
        this.quartier = quartier;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getUsager()
    {
        return usager;
    }

    public void setUsager(String usager)
    {
        this.usager = usager;
    }

    public String getMotDePasse()
    {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse)
    {
        this.motDePasse = motDePasse;
    }
}
