package com.vti.template3.specification;

import com.vti.template3.entity.Department;
import com.vti.template3.form.DepartmentFilterForm;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DepartmentSpecification {
    private static final String MIN_TOTAL_MEMBER = "minTotalMember";
    private static final String MAX_TOTAL_MEMBER = "maxTotalMember";

    public static Specification<Department> builWhere(DepartmentFilterForm form) {
        if(form == null) { return null; }

        Specification<Department> whereMinTotalMember = new SpecificationImpl(MIN_TOTAL_MEMBER, form.getMinTotalMember());
        Specification<Department> whereMaxTotalMember = new SpecificationImpl(MAX_TOTAL_MEMBER, form.getMaxTotalMember());

        return Specification.where(whereMinTotalMember).and(whereMaxTotalMember);
    }

    @AllArgsConstructor
    private static class SpecificationImpl implements Specification<Department> {
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (this.value == null) { return null; }

            switch (this.key) {
                case MIN_TOTAL_MEMBER -> {
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("totalMember"), value.toString());
                }
                case MAX_TOTAL_MEMBER -> {
                    return criteriaBuilder.lessThanOrEqualTo(root.get("totalMember"), value.toString());
                }
            }
            return null;
        }
    }
}
