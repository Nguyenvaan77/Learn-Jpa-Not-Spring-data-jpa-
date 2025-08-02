package com.anhangda37.basis.repository;

import com.anhangda37.basis.entity.AllLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllLogRepository extends JpaRepository<AllLog, Long> {
}
