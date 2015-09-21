package com.trickytechnos.cdb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.Objects;

@Entity
@Table(name="CUSTOMER")
public class Customer extends BaseEntity implements Serializable {		

	/**
	 * 
	 */
	private static final long serialVersionUID = -2575693021838304518L;

	@NotNull(message= "{error.customer.firstname.null}")
	@NotEmpty(message="{error.customer.firstname.empty}")
	@Size(message="{error.customer.firstname.max}")
	@Column(name="FIRSTNAME",length= 50)
	private String firstName;
	
	@NotNull(message= "{error.customer.lastname.null}")
	@NotEmpty(message="{error.customer.lastname.empty}")
	@Size(max=50,message="{error.customer.lastname.max}")
	@Column(name="LASTNAME",length=50)
	private String lastName;
	
	@NotNull(message= "{error.customer.sex.null}")
	@NotEmpty(message="{error.customer.sex.empty}")
	@Column(name="SEX")
	private String sex;
	
	@NotNull(message= "{error.customer.mobileno.null}")
	@Size(max=10,message="{error.customer.mobileno.max}")
	@Column(name="MOBILENO",length=10)
	private String mobileNo;
	
	@Column(name="ADDRESS")
	private String address;			
	
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
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	 public String toString() {
	  return String.format("%s(id=%d, firstName='%s', lastName=%s, mobileno=%s, address=%s)", 
	    this.getClass().getSimpleName(), this.getId(), this.getFirstName(), this.getLastName(), this.getMobileNo(),this.getAddress());
	 }
	 
	 @Override
	 public boolean equals(Object o) {
	  if (this == o) return true;
	  if (o == null) return false;
	 
	  if (o instanceof Customer) {
	   final Customer other = (Customer) o;
	   return Objects.equal(getId(), other.getId()) && 
			Objects.equal(getFirstName(), other.getFirstName()) && 
			Objects.equal(getLastName(), other.getLastName()) &&
	   		Objects.equal(getMobileNo(), other.getMobileNo()) &&
	   		Objects.equal(getAddress(), other.getAddress());
	  }
	  return false;
	 }
	 
	 @Override
	 public int hashCode() {
	  return Objects.hashCode(getId(), getFirstName(), getLastName(),getMobileNo(),getAddress());
	 }

}
