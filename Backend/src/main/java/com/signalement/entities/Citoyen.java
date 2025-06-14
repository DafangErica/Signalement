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
@Table(name = "citoyen")
@NamedQueries({
    @NamedQuery(name = "Citoyen.findAll", query = "SELECT c FROM Citoyen c"),
    @NamedQuery(name = "Citoyen.findByCitoyenId", query = "SELECT c FROM Citoyen c WHERE c.citoyenId = :citoyenId"),
    @NamedQuery(name = "Citoyen.findByNomCitoyen", query = "SELECT c FROM Citoyen c WHERE c.nomCitoyen = :nomCitoyen"),
    @NamedQuery(name = "Citoyen.findByMailCitoyen", query = "SELECT c FROM Citoyen c WHERE c.mailCitoyen = :mailCitoyen"),
    @NamedQuery(name = "Citoyen.findByPwdCitoyen", query = "SELECT c FROM Citoyen c WHERE c.pwdCitoyen = :pwdCitoyen"),
    @NamedQuery(name = "Citoyen.findByCreatedAt", query = "SELECT c FROM Citoyen c WHERE c.createdAt = :createdAt")})
public class Citoyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "citoyen_id")
    private Integer citoyenId;
    @Basic(optional = false)
    @Column(name = "nom_citoyen")
    private String nomCitoyen;
    @Basic(optional = false)
    @Column(name = "mail_citoyen")
    private String mailCitoyen;
    @Basic(optional = false)
    @Column(name = "pwd_citoyen")
    private String pwdCitoyen;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citoyenId")
    private Collection<Signalement> signalementCollection;

    public Citoyen() {
    }

    public Citoyen(Integer citoyenId) {
        this.citoyenId = citoyenId;
    }

    public Citoyen(Integer citoyenId, String nomCitoyen, String mailCitoyen, String pwdCitoyen, Date createdAt) {
        this.citoyenId = citoyenId;
        this.nomCitoyen = nomCitoyen;
        this.mailCitoyen = mailCitoyen;
        this.pwdCitoyen = pwdCitoyen;
        this.createdAt = createdAt;
    }

    public Integer getCitoyenId() {
        return citoyenId;
    }

    public void setCitoyenId(Integer citoyenId) {
        this.citoyenId = citoyenId;
    }

    public String getNomCitoyen() {
        return nomCitoyen;
    }

    public void setNomCitoyen(String nomCitoyen) {
        this.nomCitoyen = nomCitoyen;
    }

    public String getMailCitoyen() {
        return mailCitoyen;
    }

    public void setMailCitoyen(String mailCitoyen) {
        this.mailCitoyen = mailCitoyen;
    }

    public String getPwdCitoyen() {
        return pwdCitoyen;
    }

    public void setPwdCitoyen(String pwdCitoyen) {
        this.pwdCitoyen = pwdCitoyen;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        hash += (citoyenId != null ? citoyenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citoyen)) {
            return false;
        }
        Citoyen other = (Citoyen) object;
        if ((this.citoyenId == null && other.citoyenId != null) || (this.citoyenId != null && !this.citoyenId.equals(other.citoyenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.com.signalement.entities.Citoyen[ citoyenId=" + citoyenId + " ]";
    }
    
}
