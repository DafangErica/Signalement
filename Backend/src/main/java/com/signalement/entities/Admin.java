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
@Table(name = "admin")
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByAdminId", query = "SELECT a FROM Admin a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "Admin.findByNomAdmin", query = "SELECT a FROM Admin a WHERE a.nomAdmin = :nomAdmin"),
    @NamedQuery(name = "Admin.findByMailAdmin", query = "SELECT a FROM Admin a WHERE a.mailAdmin = :mailAdmin"),
    @NamedQuery(name = "Admin.findByPwdAdmin", query = "SELECT a FROM Admin a WHERE a.pwdAdmin = :pwdAdmin"),
    @NamedQuery(name = "Admin.findByCreatedAt", query = "SELECT a FROM Admin a WHERE a.createdAt = :createdAt")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_id")
    private Integer adminId;
    @Basic(optional = false)
    @Column(name = "nom_admin")
    private String nomAdmin;
    @Basic(optional = false)
    @Column(name = "mail_admin")
    private String mailAdmin;
    @Basic(optional = false)
    @Column(name = "pwd_admin")
    private String pwdAdmin;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    private Collection<Inspecteur> inspecteurCollection;

    public Admin() {
    }

    public Admin(Integer adminId) {
        this.adminId = adminId;
    }

    public Admin(Integer adminId, String nomAdmin, String mailAdmin, String pwdAdmin, Date createdAt) {
        this.adminId = adminId;
        this.nomAdmin = nomAdmin;
        this.mailAdmin = mailAdmin;
        this.pwdAdmin = pwdAdmin;
        this.createdAt = createdAt;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getMailAdmin() {
        return mailAdmin;
    }

    public void setMailAdmin(String mailAdmin) {
        this.mailAdmin = mailAdmin;
    }

    public String getPwdAdmin() {
        return pwdAdmin;
    }

    public void setPwdAdmin(String pwdAdmin) {
        this.pwdAdmin = pwdAdmin;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.com.signalement.entities.Admin[ adminId=" + adminId + " ]";
    }
    
}
