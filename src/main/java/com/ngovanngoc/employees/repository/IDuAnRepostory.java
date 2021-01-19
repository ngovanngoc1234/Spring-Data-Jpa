package com.ngovanngoc.employees.repository;

import com.ngovanngoc.employees.model.DuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuAnRepostory extends JpaRepository<DuAn,Integer> {
}
