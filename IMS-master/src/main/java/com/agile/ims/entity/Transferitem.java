/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muhammad
 */
@Entity
@Table(catalog = "inventory", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transferitem.findAll", query = "SELECT t FROM Transferitem t")
    , @NamedQuery(name = "Transferitem.findById", query = "SELECT t FROM Transferitem t WHERE t.id = :id")
    , @NamedQuery(name = "Transferitem.findByQuantity", query = "SELECT t FROM Transferitem t WHERE t.quantity = :quantity")
    , @NamedQuery(name = "Transferitem.findByPrice", query = "SELECT t FROM Transferitem t WHERE t.price = :price")})
public class Transferitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Float price;
    @JoinColumn(name = "transferid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Transfer transferid;
    @JoinColumn(name = "itemid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Item itemid;

    public Transferitem() {
    }

    public Transferitem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Transfer getTransferid() {
        return transferid;
    }

    public void setTransferid(Transfer transferid) {
        this.transferid = transferid;
    }

    public Item getItemid() {
        return itemid;
    }

    public void setItemid(Item itemid) {
        this.itemid = itemid;
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
        if (!(object instanceof Transferitem)) {
            return false;
        }
        Transferitem other = (Transferitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.Transferitem[ id=" + id + " ]";
    }

}