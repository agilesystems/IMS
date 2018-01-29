/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 *
 * @author ramy
 */
@Entity
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salprice")
    private BigDecimal salprice;
    @Column(name = "buyprice")
    private BigDecimal buyprice;
    @Size(max = 255)
    @Column(name = "barcode")
    private String barcode;
    @Size(max = 255)
    @Column(name = "globalcode")
    private String globalcode;
    @Size(max = 255)
    @Column(name = "localcode")
    private String localcode;
    @Column(name = "lowestprice")
    private BigDecimal lowestprice;
    @Column(name = "lowestquantity")
    private Integer lowestquantity;
    @Column(name = "expiredate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredate;
    @Column(name = "isdead")
    private Boolean isdead;
    @Size(max = 255)
    @Column(name = "extrainfo")
    private String extrainfo;
    @Size(max = 255)
    @Column(name = "photopath")
    private String photopath;
    @Column(name = "createdat")
    @Temporal(TemporalType.DATE)
    private Date createdat;
    @Column(name = "updatedby")
    private Integer updatedby;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "deletedby")
    private Integer deletedby;
    @JoinColumn(name = "unitid", referencedColumnName = "id")
    @ManyToOne
    private Lookup unitid;
    @JoinColumn(name = "groupid", referencedColumnName = "id")
    @ManyToOne
    private Lookup groupid;
    @JoinColumn(name = "createdby", referencedColumnName = "id")
    @ManyToOne
    private User createdby;
    @OneToMany(mappedBy = "itemid")
    private Collection<InvoiceItem> invoiceItemCollection;
    @OneToMany(mappedBy = "itemid")
    private Collection<TransferItem> transferItemCollection;
    @OneToMany(mappedBy = "itemid")
    private Collection<StoreItem> storeItemCollection;

    public Item() {
    }

    public Item(Integer id) {
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

    public BigDecimal getSalprice() {
        return salprice;
    }

    public void setSalprice(BigDecimal salprice) {
        this.salprice = salprice;
    }

    public BigDecimal getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(BigDecimal buyprice) {
        this.buyprice = buyprice;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getGlobalcode() {
        return globalcode;
    }

    public void setGlobalcode(String globalcode) {
        this.globalcode = globalcode;
    }

    public String getLocalcode() {
        return localcode;
    }

    public void setLocalcode(String localcode) {
        this.localcode = localcode;
    }

    public BigDecimal getLowestprice() {
        return lowestprice;
    }

    public void setLowestprice(BigDecimal lowestprice) {
        this.lowestprice = lowestprice;
    }

    public Integer getLowestquantity() {
        return lowestquantity;
    }

    public void setLowestquantity(Integer lowestquantity) {
        this.lowestquantity = lowestquantity;
    }

    public Date getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
    }

    public Boolean getIsdead() {
        return isdead;
    }

    public void setIsdead(Boolean isdead) {
        this.isdead = isdead;
    }

    public String getExtrainfo() {
        return extrainfo;
    }

    public void setExtrainfo(String extrainfo) {
        this.extrainfo = extrainfo;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
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

    public Lookup getUnitid() {
        return unitid;
    }

    public void setUnitid(Lookup unitid) {
        this.unitid = unitid;
    }

    public Lookup getGroupid() {
        return groupid;
    }

    public void setGroupid(Lookup groupid) {
        this.groupid = groupid;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    public Collection<InvoiceItem> getInvoiceItemCollection() {
        return invoiceItemCollection;
    }

    public void setInvoiceItemCollection(Collection<InvoiceItem> invoiceItemCollection) {
        this.invoiceItemCollection = invoiceItemCollection;
    }

    public Collection<TransferItem> getTransferItemCollection() {
        return transferItemCollection;
    }

    public void setTransferItemCollection(Collection<TransferItem> transferItemCollection) {
        this.transferItemCollection = transferItemCollection;
    }

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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.Item[ id=" + id + " ]";
    }
    
}
