package pl.java.borowiec.blog;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.java.borowiec.category.Category;
import pl.java.borowiec.common.PKEntity;
import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 29-03-2013 23:41:02
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class Blog extends PKEntity {

    /**
	 * 
	 */
    private static final long serialVersionUID = 902110390321596640L;
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_owner")
    private User owner;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "blog")
    private Set<BlogEntry> entries;

    // Bidirectional relaction
    public void addBlogEntry(BlogEntry blogEntry) {
        blogEntry.setBlog(this);
        entries.add(blogEntry);

    }

}
