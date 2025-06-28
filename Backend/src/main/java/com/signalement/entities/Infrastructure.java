/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.signalement.entities;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author ERICA
 */
@Entity
@Table(name = "infrastructure")
@NamedQueries({
    @NamedQuery(name = "Infrastructure.findAll", query = "SELECT i FROM Infrastructure i"),
    @NamedQuery(name = "Infrastructure.findByInfrastructureId", query = "SELECT i FROM Infrastructure i WHERE i.infrastructureId = :infrastructureId"),
    @NamedQuery(name = "Infrastructure.findByNomInfrastructure", query = "SELECT i FROM Infrastructure i WHERE i.nomInfrastructure = :nomInfrastructure"),
    @NamedQuery(name = "Infrastructure.findByType", query = "SELECT i FROM Infrastructure i WHERE i.type = :type"),
    @NamedQuery(name = "Infrastructure.findByEtat", query = "SELECT i FROM Infrastructure i WHERE i.etat = :etat"),
    @NamedQuery(name = "Infrastructure.findByDescriptionInfrastructure", query = "SELECT i FROM Infrastructure i WHERE i.descriptionInfrastructure = :descriptionInfrastructure")})
public class Infrastructure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "infrastructure_id")
    private Integer infrastructureId;

    @Column(name = "nom_infrastructure")
    private String nomInfrastructure;

    @Column(name = "type")
    private String type;

    @Column(name = "etat")
    private String etat;

    @Column(name = "description_infrastructure")
    private String descriptionInfrastructure;

    @JoinColumn(name = "quartier_id", referencedColumnName = "quartier_id")
    @ManyToOne(optional = false)
    private Quartier quartierId;

    public Infrastructure() {
    }

    public Infrastructure(Integer infrastructureId) {
        this.infrastructureId = infrastructureId;
    }

    public Integer getInfrastructureId() {
        return infrastructureId;
    }

    public void setInfrastructureId(Integer infrastructureId) {
        this.infrastructureId = infrastructureId;
    }

    public String getNomInfrastructure() {
        return nomInfrastructure;
    }

    public void setNomInfrastructure(String nomInfrastructure) {
        this.nomInfrastructure = nomInfrastructure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescriptionInfrastructure() {
        return descriptionInfrastructure;
    }

    public void setDescriptionInfrastructure(String descriptionInfrastructure) {
        this.descriptionInfrastructure = descriptionInfrastructure;
    }

    public Quartier getQuartierId() {
        return quartierId;
    }

    public void setQuartierId(Quartier quartierId) {
        this.quartierId = quartierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infrastructureId != null ? infrastructureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Infrastructure)) {
            return false;
        }
        Infrastructure other = (Infrastructure) object;
        return (this.infrastructureId != null || other.infrastructureId == null) &&
               (this.infrastructureId == null || this.infrastructureId.equals(other.infrastructureId));
    }

    @Override
    public String toString() {
        return "com.signalement.entities.Infrastructure[ infrastructureId=" + infrastructureId + " ]";
    }
    
}
