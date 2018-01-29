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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ramy
 */
@Entity
@Table(name = "menu")
@NamedQueries({
    @NamedQuery(name = "UserMenu.findAll", query = "SELECT m FROM UserMenu m")})
public class UserMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Column(name = "veiw_order")
    private Integer veiwOrder;
    @Size(max = 45)
    @Column(name = "fxml")
    private String fxml;
    @Size(max = 45)
    @Column(name = "icon")
    private String icon;
    @JoinTable(name = "user_menu", joinColumns = {
        @JoinColumn(name = "menu", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user", referencedColumnName = "id")})
    @ManyToMany
    private Collection<User> userCollection;
    @OneToMany(mappedBy = "parent")
    private Collection<UserMenu> menuCollection;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne
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

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Collection<UserMenu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<UserMenu> menuCollection) {
        this.menuCollection = menuCollection;
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
        return "com.agile.ims.entity.Menu[ id=" + id + " ]";
    }
    
}
