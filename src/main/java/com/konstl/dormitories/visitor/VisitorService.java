package com.konstl.dormitories.visitor;

import com.konstl.dormitories.utils.PageResponse;
import com.konstl.dormitories.visitor.dto.CreateVisitorRequest;
import com.konstl.dormitories.visitor.dto.UpdateVisitorRequest;
import com.konstl.dormitories.visitor.dto.VisitorResponse;

public interface VisitorService {

    PageResponse<VisitorResponse> findByFirstName(String firstName, int page, int size);

    PageResponse<VisitorResponse> findByMiddleName(String middleName, int page, int size);

    PageResponse<VisitorResponse> findByLastName(String lastName, int page, int size);

    PageResponse<VisitorResponse> findByFirstNameAndMiddleName(String firstName,
                                                       String middleName,
                                                       int page, int size);

    PageResponse<VisitorResponse> findByFirstNameAndLastName(String firstName,
                                                     String lastName,
                                                     int page, int size);

    PageResponse<VisitorResponse> findByMiddleNameAndLastName(String middleName,
                                                      String lastName,
                                                      int page, int size);

    PageResponse<VisitorResponse> findByFullName(String firstName,
                                 String middleName,
                                 String lastName,
                                 int page, int size);

    PageResponse<VisitorResponse> findByStatus(Boolean status, int page, int size);

    VisitorResponse create(CreateVisitorRequest createRequest);

    VisitorResponse update(UpdateVisitorRequest updateRequest);

    VisitorResponse delete(Long id);
}
