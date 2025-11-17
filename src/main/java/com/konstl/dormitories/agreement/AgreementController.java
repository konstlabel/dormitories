package com.konstl.dormitories.agreement;

import com.konstl.dormitories.agreement.dto.AgreementResponse;
import com.konstl.dormitories.agreement.dto.AgreementSearchDto;
import com.konstl.dormitories.agreement.dto.CreateAgreementRequest;
import com.konstl.dormitories.agreement.dto.UpdateAgreementRequest;
import com.konstl.dormitories.utils.PageResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agreements")
public class AgreementController {

    private final AgreementService agreementService;

    public AgreementController(AgreementService agreementService) {

        this.agreementService = agreementService;
    }

    @GetMapping()
    public PageResponse<AgreementResponse> findAll(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                   @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return agreementService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public AgreementResponse findById(@PathVariable Long id) {

        return agreementService.findById(id);
    }

    @GetMapping("/search")
    public PageResponse<AgreementResponse> search(@ModelAttribute AgreementSearchDto searchDto,
                                                  @RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                  @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return agreementService.search(searchDto, page, size);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    public ResponseEntity<AgreementResponse> create(@Valid @RequestBody CreateAgreementRequest createRequest) {

        AgreementResponse created = agreementService.create(createRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    public AgreementResponse update(@PathVariable Long id,
                                    @Valid @RequestBody UpdateAgreementRequest updateRequest) {

        return agreementService.update(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        agreementService.delete(id);
    }
}
