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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMenu.findAll", query = "SELECT u FROM UserMenu u")
    , @NamedQuery(name = "UserMenu.findById", query = "SELECT u FROM UserMenu u WHERE u.id = :id")
    , @NamedQuery(name = "UserMenu.findByTitle", query = "SELECT u FROM UserMenu u WHERE u.title = :title")
    , @NamedQuery(name = "UserMenu.findByVeiwOrder", query = "SELECT u FROM UserMenu u WHERE u.veiwOrder = :veiwOrder")
    , @NamedQuery(name = "UserMenu.findByFxml", query = "SELECT u FROM UserMenu u WHERE u.fxml = :fxml")
    , @NamedQuery(name = "UserMenu.findByIcon", query = "SELECT u FROM UserMenu u WHERE u.icon = :icon")})
public class UserMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "veiw_order")
    private Integer veiwOrder;
    @Column(name = "fxml")
    private String fxml;
    @Column(name = "icon")
    private String icon;
    @JoinTable(name = "user_menu", joinColumns = {
        @JoinColumn(name = "menu", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<User> userCollection;
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private Collection<UserMenu> userMenuCollection;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserMenu parent;

    public UserMenu() {
    }

    public UserMenu(Integer id) {
        this.id = id;
    }

    public UserMenu(Integer id, String title) {
        this.id = id;
        this.title = title;
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

    public Integer getVeiwOrder() {
        return veiwOrder;
    }

    public void setVeiwOrder(Integer veiwOrder) {
        this.veiwOrder = veiwOrder;
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
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<UserMenu> getUserMenuCollection() {
        return userMenuCollection;
    }

    public void setUserMenuCollection(Collection<UserMenu> userMenuCollection) {
        this.userMenuCollection = userMenuCollection;
    }

    public UserMenu getParent() {
        return parent;
    }

    public void setParent(UserMenu parent) {
        this.parent = parent;
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
        if (!(object instanceof UserMenu)) {
            return false;
        }
        UserMenu other = (UserMenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.UserMenu[ id=" + id + " ]";
    }
    
}
