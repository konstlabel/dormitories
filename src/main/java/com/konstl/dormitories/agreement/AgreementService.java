package com.konstl.dormitories.agreement;

import com.konstl.dormitories.agreement.dto.AgreementResponse;
import com.konstl.dormitories.agreement.dto.AgreementSearchDto;
import com.konstl.dormitories.agreement.dto.CreateAgreementRequest;
import com.konstl.dormitories.agreement.dto.UpdateAgreementRequest;
import com.konstl.dormitories.utils.PageResponse;

public interface AgreementService {

    AgreementResponse findById(Long id);

    PageResponse<AgreementResponse> findAll(int page, int size);

    PageResponse<AgreementResponse> search(AgreementSearchDto searchDto, int page, int size);

    AgreementResponse create(CreateAgreementRequest createRequest);

    AgreementResponse update(Long id, UpdateAgreementRequest updateRequest);

    boolean delete(Long id);
}
