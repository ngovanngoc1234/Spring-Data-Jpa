package com.ngovanngoc.employees.controller;

import com.google.gson.Gson;
import com.ngovanngoc.employees.model.NhanVien;
import com.ngovanngoc.employees.model.PhanCong;
import com.ngovanngoc.employees.repository.IDuAnRepostory;
import com.ngovanngoc.employees.repository.INhanVienRepository;
import com.ngovanngoc.employees.repository.IPhanCongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        listNV.forEach(x -> {
            int sum = 0;
            for (int i = 0; i < listPC.size(); i++) {
                if (x.getId() == listPC.get(i).getNhanVien().getId()) {
                    sum += listPC.get(i).getSoGioLam();
                }
            }
            int salary = sum * 15 * x.getHesoluong();
            System.out.println(x.getHoten() + ":" + salary);
        });
    }
}
