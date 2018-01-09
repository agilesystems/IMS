/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ramy
 */
@Entity
@Table(name = "form")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Form.findAll", query = "SELECT f FROM Form f")
    , @NamedQuery(name = "Form.findById", query = "SELECT f FROM Form f WHERE f.id = :id")
    , @NamedQuery(name = "Form.findByTitle", query = "SELECT f FROM Form f WHERE f.title = :title")
    , @NamedQuery(name = "Form.findByFxml", query = "SELECT f FROM Form f WHERE f.fxml = :fxml")
    , @NamedQuery(name = "Form.findByIcon", query = "SELECT f FROM Form f WHERE f.icon = :icon")})
public class Form implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "fxml")
    private String fxml;
    @Column(name = "icon")
    private String icon;
    @OneToMany(mappedBy = "form")
    private Collection<Menu> menuCollection;

    public Form() {
    }

    public Form(Integer id) {
        this.id = id;
    }

    public Form(Integer id, String title, String fxml) {
        this.id = id;
        this.title = title;
        this.fxml = fxml;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFxml() {
        return fxml;
    }

    public void setFxml(String fxml) {
        this.fxml = fxml;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Form)) {
            return false;
        }
        Form other = (Form) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agilesolutions.xnet.pharmanet.inventory.entity.Form[ id=" + id + " ]";
    }
    
}
