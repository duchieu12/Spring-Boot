//package com.vti.template3.specification;
//
//import com.vti.template3.entity.Department;
//import com.vti.template3.form.AccountFilterForm;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import lombok.AllArgsConstructor;
//import org.springframework.data.jpa.domain.Specification;
//
public class DepartmentSpecification {
//    private static final String MIN_TOTAL_MEMBER = "minTotalMember";
//    private static final String MAX_TOTAL_MEMBER = "maxTotalMember";
//
//    public static Specification<Department> builWhere(AccountFilterForm form) {
//        if(form == null) return null;
//
//        Specification<Department> whereMinTotalMember = new SpecificationImpl(MIN_TOTAL_MEMBER, form.getMinTotalMember());
//        Specification<Department> whereMaxTotalMember = new SpecificationImpl(MAX_TOTAL_MEMBER, form.getMaxTotalMember());
//        return Specification.where(whereMinTotalMember.and(whereMaxTotalMember));
//    }
//
//    @AllArgsConstructor
//    private static class SpecificationImpl implements Specification<Department> {
//        private String key;
//        private Object value;
//
//        @Override
//        public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//            if (value == null) { return null; }
//
//            switch (this.key) {
//                case MIN_TOTAL_MEMBER -> {
//                    return criteriaBuilder.greaterThanOrEqualTo(root.get("totalMember"), value.toString());
//                }
//                case MAX_TOTAL_MEMBER -> {
//                    return criteriaBuilder.lessThanOrEqualTo(root.get("totalMember"), value.toString());
//                }
//            }
//            return null;
//        }
//    }
}
