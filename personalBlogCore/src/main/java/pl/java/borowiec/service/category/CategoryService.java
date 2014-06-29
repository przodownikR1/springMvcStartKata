package pl.java.borowiec.service.category;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.category.Category;

@Service
@Transactional(readOnly=true)
public interface CategoryService {

	Category saveCategory(Category category);
	
	Set<Category> getCategoryList(Category category);
	
	Category removeCategory(Category category);
	
	void addNewSubCategory(Category subCategory);
	
	boolean isCategoryRoot(Category category);
	
}
