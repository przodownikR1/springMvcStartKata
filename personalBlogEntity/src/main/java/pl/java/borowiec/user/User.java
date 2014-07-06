package pl.java.borowiec.user;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pl.java.borowiec.address.Address;
import pl.java.borowiec.common.PKEntity;
import pl.java.borowiec.def.RegExp;
import pl.java.borowiec.types.Sex;


@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class User extends PKEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2568392223581909126L;

	private String login;

	private String firstName;

	private String lastName;

	private String password;
	
	@Transient
	private String confirmPassword;

	private boolean active;

	@Embedded
	@Valid
	@NotNull
	@AttributeOverrides({ @AttributeOverride(name = "country", column = @Column(name = "USER_COUNRTY")),
			@AttributeOverride(name = "street", column = @Column(name = "USER_STREET")),
			@AttributeOverride(name = "town", column = @Column(name = "USER_TOWN")),
			@AttributeOverride(name = "streetNumber", column = @Column(name = "USER_STREET_NUMBER"))

	})
	private Address address;

	@Size(min = 5, max = 50)
	@Pattern(regexp = RegExp.EMAIL_REGEX)
	@Column(nullable = false, length = 50)
	private String email;

	@NotNull
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Sex sex;

	@NotNull
	@Past
	@Basic(fetch = FetchType.LAZY)
	private Date birthDate;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;

	@NotNull
	@Size(min = 6, max = 11)
	@Pattern(regexp = ".+")
	@Column(nullable = false, length = 11)
	private String phoneNumber;

	
	@Column(length = 20)
	@Size(min = 4, max = 20)
	@Basic(fetch = FetchType.LAZY)
	private String ip;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "roleId") })
	// @IndexColumn(base = 0, name = "idx", nullable = false)
	@Valid
	private List<UserRole> roles = new LinkedList<>();

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthoritiesSet = new HashSet<>(getRoles().size());
		for (UserRole role : getRoles()) {
			grantedAuthoritiesSet.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return grantedAuthoritiesSet;
	}

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	

}
