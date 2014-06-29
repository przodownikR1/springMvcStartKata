package pl.java.borowiec.blog;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import pl.java.borowiec.category.Category;
import pl.java.borowiec.common.CommonEntity;
import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 29-03-2013 23:41:02
 */
@Entity
public class Blog extends CommonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 902110390321596640L;
	private String name;
	@ManyToOne
	private User owner;

	@ManyToOne
	private Category category;

	@OneToMany(mappedBy = "blog")
	private Set<BlogEntry> entries;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<BlogEntry> getEntries() {
		return entries;
	}

	public void setEntries(Set<BlogEntry> entries) {
		this.entries = entries;
	}

	// Bidirectional relaction
	public void addBlogEntry(BlogEntry blogEntry) {
		blogEntry.setBlog(this);
		entries.add(blogEntry);

	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
