package com.ngovanngoc.employees.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Table
@Entity
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Size(max = 10,message = "ten khong vượt quá 10 ký tự ")
    private String tenDuAn;

    @Column
    private String moTa;

    @Column
    private String ghiChu;


    @OneToMany(mappedBy = "duAn")
    @JsonIgnoreProperties(value = "duAn")
    Set<PhanCong> phanCongs;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Set<PhanCong> getPhanCong() {
        return phanCongs;
    }

    public void setPhanCong(Set<PhanCong> phanCong) {
        this.phanCongs = phanCong;
    }
}
