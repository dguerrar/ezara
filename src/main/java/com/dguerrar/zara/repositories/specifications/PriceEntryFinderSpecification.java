package com.dguerrar.zara.repositories.specifications;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.domain.PriceEntry;
import com.dguerrar.zara.domain.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PriceEntryFinderSpecification {


    public static Specification<PriceEntry> findBetweenDates(LocalDateTime inputDate){
        return new Specification<PriceEntry>(){
            public Predicate toPredicate(Root<PriceEntry> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>();
                Predicate onEnd = builder.greaterThanOrEqualTo(root.get("endDate"), inputDate);
                Predicate onStart = builder.lessThanOrEqualTo(root.get("startDate"), inputDate);
                predicates.add(onStart);
                predicates.add(onEnd);

                Predicate[] predicatesArray = new Predicate[predicates.size()];
                return builder.and(predicates.toArray(predicatesArray));

            }
        };
    }


    public static Specification<PriceEntry> findOnBrand(Long brandId){
        return new Specification<PriceEntry>(){
            public Predicate toPredicate(Root<PriceEntry> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

                Join<Brand, PriceEntry> brandJoin = root.join("brand");
                Predicate brandPred = builder.equal(brandJoin.get("id"), brandId);

                return brandPred;

            }
        };
    }


    public static Specification<PriceEntry> findOnProduct(Long productId){
        return new Specification<PriceEntry>(){
            public Predicate toPredicate(Root<PriceEntry> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

                Join<Product, PriceEntry> productJoin = root.join("product");
                Predicate productPred = builder.equal(productJoin.get("id"), productId);
                return productPred;

            }
        };
    }



}
