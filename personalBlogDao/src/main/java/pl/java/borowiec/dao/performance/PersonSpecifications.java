package pl.java.borowiec.dao.performance;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import pl.java.borowiec.performance_problem.Person;

public class PersonSpecifications {
	public static Specification<Person> lastNameIsLike(final String searchTerm) {
	       
        return new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> personRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
              personRoot.fetch("cars");
                String likePattern = getLikePattern(searchTerm);                
                return cb.like(cb.lower(personRoot.<String>get("name")), likePattern);
            }
           
            private String getLikePattern(final String searchTerm) {
                StringBuilder pattern = new StringBuilder();
                pattern.append(searchTerm.toLowerCase());
                pattern.append("%");
                return pattern.toString();
            }

			
        };
    }
}
