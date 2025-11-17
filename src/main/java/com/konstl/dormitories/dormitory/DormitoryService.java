package com.konstl.dormitories.dormitory;

import com.konstl.dormitories.dormitory.dto.CreateDormitoryRequest;
import com.konstl.dormitories.dormitory.dto.DormitoryResponse;
import com.konstl.dormitories.dormitory.dto.UpdateDormitoryRequest;
import com.konstl.dormitories.utils.PageResponse;

public interface DormitoryService {

    DormitoryResponse findById(Long id);

    PageResponse<DormitoryResponse> findAll(int page, int size);

    PageResponse<DormitoryResponse> findByName(String name, int page, int size);

    PageResponse<DormitoryResponse> findByAddress(String address, int page, int size);

    DormitoryResponse create(CreateDormitoryRequest createRequest);

    DormitoryResponse update(Long id, UpdateDormitoryRequest updateRequest);

    boolean delete(Long id);
}
