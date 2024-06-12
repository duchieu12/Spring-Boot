package com.vti.template3.specification;

import com.vti.template3.entity.Account;
import com.vti.template3.form.AccountFilterForm;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpecification {
    private static final String USERNAME = "username";
    private static final String DEPARTMENT_NAME = "departmentName";
    private static final String MIN_ID = "minId";

    public static Specification<Account> buildWhere(AccountFilterForm form) {
        if (form == null) { return null; }

        Specification<Account> whereUsername = new SpecificationImpl(USERNAME, form.getSearch());
//        Specification<Account> whereDepartmentName = new SpecificationImpl(DEPARTMENT_NAME, form.getSearch());
        Specification<Account> whereMinId = new SpecificationImpl(MIN_ID, form.getMinId());

//        return Specification.where(whereUsername.or(whereDepartmentName)).and(whereMinId);
        return Specification.where(whereMinId).and(whereUsername);
    }

    @AllArgsConstructor
    private static class SpecificationImpl implements Specification<Account> {
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (this.value == null) { return null; }

            switch (this.key) {
                case USERNAME:
//                    username LIKE %value%
                    return criteriaBuilder.like(root.get("username"), "%" + value + "%");
                case MIN_ID:
//                    id >= value
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
                case DEPARTMENT_NAME:
                    return criteriaBuilder.like(root.get("department").get("name"), "%" + value + "%");
            }
            return null;
        }
    }
}
