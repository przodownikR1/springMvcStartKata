/**
 * 
 */
package pl.java.borowiec.blog;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import pl.java.borowiec.comment.Comment;
import pl.java.borowiec.common.CommonEntity;
import pl.java.borowiec.tag.Tag;
import pl.java.borowiec.types.EntryState;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 29-03-2013 23:49:36
 */
@Entity
public class BlogEntry extends CommonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7769035664900681837L;

	@ManyToOne
	private Blog blog;

	@NotEmpty
	@Min(10)
	@Max(4000)
	private String content;

	@NotEmpty
	@Size(min = 10, max = 255)
	private String title;

	private boolean allowComment;

	private Date publishDate;

	@NotEmpty
	@Min(3)
	private String author;

	@Enumerated(EnumType.STRING)
	private EntryState entryState;

	@Valid
	@OneToMany
	@JoinColumn(name = "entryId")
	private List<Tag> tags;

	@ManyToOne
	private Comment comment;

	public void addBlog(Blog blog) {

	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAllowComment() {
		return allowComment;
	}

	public void setAllowComment(boolean allowComment) {
		this.allowComment = allowComment;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public EntryState getEntryState() {
		return entryState;
	}

	public void setEntryState(EntryState entryState) {
		this.entryState = entryState;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
