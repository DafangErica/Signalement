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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author ERICA
 */
@Entity
@Table(name = "quartier")
@NamedQueries({
    @NamedQuery(name = "Quartier.findAll", query = "SELECT q FROM Quartier q"),
    @NamedQuery(name = "Quartier.findByQuartierId", query = "SELECT q FROM Quartier q WHERE q.quartierId = :quartierId"),
    @NamedQuery(name = "Quartier.findByNomQuartier", query = "SELECT q FROM Quartier q WHERE q.nomQuartier = :nomQuartier")})
public class Quartier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "quartier_id")
    private Integer quartierId;
    @Basic(optional = false)
    @Column(name = "nom_quartier")
    private String nomQuartier;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quartierId")
    private Collection<Infrastructure> infrastructureCollection;

    public Quartier() {
    }

    public Quartier(Integer quartierId) {
        this.quartierId = quartierId;
    }

    public Quartier(Integer quartierId, String nomQuartier) {
        this.quartierId = quartierId;
        this.nomQuartier = nomQuartier;
    }

    public Integer getQuartierId() {
        return quartierId;
    }

    public void setQuartierId(Integer quartierId) {
        this.quartierId = quartierId;
    }

    public String getNomQuartier() {
        return nomQuartier;
    }

    public void setNomQuartier(String nomQuartier) {
        this.nomQuartier = nomQuartier;
    }

    public Collection<Infrastructure> getInfrastructureCollection() {
        return infrastructureCollection;
    }

    public void setInfrastructureCollection(Collection<Infrastructure> infrastructureCollection) {
        this.infrastructureCollection = infrastructureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quartierId != null ? quartierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quartier)) {
            return false;
        }
        Quartier other = (Quartier) object;
        if ((this.quartierId == null && other.quartierId != null) || (this.quartierId != null && !this.quartierId.equals(other.quartierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.signalement.entities.Quartier[ quartierId=" + quartierId + " ]";
    }
    
}
