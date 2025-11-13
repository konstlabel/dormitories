package com.konstl.dormitories.visitor;

import com.konstl.dormitories.visitor.dto.CreateVisitorRequest;
import com.konstl.dormitories.visitor.dto.UpdateVisitorRequest;
import com.konstl.dormitories.visitor.dto.VisitorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<VisitorResponse> findByFistName(String firstName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitorResponse> findByMiddleName(String middleName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitorResponse> findByLastName(String lastName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitorResponse> findByFirstNameAndMiddleName(String firstName, String middleName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitorResponse> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitorResponse> findByMiddleNameAndLastName(String middleName, String lastName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitorResponse> findByFullName(String firstName, String middleName, String lastName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitorResponse> findByStatus(Boolean status, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public VisitorResponse create(CreateVisitorRequest createRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public VisitorResponse update(UpdateVisitorRequest updateRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public VisitorResponse delete(Long id) {
        return null;
    }
}
