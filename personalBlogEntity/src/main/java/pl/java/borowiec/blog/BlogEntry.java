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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotEmpty;

import pl.java.borowiec.common.PKEntity;
import pl.java.borowiec.tag.Tag;
import pl.java.borowiec.types.EntryState;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 29-03-2013 23:49:36
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
public class BlogEntry extends PKEntity{

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



}
