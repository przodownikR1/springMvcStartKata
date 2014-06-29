package pl.java.borowiec.comment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import pl.java.borowiec.common.CommonEntity;
import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 30-03-2013 01:04:55
 */
@Entity
public class Comment extends CommonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	private Comment parent;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Comment> subComments = new ArrayList<Comment>();

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User owner;
	@NotEmpty
	@Size(min = 2, max = 20)
	private String userName;
	@NotEmpty
	@Size(min = 10, max = 255)
	private String title;
	@NotEmpty
	@Size(min = 10, max = 2000)
	private String content;

	public List<Comment> getSubComments() {
		return subComments;
	}

	public void addComment(Comment subComment) {
		subComment.addComment(this);
		this.addComment(subComment);
	}

	public void setSubComments(List<Comment> subComments) {
		this.subComments = subComments;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
