/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamesr_logic.datalog;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fly_troy
 */
@Entity
@Table(name = "testlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testlog.findAll", query = "SELECT t FROM Testlog t"),
    @NamedQuery(name = "Testlog.findByInt1", query = "SELECT t FROM Testlog t WHERE t.int1 = :int1")})
public class Testlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "int")
    private Integer int1;

    public Testlog() {
    }

    public Testlog(Integer int1) {
        this.int1 = int1;
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int1 != null ? int1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testlog)) {
            return false;
        }
        Testlog other = (Testlog) object;
        if ((this.int1 == null && other.int1 != null) || (this.int1 != null && !this.int1.equals(other.int1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gamesr_logic.datalog.Testlog[ int1=" + int1 + " ]";
    }
    
}
