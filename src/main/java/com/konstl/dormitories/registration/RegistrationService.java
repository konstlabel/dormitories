package com.konstl.dormitories.registration;

import com.konstl.dormitories.registration.dto.CreateRegistrationRequest;
import com.konstl.dormitories.registration.dto.RegistrationResponse;
import com.konstl.dormitories.registration.dto.RegistrationSearchDto;
import com.konstl.dormitories.utils.PageResponse;

public interface RegistrationService {

    RegistrationResponse findById(Long id);

    PageResponse<RegistrationResponse> findAll(int page, int size);

    PageResponse<RegistrationResponse> search(RegistrationSearchDto searchDto, int page, int size);

    RegistrationResponse create(CreateRegistrationRequest createRequest);

    RegistrationResponse delete(Long id);
}