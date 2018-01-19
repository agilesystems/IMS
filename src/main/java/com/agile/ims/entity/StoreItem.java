/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muhammad
 */
@Entity
@Table(name = "store_item", catalog = "inventory", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreItem.findAll", query = "SELECT s FROM StoreItem s")
    , @NamedQuery(name = "StoreItem.findById", query = "SELECT s FROM StoreItem s WHERE s.id = :id")
    , @NamedQuery(name = "StoreItem.findByQuantity", query = "SELECT s FROM StoreItem s WHERE s.quantity = :quantity")
    , @NamedQuery(name = "StoreItem.findByCreatedat", query = "SELECT s FROM StoreItem s WHERE s.createdat = :createdat")
    , @NamedQuery(name = "StoreItem.findByUpdatedby", query = "SELECT s FROM StoreItem s WHERE s.updatedby = :updatedby")
    , @NamedQuery(name = "StoreItem.findByUpdatedat", query = "SELECT s FROM StoreItem s WHERE s.updatedat = :updatedat")
    , @NamedQuery(name = "StoreItem.findByDeleted", query = "SELECT s FROM StoreItem s WHERE s.deleted = :deleted")
    , @NamedQuery(name = "StoreItem.findByDeletedby", query = "SELECT s FROM StoreItem s WHERE s.deletedby = :deletedby")})
public class StoreItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Integer quantity;
    @Temporal(TemporalType.DATE)
    private Date createdat;
    private Integer updatedby;
    @Temporal(TemporalType.DATE)
    private Date updatedat;
    private Boolean deleted;
    private Integer deletedby;
    @JoinColumn(name = "storeid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Store storeid;
    @JoinColumn(name = "itemid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Item itemid;
    @JoinColumn(name = "createdby", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User createdby;

    public StoreItem() {
    }

    public StoreItem(Integer id) {
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

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Integer getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(Integer updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(Integer deletedby) {
        this.deletedby = deletedby;
    }

    public Store getStoreid() {
        return storeid;
    }

    public void setStoreid(Store storeid) {
        this.storeid = storeid;
    }

    public Item getItemid() {
        return itemid;
    }

    public void setItemid(Item itemid) {
        this.itemid = itemid;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
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
        if (!(object instanceof StoreItem)) {
            return false;
        }
        StoreItem other = (StoreItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.StoreItem[ id=" + id + " ]";
    }

}
