package com.ngovanngoc.employees.repository;

import com.ngovanngoc.employees.model.PhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhanCongRepository extends JpaRepository<PhanCong,Integer> {
}
