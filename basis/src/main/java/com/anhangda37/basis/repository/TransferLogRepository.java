package com.anhangda37.basis.repository;

import com.anhangda37.basis.entity.TransferLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferLogRepository extends JpaRepository<TransferLog, Long> {
}
