package com.konstl.dormitories.registration;

import com.konstl.dormitories.employee.EmployeeRepository;
import com.konstl.dormitories.payment.PaymentRepository;
import com.konstl.dormitories.registration.dto.CreateRegistrationRequest;
import com.konstl.dormitories.registration.dto.RegistrationResponse;
import com.konstl.dormitories.utils.PageResponse;
import com.konstl.dormitories.visit.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RegistrationServiceImpl implements RegistrationService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final RegistrationRepository registrationRepository;
    private final VisitRepository visitRepository;
    private final PaymentRepository paymentRepository;
    private final EmployeeRepository employeeRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository,
                                   VisitRepository visitRepository,
                                   PaymentRepository paymentRepository,
                                   EmployeeRepository employeeRepository) {

        this.registrationRepository = registrationRepository;
        this.visitRepository = visitRepository;
        this.paymentRepository = paymentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public RegistrationResponse findById(Long id) {
        return null;
    }

    @Override
    public PageResponse<RegistrationResponse> findAll(int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RegistrationResponse> findByVisitId(Long visitId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RegistrationResponse> findByPaymentId(Long paymentId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RegistrationResponse> findByEmployee(Long employeeId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RegistrationResponse> findByVisitIdAndPaymentId(Long visitId, Long paymentId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RegistrationResponse> findByVisitIdAndEmployeeId(Long visitId, Long employeeId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RegistrationResponse> findByPaymentIdAndEmployeeId(Long paymentId, Long employeeId, int page, int size) {
        return null;
    }

    @Override
    public RegistrationResponse findByVisitIdAndPaymentIdAndEmployeeId(Long visitId, Long paymentId, Long employeeId) {
        return null;
    }

    @Override
    public RegistrationResponse create(CreateRegistrationRequest createRequest) {
        return null;
    }

    @Override
    public RegistrationResponse delete(Long id) {
        return null;
    }
}
