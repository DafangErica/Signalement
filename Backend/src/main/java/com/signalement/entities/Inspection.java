/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.signalement.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

/**
 *
 * @author ERICA
 */
@Entity
@Table(name = "inspection")
@NamedQueries({
    @NamedQuery(name = "Inspection.findAll", query = "SELECT i FROM Inspection i"),
    @NamedQuery(name = "Inspection.findByInspectionId", query = "SELECT i FROM Inspection i WHERE i.inspectionId = :inspectionId"),
    @NamedQuery(name = "Inspection.findByDate", query = "SELECT i FROM Inspection i WHERE i.date = :date"),
    @NamedQuery(name = "Inspection.findByHeureDebut", query = "SELECT i FROM Inspection i WHERE i.heureDebut = :heureDebut"),
    @NamedQuery(name = "Inspection.findByHeureFin", query = "SELECT i FROM Inspection i WHERE i.heureFin = :heureFin"),
    @NamedQuery(name = "Inspection.findByDescriptionInspection", query = "SELECT i FROM Inspection i WHERE i.descriptionInspection = :descriptionInspection")})
public class Inspection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inspection_id")
    private Integer inspectionId;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "heure_debut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;

    @Column(name = "heure_fin")
    @Temporal(TemporalType.TIME)
    private Date heureFin;

    @Column(name = "description_inspection")
    private String descriptionInspection;

    @JoinColumn(name = "infrastructure_id", referencedColumnName = "infrastructure_id")
    @ManyToOne(optional = false)
    private Infrastructure infrastructureId;

    @Version
    @Column(name = "version")
    private Integer version;

    public Inspection() {
    }

    public Inspection(Integer inspectionId) {
        this.inspectionId = inspectionId;
    }

    public Integer getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(Integer inspectionId) {
        this.inspectionId = inspectionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public String getDescriptionInspection() {
        return descriptionInspection;
    }

    public void setDescriptionInspection(String descriptionInspection) {
        this.descriptionInspection = descriptionInspection;
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
        hash += (inspectionId != null ? inspectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Inspection)) {
            return false;
        }
        Inspection other = (Inspection) object;
        return (this.inspectionId != null || other.inspectionId == null) &&
               (this.inspectionId == null || this.inspectionId.equals(other.inspectionId));
    }

    @Override
    public String toString() {
        return "com.signalement.entities.Inspection[ inspectionId=" + inspectionId + " ]";
    }
    
}
