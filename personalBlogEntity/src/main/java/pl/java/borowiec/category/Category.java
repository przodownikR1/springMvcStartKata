/**
 * Created on Oct 21, 2011
 */
package pl.java.borowiec.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.java.borowiec.common.PKEntity;

@Entity
@NoArgsConstructor


public class Category extends PKEntity {

  
    private static final long serialVersionUID = 1973248807698701154L;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;
    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
    private Set<Category> subCategories = new HashSet<>();

    public void addSubCategory(Category subcategory) {

        subcategory.setParentCategory(this);
        getSubCategories().add(subcategory);
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Category parentCategory, Set<Category> subCategories) {
        this.name = name;
        this.parentCategory = parentCategory;
        this.subCategories = subCategories;
    }

}
