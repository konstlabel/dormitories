package com.konstl.dormitories.payment;

import com.konstl.dormitories.resident.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Month;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Page<Payment> findByDate(Timestamp date, Pageable pageable);

    Page<Payment> findByAmount(Double amount, Pageable pageable);

    Page<Payment> findByPeriod(Month period, Pageable pageable);

    Page<Payment> findByResident(Resident resident, Pageable pageable);

    Page<Payment> findByResidentAndPeriod(Resident resident, Month period, Pageable pageable);
}
