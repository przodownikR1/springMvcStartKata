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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pl.java.borowiec.address.Address;
import pl.java.borowiec.common.CommonEntity;
import pl.java.borowiec.def.RegExp;
import pl.java.borowiec.types.Sex;


/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 10-03-2013 23:27:55
 */
@Entity
public class User extends CommonEntity implements UserDetails {

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

	/** The ip. */
	@Column(length = 20)
	@Size(min = 4, max = 20)
	@Basic(fetch = FetchType.LAZY)
	private String ip;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "roleId") })
	// @IndexColumn(base = 0, name = "idx", nullable = false)
	@Valid
	private List<UserRole> roles = new LinkedList<UserRole>();

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthoritiesSet = new HashSet<GrantedAuthority>(getRoles().size());
		for (UserRole role : getRoles()) {
			grantedAuthoritiesSet.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return grantedAuthoritiesSet;
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
