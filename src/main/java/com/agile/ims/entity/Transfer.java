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
    @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t")
    , @NamedQuery(name = "Transfer.findById", query = "SELECT t FROM Transfer t WHERE t.id = :id")
    , @NamedQuery(name = "Transfer.findByTransferdate", query = "SELECT t FROM Transfer t WHERE t.transferdate = :transferdate")
    , @NamedQuery(name = "Transfer.findByCreatedat", query = "SELECT t FROM Transfer t WHERE t.createdat = :createdat")
    , @NamedQuery(name = "Transfer.findByUpdatedby", query = "SELECT t FROM Transfer t WHERE t.updatedby = :updatedby")
    , @NamedQuery(name = "Transfer.findByUpdatedat", query = "SELECT t FROM Transfer t WHERE t.updatedat = :updatedat")
    , @NamedQuery(name = "Transfer.findByDeleted", query = "SELECT t FROM Transfer t WHERE t.deleted = :deleted")
    , @NamedQuery(name = "Transfer.findByDeletedby", query = "SELECT t FROM Transfer t WHERE t.deletedby = :deletedby")})
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdat;
    private Integer updatedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    private Boolean deleted;
    private Integer deletedby;
    @JoinColumn(name = "storeidfrom", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Store storeidfrom;
    @JoinColumn(name = "storeidto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Store storeidto;
    @JoinColumn(name = "createdby", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User createdby;
    @OneToMany(mappedBy = "transferid", fetch = FetchType.EAGER)
    private Collection<Transferitem> transferitemCollection;

    public Transfer() {
    }

    public Transfer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransferdate() {
        return transferdate;
    }

    public void setTransferdate(Date transferdate) {
        this.transferdate = transferdate;
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

    public Store getStoreidfrom() {
        return storeidfrom;
    }

    public void setStoreidfrom(Store storeidfrom) {
        this.storeidfrom = storeidfrom;
    }

    public Store getStoreidto() {
        return storeidto;
    }

    public void setStoreidto(Store storeidto) {
        this.storeidto = storeidto;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
    }

    @XmlTransient
    public Collection<Transferitem> getTransferitemCollection() {
        return transferitemCollection;
    }

    public void setTransferitemCollection(Collection<Transferitem> transferitemCollection) {
        this.transferitemCollection = transferitemCollection;
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
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.Transfer[ id=" + id + " ]";
    }

}
