package com.konstl.dormitories.resident;

import com.konstl.dormitories.agreement.AgreementRepository;
import com.konstl.dormitories.resident.dto.CreateResidentRequest;
import com.konstl.dormitories.resident.dto.ResidentResponse;
import com.konstl.dormitories.resident.dto.UpdateResidentRequest;
import com.konstl.dormitories.room.RoomRepository;
import com.konstl.dormitories.utils.PageResponse;
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
    public PageResponse<ResidentResponse> findByFirstName(String firstName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<ResidentResponse> findByMiddleName(String middleName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<ResidentResponse> findByLastName(String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<ResidentResponse> findByFirstNameAndMiddleName(String firstName, String middleName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<ResidentResponse> findByFirstNameAndLastName(String firstName, String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<ResidentResponse> findByMiddleNameAndLastName(String middleName, String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<ResidentResponse> findByFullName(String firstName, String middleName, String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<ResidentResponse> findByRoomId(Long roomId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<ResidentResponse> findByAgreementId(Long agreementId, int page, int size) {
        return null;
    }

    @Override
    public ResidentResponse create(CreateResidentRequest createRequest) {
        return null;
    }

    @Override
    public ResidentResponse update(UpdateResidentRequest updateRequest) {
        return null;
    }

    @Override
    public ResidentResponse delete(Long id) {
        return null;
    }
}
