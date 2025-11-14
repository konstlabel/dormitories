package com.konstl.dormitories.visitor;

import com.konstl.dormitories.utils.PageResponse;
import com.konstl.dormitories.visitor.dto.CreateVisitorRequest;
import com.konstl.dormitories.visitor.dto.UpdateVisitorRequest;
import com.konstl.dormitories.visitor.dto.VisitorResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VisitorServiceImpl implements VisitorService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {

        this.visitorRepository = visitorRepository;
    }

    @Override
    public PageResponse<VisitorResponse> findByFirstName(String firstName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitorResponse> findByMiddleName(String middleName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitorResponse> findByLastName(String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitorResponse> findByFirstNameAndMiddleName(String firstName, String middleName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitorResponse> findByFirstNameAndLastName(String firstName, String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitorResponse> findByMiddleNameAndLastName(String middleName, String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitorResponse> findByFullName(String firstName, String middleName, String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitorResponse> findByStatus(Boolean status, int page, int size) {
        return null;
    }

    @Override
    public VisitorResponse create(CreateVisitorRequest createRequest) {
        return null;
    }

    @Override
    public VisitorResponse update(UpdateVisitorRequest updateRequest) {
        return null;
    }

    @Override
    public VisitorResponse delete(Long id) {
        return null;
    }
}
