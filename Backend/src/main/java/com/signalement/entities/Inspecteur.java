/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.signalement.entities;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 *
 * @author ERICA
 */
@Entity
@Table(name = "inspecteur")
@NamedQueries({
    @NamedQuery(name = "Inspecteur.findAll", query = "SELECT i FROM Inspecteur i"),
    @NamedQuery(name = "Inspecteur.findByInspecteurId", query = "SELECT i FROM Inspecteur i WHERE i.inspecteurId = :inspecteurId"),
    @NamedQuery(name = "Inspecteur.findByNomInspecteur", query = "SELECT i FROM Inspecteur i WHERE i.nomInspecteur = :nomInspecteur"),
    @NamedQuery(name = "Inspecteur.findByTelInspecteur", query = "SELECT i FROM Inspecteur i WHERE i.telInspecteur = :telInspecteur"),
    @NamedQuery(name = "Inspecteur.findByMailInspecteur", query = "SELECT i FROM Inspecteur i WHERE i.mailInspecteur = :mailInspecteur"),
    @NamedQuery(name = "Inspecteur.findByPwdInspecteur", query = "SELECT i FROM Inspecteur i WHERE i.pwdInspecteur = :pwdInspecteur")})
public class Inspecteur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inspecteur_id")
    private Integer inspecteurId;

    @Column(name = "nom_inspecteur")
    private String nomInspecteur;

    @Column(name = "tel_inspecteur")
    private String telInspecteur;

    @Column(name = "mail_inspecteur")
    private String mailInspecteur;

    @Column(name = "pwd_inspecteur")
    private String pwdInspecteur;

    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    @ManyToOne(optional = false)
    private Admin adminId;

    @JoinColumn(name = "domaine_id", referencedColumnName = "domaine_id")
    @ManyToOne(optional = false)
    private Domaine domaineId;

    @Version
    @Column(name = "version")
    private Integer version;

    public Inspecteur() {
    }

    public Inspecteur(Integer inspecteurId) {
        this.inspecteurId = inspecteurId;
    }

    public Integer getInspecteurId() {
        return inspecteurId;
    }

    public void setInspecteurId(Integer inspecteurId) {
        this.inspecteurId = inspecteurId;
    }

    public String getNomInspecteur() {
        return nomInspecteur;
    }

    public void setNomInspecteur(String nomInspecteur) {
        this.nomInspecteur = nomInspecteur;
    }

    public String getTelInspecteur() {
        return telInspecteur;
    }

    public void setTelInspecteur(String telInspecteur) {
        this.telInspecteur = telInspecteur;
    }

    public String getMailInspecteur() {
        return mailInspecteur;
    }

    public void setMailInspecteur(String mailInspecteur) {
        this.mailInspecteur = mailInspecteur;
    }

    public String getPwdInspecteur() {
        return pwdInspecteur;
    }

    public void setPwdInspecteur(String pwdInspecteur) {
        this.pwdInspecteur = pwdInspecteur;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    public Domaine getDomaineId() {
        return domaineId;
    }

    public void setDomaineId(Domaine domaineId) {
        this.domaineId = domaineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inspecteurId != null ? inspecteurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Inspecteur)) {
            return false;
        }
        Inspecteur other = (Inspecteur) object;
        return (this.inspecteurId != null || other.inspecteurId == null) &&
               (this.inspecteurId == null || this.inspecteurId.equals(other.inspecteurId));
    }

    @Override
    public String toString() {
        return "com.signalement.entities.Inspecteur[ inspecteurId=" + inspecteurId + " ]";
    }
}
