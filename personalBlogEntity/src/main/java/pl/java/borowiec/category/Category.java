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

import pl.java.borowiec.common.CommonEntity;

@Entity
public class Category extends CommonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1973248807698701154L;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_CATEGORY_ID")
	private Category parentCategory;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
	private Set<Category> subCategories = new HashSet<Category>();

	public Category() {
	}

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

	public Category getParentCategory() {
		return this.parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<Category> getSubCategories() {
		return this.subCategories;
	}

	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + "  ]";
	}

}
