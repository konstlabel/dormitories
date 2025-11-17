package com.konstl.dormitories.dormitory;

import com.konstl.dormitories.dormitory.dto.CreateDormitoryRequest;
import com.konstl.dormitories.dormitory.dto.DormitoryResponse;
import com.konstl.dormitories.dormitory.dto.UpdateDormitoryRequest;
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
@RequestMapping("/api/dormitories")
public class DormitoryController {

    private final DormitoryService dormitoryService;

    public DormitoryController(DormitoryService dormitoryService) {

        this.dormitoryService = dormitoryService;
    }

    @GetMapping()
    public PageResponse<DormitoryResponse> findAll(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                   @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return dormitoryService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public DormitoryResponse findById(@PathVariable Long id) {

        return dormitoryService.findById(id);
    }

    @GetMapping("/search/name")
    public PageResponse<DormitoryResponse> findByName(@RequestParam String name,
                                                      @RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                      @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return dormitoryService.findByName(name, page, size);
    }

    @GetMapping("/search/address")
    public PageResponse<DormitoryResponse> findByAddress(@RequestParam String address,
                                                         @RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                         @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return dormitoryService.findByAddress(address, page, size);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DormitoryResponse> create(@Valid @RequestBody CreateDormitoryRequest request) {

        DormitoryResponse created = dormitoryService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public DormitoryResponse update(@PathVariable Long id, @Valid @RequestBody UpdateDormitoryRequest request) {

        return dormitoryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DormitoryResponse> delete(@PathVariable Long id) {

        DormitoryResponse deleted = dormitoryService.delete(id);
        return ResponseEntity.ok(deleted);
    }
}
