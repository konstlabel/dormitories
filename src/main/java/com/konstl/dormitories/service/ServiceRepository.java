package com.konstl.dormitories.service;

import com.konstl.dormitories.employee.Employee;
import com.konstl.dormitories.resident.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service, ServiceId> {

    Page<Service> findByEmployee(Employee employee, Pageable pageable);

    Page<Service> findByResident(Resident resident, Pageable pageable);

    Optional<Service> findByEmployeeAndResident(Employee employee, Resident resident);
}
