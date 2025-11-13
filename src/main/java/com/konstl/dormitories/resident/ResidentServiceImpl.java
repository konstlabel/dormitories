package com.konstl.dormitories.resident;

import com.konstl.dormitories.agreement.AgreementRepository;
import com.konstl.dormitories.resident.dto.CreateResidentRequest;
import com.konstl.dormitories.resident.dto.ResidentResponse;
import com.konstl.dormitories.resident.dto.UpdateResidentRequest;
import com.konstl.dormitories.room.RoomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ResidentServiceImpl implements ResidentService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final ResidentRepository residentRepository;
    private final RoomRepository roomRepository;
    private final AgreementRepository agreementRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository,
                               RoomRepository roomRepository,
                               AgreementRepository agreementRepository) {

        this.residentRepository = residentRepository;
        this.roomRepository = roomRepository;
        this.agreementRepository = agreementRepository;
    }

    @Override
    public ResidentResponse findById(Long id) {
        return null;
    }

    @Override
    public Page<ResidentResponse> findByFistName(String firstName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ResidentResponse> findByMiddleName(String middleName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ResidentResponse> findByLastName(String lastName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ResidentResponse> findByFirstNameAndMiddleName(String firstName, String middleName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ResidentResponse> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ResidentResponse> findByMiddleNameAndLastName(String middleName, String lastName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ResidentResponse> findByFullName(String firstName, String middleName, String lastName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ResidentResponse> findByRoomId(Long roomId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ResidentResponse> findByAgreementId(Long agreementId) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public ResidentResponse create(CreateResidentRequest createRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public ResidentResponse update(UpdateResidentRequest updateRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public ResidentResponse delete(Long id) {
        return null;
    }
}
