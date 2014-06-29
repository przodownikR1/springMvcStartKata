package pl.java.borowiec.service.category.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.category.Category;
import pl.java.borowiec.controller.blog.BlogController;
import pl.java.borowiec.dao.category.CategoryDao;
import pl.java.borowiec.service.category.CategoryService;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  03-04-2013 23:48:01
 
 */
@Service
@Transactional(readOnly=true)
public class CategoryServiceImpl implements CategoryService {
	static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Autowired
	private CategoryDao categoryDao;
    
	@Override
	@Transactional
	public Category saveCategory(Category category) {
		return categoryDao.save(category);
	}

	@Override
	public Set<Category> getCategoryList(Category category) {
		if(!isCategoryRoot(category)){
			return  Collections.emptySet();
		}
		return categoryDao.findOne(category.getId()).getSubCategories();
	}

	@Override
	public Category removeCategory(Category category) {
		throw new NotImplementedException();
	}

	@Override
	public void addNewSubCategory(Category subCategory) {
		throw new NotImplementedException();
		
	}

	@Override
	public boolean isCategoryRoot(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
