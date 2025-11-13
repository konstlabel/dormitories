package com.konstl.dormitories.resident;

import com.konstl.dormitories.agreement.Agreement;
import com.konstl.dormitories.resident.dto.CreateResidentRequest;
import com.konstl.dormitories.resident.dto.UpdateResidentRequest;
import com.konstl.dormitories.resident.dto.ResidentResponse;
import com.konstl.dormitories.room.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResidentService {

    ResidentResponse findById(Long id);

    Page<ResidentResponse> findByFistName(String firstName, Pageable pageable);

    Page<ResidentResponse> findByMiddleName(String middleName, Pageable pageable);

    Page<ResidentResponse> findByLastName(String lastName, Pageable pageable);

    Page<ResidentResponse> findByFirstNameAndMiddleName(String firstName,
                                                       String middleName,
                                                       Pageable pageable);

    Page<ResidentResponse> findByFirstNameAndLastName(String firstName,
                                                     String lastName,
                                                     Pageable pageable);

    Page<ResidentResponse> findByMiddleNameAndLastName(String middleName,
                                                      String lastName,
                                                      Pageable pageable);

    Page<ResidentResponse> findByFullName(String firstName,
                                         String middleName,
                                         String lastName,
                                         Pageable pageable);

    Page<ResidentResponse> findByRoomId(Long roomId, Pageable pageable);

    Page<ResidentResponse> findByAgreementId(Long agreementId);

    ResidentResponse create(CreateResidentRequest createRequest);

    ResidentResponse update(UpdateResidentRequest updateRequest);

    ResidentResponse delete(Long id);
}
