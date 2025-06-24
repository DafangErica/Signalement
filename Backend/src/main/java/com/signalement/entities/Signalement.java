/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.signalement.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author ERICA
 */
@Entity
@Table(name = "signalement")
@NamedQueries({
    @NamedQuery(name = "Signalement.findAll", query = "SELECT s FROM Signalement s"),
    @NamedQuery(name = "Signalement.findBySignalementId", query = "SELECT s FROM Signalement s WHERE s.signalementId = :signalementId"),
    @NamedQuery(name = "Signalement.findByLibSignalement", query = "SELECT s FROM Signalement s WHERE s.libSignalement = :libSignalement"),
    @NamedQuery(name = "Signalement.findByDescriptionSignalement", query = "SELECT s FROM Signalement s WHERE s.descriptionSignalement = :descriptionSignalement"),
    @NamedQuery(name = "Signalement.findByLocalisation", query = "SELECT s FROM Signalement s WHERE s.localisation = :localisation"),
    @NamedQuery(name = "Signalement.findByCreatedAt", query = "SELECT s FROM Signalement s WHERE s.createdAt = :createdAt")})
public class Signalement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "signalement_id")
    private Integer signalementId;
    @Column(name = "lib_signalement")
    private String libSignalement;
    @Column(name = "description_signalement")
    private String descriptionSignalement;
    @Column(name = "localisation")
    private String localisation;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "domaine_id", referencedColumnName = "domaine_id")
    @ManyToOne(optional = false)
    private Domaine domaineId;
    @JoinColumn(name = "citoyen_id", referencedColumnName = "citoyen_id")
    @ManyToOne(optional = false)
    private Citoyen citoyenId;
    @JoinColumn(name = "infrastructure_id", referencedColumnName = "infrastructure_id")
    @ManyToOne(optional = false)
    private Infrastructure infrastructureId;

    public Signalement() {
    }

    public Signalement(Integer signalementId) {
        this.signalementId = signalementId;
    }

    public Signalement(Integer signalementId, Date createdAt) {
        this.signalementId = signalementId;
        this.createdAt = createdAt;
    }

    public Integer getSignalementId() {
        return signalementId;
    }

    public void setSignalementId(Integer signalementId) {
        this.signalementId = signalementId;
    }

    public String getLibSignalement() {
        return libSignalement;
    }

    public void setLibSignalement(String libSignalement) {
        this.libSignalement = libSignalement;
    }

    public String getDescriptionSignalement() {
        return descriptionSignalement;
    }

    public void setDescriptionSignalement(String descriptionSignalement) {
        this.descriptionSignalement = descriptionSignalement;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Domaine getDomaineId() {
        return domaineId;
    }

    public void setDomaineId(Domaine domaineId) {
        this.domaineId = domaineId;
    }

    public Citoyen getCitoyenId() {
        return citoyenId;
    }

    public void setCitoyenId(Citoyen citoyenId) {
        this.citoyenId = citoyenId;
    }

    public Infrastructure getInfrastructureId() {
        return infrastructureId;
    }

    public void setInfrastructureId(Infrastructure infrastructureId) {
        this.infrastructureId = infrastructureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (signalementId != null ? signalementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Signalement)) {
            return false;
        }
        Signalement other = (Signalement) object;
        if ((this.signalementId == null && other.signalementId != null) || (this.signalementId != null && !this.signalementId.equals(other.signalementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.signalement.entities.Signalement[ signalementId=" + signalementId + " ]";
    }
    
}
