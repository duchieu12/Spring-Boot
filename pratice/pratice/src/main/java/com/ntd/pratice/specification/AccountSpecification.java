package com.ntd.pratice.specification;
import com.ntd.pratice.entity.Account;
import com.ntd.pratice.form.AccountFilterForm;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpecification {
    private static final String FIRSTNAME = "firstName";

    public static Specification<Account> buildWhere(AccountFilterForm form) {
        if (form == null) { return null; }

        Specification<Account> whereUsername = new SpecificationImpl(FIRSTNAME, form.getSearch());

        return Specification.where(whereUsername);
    }

    @AllArgsConstructor
    private static class SpecificationImpl implements Specification<Account> {
        private String key;
        private Object value;

        @Override
        public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if (this.value == null) { return null; }

            switch (this.key) {
                case FIRSTNAME:
//                    firstname LIKE %value%
                    return criteriaBuilder.like(root.get("firstName"), "%" + value + "%");
            }
            return null;
        }
    }
}