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
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id")
    , @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name")
    , @NamedQuery(name = "Item.findBySalprice", query = "SELECT i FROM Item i WHERE i.salprice = :salprice")
    , @NamedQuery(name = "Item.findByBuyprice", query = "SELECT i FROM Item i WHERE i.buyprice = :buyprice")
    , @NamedQuery(name = "Item.findByBarcode", query = "SELECT i FROM Item i WHERE i.barcode = :barcode")
    , @NamedQuery(name = "Item.findByGlobalcode", query = "SELECT i FROM Item i WHERE i.globalcode = :globalcode")
    , @NamedQuery(name = "Item.findByLocalcode", query = "SELECT i FROM Item i WHERE i.localcode = :localcode")
    , @NamedQuery(name = "Item.findByLowestprice", query = "SELECT i FROM Item i WHERE i.lowestprice = :lowestprice")
    , @NamedQuery(name = "Item.findByLowestquantity", query = "SELECT i FROM Item i WHERE i.lowestquantity = :lowestquantity")
    , @NamedQuery(name = "Item.findByExpiredate", query = "SELECT i FROM Item i WHERE i.expiredate = :expiredate")
    , @NamedQuery(name = "Item.findByIsdead", query = "SELECT i FROM Item i WHERE i.isdead = :isdead")
    , @NamedQuery(name = "Item.findByExtrainfo", query = "SELECT i FROM Item i WHERE i.extrainfo = :extrainfo")
    , @NamedQuery(name = "Item.findByPhotopath", query = "SELECT i FROM Item i WHERE i.photopath = :photopath")
    , @NamedQuery(name = "Item.findByCreatedat", query = "SELECT i FROM Item i WHERE i.createdat = :createdat")
    , @NamedQuery(name = "Item.findByUpdatedby", query = "SELECT i FROM Item i WHERE i.updatedby = :updatedby")
    , @NamedQuery(name = "Item.findByUpdatedat", query = "SELECT i FROM Item i WHERE i.updatedat = :updatedat")
    , @NamedQuery(name = "Item.findByDeleted", query = "SELECT i FROM Item i WHERE i.deleted = :deleted")
    , @NamedQuery(name = "Item.findByDeletedby", query = "SELECT i FROM Item i WHERE i.deletedby = :deletedby")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 255)
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal salprice;
    private BigDecimal buyprice;
    @Size(max = 255)
    private String barcode;
    @Size(max = 255)
    private String globalcode;
    @Size(max = 255)
    private String localcode;
    private BigDecimal lowestprice;
    private Integer lowestquantity;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredate;
    private Boolean isdead;
    @Size(max = 255)
    private String extrainfo;
    @Size(max = 255)
    private String photopath;
    @Temporal(TemporalType.DATE)
    private Date createdat;
    private Integer updatedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    private Boolean deleted;
    private Integer deletedby;
    @JoinColumn(name = "unitid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Lookup unitid;
    @JoinColumn(name = "groupid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Lookup groupid;
    @JoinColumn(name = "createdby", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User createdby;
    @OneToMany(mappedBy = "itemid", fetch = FetchType.EAGER)
    private Collection<Invoiceitem> invoiceitemCollection;
    @OneToMany(mappedBy = "itemid", fetch = FetchType.EAGER)
    private Collection<Transferitem> transferitemCollection;
    @OneToMany(mappedBy = "itemid", fetch = FetchType.EAGER)
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

    @XmlTransient
    public Collection<Invoiceitem> getInvoiceitemCollection() {
        return invoiceitemCollection;
    }

    public void setInvoiceitemCollection(Collection<Invoiceitem> invoiceitemCollection) {
        this.invoiceitemCollection = invoiceitemCollection;
    }

    @XmlTransient
    public Collection<Transferitem> getTransferitemCollection() {
        return transferitemCollection;
    }

    public void setTransferitemCollection(Collection<Transferitem> transferitemCollection) {
        this.transferitemCollection = transferitemCollection;
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
