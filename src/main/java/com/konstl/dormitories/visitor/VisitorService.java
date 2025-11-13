package com.konstl.dormitories.visitor;

import com.konstl.dormitories.visitor.dto.CreateVisitorRequest;
import com.konstl.dormitories.visitor.dto.UpdateVisitorRequest;
import com.konstl.dormitories.visitor.dto.VisitorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VisitorService {

    Page<VisitorResponse> findByFistName(String firstName, Pageable pageable);

    Page<VisitorResponse> findByMiddleName(String middleName, Pageable pageable);

    Page<VisitorResponse> findByLastName(String lastName, Pageable pageable);

    Page<VisitorResponse> findByFirstNameAndMiddleName(String firstName,
                                                       String middleName,
                                                       Pageable pageable);

    Page<VisitorResponse> findByFirstNameAndLastName(String firstName,
                                                     String lastName,
                                                     Pageable pageable);

    Page<VisitorResponse> findByMiddleNameAndLastName(String middleName,
                                                      String lastName,
                                                      Pageable pageable);

    Page<VisitorResponse> findByFullName(String firstName,
                                 String middleName,
                                 String lastName,
                                 Pageable pageable);

    Page<VisitorResponse> findByStatus(Boolean status, Pageable pageable);

    VisitorResponse create(CreateVisitorRequest createRequest);

    VisitorResponse update(UpdateVisitorRequest updateRequest);

    VisitorResponse delete(Long id);
}
