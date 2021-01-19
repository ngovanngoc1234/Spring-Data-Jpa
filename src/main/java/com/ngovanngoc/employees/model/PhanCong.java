package com.ngovanngoc.employees.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Table
@Entity
public class PhanCong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "duAnID", foreignKey = @ForeignKey(name = "fk_phancong_duan"))
    @JsonIgnoreProperties(value = "phanCongs")
    DuAn duAn;

    @Column
    @Min(value = 1,message = "so gio lam la nguyen duong")
    private int soGioLam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nhanVienID",foreignKey = @ForeignKey(name = "fk_phancong_nhanvien"))
    @JsonIgnoreProperties(value =  "phanCongs")
    NhanVien nhanVien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DuAn getDuAn() {
        return duAn;
    }

    public void setDuAn(DuAn duAn) {
        this.duAn = duAn;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
