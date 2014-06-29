

package pl.java.borowiec.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.AssertTrue;

import pl.java.borowiec.common.CommonEntity;


/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogEntity
 * Creating time :  10-04-2013 22:53:30
 
 */
@Entity
public class Activation extends CommonEntity{
  
	private static final long serialVersionUID = -7472117855421108413L;

	
	private String emailLogin;
	

	private String activationLink;
	

	private String password;
	
	private String confirmPassword;
	

	private String captcha;
	
	@AssertTrue(message="activation.privacyPolicy.true")
	@Column(nullable = false, name = "PrivacyPolicy")
	private boolean privacyPolicy = false;

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public boolean isPrivacyPolicy() {
		return privacyPolicy;
	}

	public void setPrivacyPolicy(boolean privacyPolicy) {
		this.privacyPolicy = privacyPolicy;
	}

	public String getActivationLink() {
		return activationLink;
	}

	public void setActivationLink(String activationLink) {
		this.activationLink = activationLink;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	
	
}
	
	
