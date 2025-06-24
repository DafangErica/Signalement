/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.signalement.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author ERICA
 */
@Entity
@Table(name = "domaine")
@NamedQueries({
    @NamedQuery(name = "Domaine.findAll", query = "SELECT d FROM Domaine d"),
    @NamedQuery(name = "Domaine.findByDomaineId", query = "SELECT d FROM Domaine d WHERE d.domaineId = :domaineId"),
    @NamedQuery(name = "Domaine.findByNomDomaine", query = "SELECT d FROM Domaine d WHERE d.nomDomaine = :nomDomaine"),
    @NamedQuery(name = "Domaine.findByMailDomaine", query = "SELECT d FROM Domaine d WHERE d.mailDomaine = :mailDomaine"),
    @NamedQuery(name = "Domaine.findByCreatedAt", query = "SELECT d FROM Domaine d WHERE d.createdAt = :createdAt")})
public class Domaine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "domaine_id")
    private Integer domaineId;
    @Basic(optional = false)
    @Column(name = "nom_domaine")
    private String nomDomaine;
    @Basic(optional = false)
    @Column(name = "mail_domaine")
    private String mailDomaine;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domaineId")
    private Collection<Inspecteur> inspecteurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domaineId")
    private Collection<Signalement> signalementCollection;

    public Domaine() {
    }

    public Domaine(Integer domaineId) {
        this.domaineId = domaineId;
    }

    public Domaine(Integer domaineId, String nomDomaine, String mailDomaine, Date createdAt) {
        this.domaineId = domaineId;
        this.nomDomaine = nomDomaine;
        this.mailDomaine = mailDomaine;
        this.createdAt = createdAt;
    }

    public Integer getDomaineId() {
        return domaineId;
    }

    public void setDomaineId(Integer domaineId) {
        this.domaineId = domaineId;
    }

    public String getNomDomaine() {
        return nomDomaine;
    }

    public void setNomDomaine(String nomDomaine) {
        this.nomDomaine = nomDomaine;
    }

    public String getMailDomaine() {
        return mailDomaine;
    }

    public void setMailDomaine(String mailDomaine) {
        this.mailDomaine = mailDomaine;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Collection<Inspecteur> getInspecteurCollection() {
        return inspecteurCollection;
    }

    public void setInspecteurCollection(Collection<Inspecteur> inspecteurCollection) {
        this.inspecteurCollection = inspecteurCollection;
    }

    public Collection<Signalement> getSignalementCollection() {
        return signalementCollection;
    }

    public void setSignalementCollection(Collection<Signalement> signalementCollection) {
        this.signalementCollection = signalementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domaineId != null ? domaineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domaine)) {
            return false;
        }
        Domaine other = (Domaine) object;
        if ((this.domaineId == null && other.domaineId != null) || (this.domaineId != null && !this.domaineId.equals(other.domaineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.signalement.entities.Domaine[ domaineId=" + domaineId + " ]";
    }
    
}
