package com.konstl.dormitories.registration;

import com.konstl.dormitories.employee.Employee;
import com.konstl.dormitories.payment.Payment;
import com.konstl.dormitories.visit.Visit;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Page<Registration> findByVisit(Visit visit, Pageable pageable);

    Page<Registration> findByPayment(Payment payment, Pageable pageable);

    Page<Registration> findByEmployee(Employee employee, Pageable pageable);

    Page<Registration> findByVisitAndPayment(Visit visit, Payment payment);

    Page<Registration> findByVisitAndEmployee(Visit visit, Employee employee);

    Page<Registration> findByPaymentAndEmployee(Payment payment, Employee employee);

    Optional<Registration> findByVisitAndPaymentAndEmployee(Visit visit, Payment payment, Employee employee);
}