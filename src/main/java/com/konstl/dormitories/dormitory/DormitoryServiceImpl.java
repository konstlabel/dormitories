package com.konstl.dormitories.dormitory;

import com.konstl.dormitories.dormitory.dto.CreateDormitoryRequest;
import com.konstl.dormitories.dormitory.dto.DormitoryResponse;
import com.konstl.dormitories.dormitory.dto.UpdateDormitoryRequest;
import com.konstl.dormitories.utils.PageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DormitoryServiceImpl implements DormitoryService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final DormitoryRepository dormitoryRepository;

    public DormitoryServiceImpl(DormitoryRepository dormitoryRepository) {

        this.dormitoryRepository = dormitoryRepository;
    }

    @Override
    public DormitoryResponse findById(Long id) {
        return null;
    }

    @Override
    public PageResponse<DormitoryResponse> findByName(String name, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<DormitoryResponse> findByAddress(String address, int page, int size) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public DormitoryResponse create(CreateDormitoryRequest createRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public DormitoryResponse update(UpdateDormitoryRequest updateRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public DormitoryResponse delete(Long id) {
        return null;
    }
}
