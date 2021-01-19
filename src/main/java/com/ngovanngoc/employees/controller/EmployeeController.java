package com.ngovanngoc.employees.controller;

import com.google.gson.Gson;
import com.ngovanngoc.employees.model.NhanVien;
import com.ngovanngoc.employees.model.PhanCong;
import com.ngovanngoc.employees.repository.IDuAnRepostory;
import com.ngovanngoc.employees.repository.INhanVienRepository;
import com.ngovanngoc.employees.repository.IPhanCongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    IDuAnRepostory darep;
    @Autowired
    INhanVienRepository nvRep;
    @Autowired
    IPhanCongRepository pcRep;

    @PostMapping(value = "nhanvien/them")
    public void addEmployee(@RequestBody String nhanVien) {
        Gson gson = new Gson();
        NhanVien nvMoi = gson.fromJson(nhanVien, NhanVien.class);
        nvRep.save(nvMoi);

        for (PhanCong x : nvMoi.getPhanCongs()) {
            x.setNhanVien(nvMoi);
        }
        pcRep.saveAll(nvMoi.getPhanCongs());
    }

    @DeleteMapping(value = "nhanvien/xoa")
    public void deleteEmployee(@RequestBody int nhanVienID) {
        nvRep.deleteById(nhanVienID);
    }

    public void payrollEp() {
        List<PhanCong> listPC = pcRep.findAll();
        List<NhanVien> listNV = nvRep.findAll();
        for (NhanVien x : listNV) {
            int sum = 0;
            for (PhanCong phanCong : listPC) {
                if (x.getId() == phanCong.getNhanVien().getId()) {
                    sum += phanCong.getSoGioLam();
                }
            }
            int salary = sum * 15 * x.getHesoluong();
            System.out.println(x.getHoten() + ":" + salary);
        }
    }

    @GetMapping(value = "nhanvien")
    public List<NhanVien> get() {
        payrollEp();
        return nvRep.findAll();
    }
}
