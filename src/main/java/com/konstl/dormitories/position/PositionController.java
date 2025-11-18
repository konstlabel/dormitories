package com.konstl.dormitories.position;

import com.konstl.dormitories.position.dto.PositionResponse;
import com.konstl.dormitories.position.dto.PositionSearchDto;
import com.konstl.dormitories.utils.PageResponse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {

        this.positionService = positionService;
    }

    @GetMapping
    public PageResponse<PositionResponse> findAll(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                  @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return positionService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public PositionResponse findById(@PathVariable Long id) {

        return positionService.findById(id);
    }

    @GetMapping("/name/{name}")
    public PageResponse<PositionResponse> findByName(@PathVariable String name,
                                                     @RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                     @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return positionService.findByName(name, page, size);
    }

    @GetMapping("/search")
    public PageResponse<PositionResponse> findBySalary(@ModelAttribute PositionSearchDto dto,
                                                       @RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                       @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return positionService.search(dto, page, size);
    }

}
