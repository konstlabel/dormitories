package com.konstl.dormitories.dormitory;

import com.konstl.dormitories.dormitory.dto.DormitorySearchDto;
import org.springframework.data.jpa.domain.Specification;

public class DormitorySpecification {

    public static Specification<Dormitory> bySearch(DormitorySearchDto dto) {

        return Specification.allOf(
                nameContains(dto.getName()),
                addressContains(dto.getAddress()));
    }

    private static Specification<Dormitory> nameContains(String value) {

        if (value == null || value.isBlank()) return null;
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("name")), "%" + value.toLowerCase() + "%");
    }

    private static Specification<Dormitory> addressContains(String value) {

        if (value == null || value.isBlank()) return null;
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("address")), "%" + value.toLowerCase() + "%");
    }
}
