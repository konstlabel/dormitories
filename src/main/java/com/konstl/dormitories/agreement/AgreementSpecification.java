package com.konstl.dormitories.agreement;

import com.konstl.dormitories.agreement.dto.AgreementSearchDto;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AgreementSpecification {

    public static Specification<Agreement> withSearch(AgreementSearchDto dto) {

        return Specification.allOf(
                moveInDateFrom(dto.getMoveInDateFrom()),
                moveInDateTo(dto.getMoveInDateTo()),
                evictionDateFrom(dto.getEvictionDateFrom()),
                evictionDateTo(dto.getEvictionDateTo()),
                costMin(dto.getCostMin()),
                costMax(dto.getCostMax())
        );
    }

    private static Specification<Agreement> moveInDateFrom(LocalDate date) {

        if (date == null) return null;
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("moveInDate"), date);
    }

    private static Specification<Agreement> moveInDateTo(LocalDate date) {

        if (date == null) return null;
        return (root, query, cb) ->
                cb.lessThanOrEqualTo(root.get("moveInDate"), date);
    }

    private static  Specification<Agreement> evictionDateFrom(LocalDate date) {

        if (date == null) return null;
        return (root, queary, cb) ->
                cb.greaterThanOrEqualTo(root.get("evictionDate"), date);
    }

    private static  Specification<Agreement> evictionDateTo(LocalDate date) {

        if (date == null) return null;
        return (root, queary, cb) ->
                cb.lessThanOrEqualTo(root.get("evictionDate"), date);
    }

    private static Specification<Agreement> costMin(BigDecimal cost) {

        if (cost == null) return null;
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("cost"), cost);
    }

    private static Specification<Agreement> costMax(BigDecimal cost) {

        if (cost == null) return null;
        return (root, query, cb) ->
                cb.lessThanOrEqualTo(root.get("cost"), cost);
    }

}
