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
@Table(name = "service")
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByServiceId", query = "SELECT s FROM Service s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "Service.findByNomService", query = "SELECT s FROM Service s WHERE s.nomService = :nomService"),
    @NamedQuery(name = "Service.findByMailService", query = "SELECT s FROM Service s WHERE s.mailService = :mailService"),
    @NamedQuery(name = "Service.findByCreatedAt", query = "SELECT s FROM Service s WHERE s.createdAt = :createdAt")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_id")
    private Integer serviceId;
    @Basic(optional = false)
    @Column(name = "nom_service")
    private String nomService;
    @Basic(optional = false)
    @Column(name = "mail_service")
    private String mailService;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceId")
    private Collection<Inspecteur> inspecteurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceId")
    private Collection<Signalement> signalementCollection;

    public Service() {
    }

    public Service(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Service(Integer serviceId, String nomService, String mailService, Date createdAt) {
        this.serviceId = serviceId;
        this.nomService = nomService;
        this.mailService = mailService;
        this.createdAt = createdAt;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getMailService() {
        return mailService;
    }

    public void setMailService(String mailService) {
        this.mailService = mailService;
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
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.com.signalement.entities.Service[ serviceId=" + serviceId + " ]";
    }
    
}
