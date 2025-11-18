package com.konstl.dormitories.employee;

import com.konstl.dormitories.employee.dto.EmployeeSearchDto;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> bySearch(EmployeeSearchDto dto) {
        return Specification.allOf(
                nameContains(dto.getName()),
                phoneEquals(dto.getPhone()),
                dormitoryEquals(dto.getDormitoryId()),
                positionEquals(dto.getPositionId())
        );
    }

    private static Specification<Employee> nameContains(String name) {

        if (name == null || name.isBlank()) return null;

        String pattern = "%" + name.toLowerCase() + "%";

        return (root, query, cb) -> cb.or(
                cb.like(cb.lower(root.get("firstName")), pattern),
                cb.like(cb.lower(root.get("middleName")), pattern),
                cb.like(cb.lower(root.get("lastName")), pattern)
        );
    }

    private static Specification<Employee> phoneEquals(String phone) {

        if (phone == null || phone.isBlank()) return null;
        return (root, query, cb) ->
                cb.equal(root.get("phone"), "%" + phone + "%");
    }

    private static Specification<Employee> dormitoryEquals(Long dormitoryId) {

        if (dormitoryId == null) return null;
        return (root, query, cb) ->
                cb.equal(root.get("dormitory").get("id"), dormitoryId);
    }

    private static Specification<Employee> positionEquals(Long positionId) {

        if (positionId == null) return null;
        return (root, query, cb) ->
                cb.equal(root.get("position").get("id"), positionId);
    }
}
