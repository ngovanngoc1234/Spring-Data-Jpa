package com.ngovanngoc.employees.repository;

import com.ngovanngoc.employees.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien,Integer> {
}
