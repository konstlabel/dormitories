package com.konstl.dormitories.resident;

import com.konstl.dormitories.resident.dto.CreateResidentRequest;
import com.konstl.dormitories.resident.dto.UpdateResidentRequest;
import com.konstl.dormitories.resident.dto.ResidentResponse;
import com.konstl.dormitories.utils.PageResponse;

public interface ResidentService {

    ResidentResponse findById(Long id);

    PageResponse<ResidentResponse> findByFirstName(String firstName, int page, int size);

    PageResponse<ResidentResponse> findByMiddleName(String middleName, int page, int size);

    PageResponse<ResidentResponse> findByLastName(String lastName, int page, int size);

    PageResponse<ResidentResponse> findByFirstNameAndMiddleName(String firstName,
                                                       String middleName,
                                                       int page, int size);

    PageResponse<ResidentResponse> findByFirstNameAndLastName(String firstName,
                                                     String lastName,
                                                     int page, int size);

    PageResponse<ResidentResponse> findByMiddleNameAndLastName(String middleName,
                                                      String lastName,
                                                      int page, int size);

    PageResponse<ResidentResponse> findByFullName(String firstName,
                                         String middleName,
                                         String lastName,
                                         int page, int size);

    PageResponse<ResidentResponse> findByRoomId(Long roomId, int page, int size);

    PageResponse<ResidentResponse> findByAgreementId(Long agreementId, int page, int size);

    ResidentResponse create(CreateResidentRequest createRequest);

    ResidentResponse update(UpdateResidentRequest updateRequest);

    ResidentResponse delete(Long id);
}
