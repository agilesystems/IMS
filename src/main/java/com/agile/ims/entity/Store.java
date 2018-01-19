/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Muhammad
 */
@Entity
@Table(catalog = "inventory", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
    , @NamedQuery(name = "Store.findById", query = "SELECT s FROM Store s WHERE s.id = :id")
    , @NamedQuery(name = "Store.findByName", query = "SELECT s FROM Store s WHERE s.name = :name")
    , @NamedQuery(name = "Store.findByAddress", query = "SELECT s FROM Store s WHERE s.address = :address")
    , @NamedQuery(name = "Store.findByPhone", query = "SELECT s FROM Store s WHERE s.phone = :phone")
    , @NamedQuery(name = "Store.findByCreatedat", query = "SELECT s FROM Store s WHERE s.createdat = :createdat")
    , @NamedQuery(name = "Store.findByUpdatedby", query = "SELECT s FROM Store s WHERE s.updatedby = :updatedby")
    , @NamedQuery(name = "Store.findByUpdatedat", query = "SELECT s FROM Store s WHERE s.updatedat = :updatedat")
    , @NamedQuery(name = "Store.findByDeleted", query = "SELECT s FROM Store s WHERE s.deleted = :deleted")
    , @NamedQuery(name = "Store.findByDeletedby", query = "SELECT s FROM Store s WHERE s.deletedby = :deletedby")})
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    private String phone;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdat;
    private Integer updatedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    private Boolean deleted;
    private Integer deletedby;
    @OneToMany(mappedBy = "storeidfrom", fetch = FetchType.EAGER)
    private Collection<Transfer> transferCollection;
    @OneToMany(mappedBy = "storeidto", fetch = FetchType.EAGER)
    private Collection<Transfer> transferCollection1;
    @OneToMany(mappedBy = "storeid", fetch = FetchType.EAGER)
    private Collection<Invoice> invoiceCollection;
    @JoinColumn(name = "createdby", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User createdby;
    @OneToMany(mappedBy = "storeid", fetch = FetchType.EAGER)
    private Collection<StoreItem> storeItemCollection;

    public Store() {
    }

    public Store(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @XmlTransient
    public Collection<Transfer> getTransferCollection() {
        return transferCollection;
    }

    public void setTransferCollection(Collection<Transfer> transferCollection) {
        this.transferCollection = transferCollection;
    }

    @XmlTransient
    public Collection<Transfer> getTransferCollection1() {
        return transferCollection1;
    }

    public void setTransferCollection1(Collection<Transfer> transferCollection1) {
        this.transferCollection1 = transferCollection1;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    @XmlTransient
    public Collection<StoreItem> getStoreItemCollection() {
        return storeItemCollection;
    }

    public void setStoreItemCollection(Collection<StoreItem> storeItemCollection) {
        this.storeItemCollection = storeItemCollection;
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
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.Store[ id=" + id + " ]";
    }

}
