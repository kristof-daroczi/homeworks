package xyz.codingmentor.firsteehomework.entities;

import xyz.codingmentor.firsteehomework.constraints.BirthdateExaminer;
import xyz.codingmentor.firsteehomework.constraints.NameExaminer;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Krisz
 */
@NameExaminer
@BirthdateExaminer
public class UserEntity {

    @NotNull
    @Size(min = 6)
    private String username;

    @NotNull
    @Size(min = 6)
    @Pattern.List({
        @Pattern(regexp = ".*[a-z].*")
        ,
        @Pattern(regexp = ".*[A-Z].*")
        ,
        @Pattern(regexp = ".*[0-9=+<>.,].*")
    })
    private String password;

    
    private String firstname;
    private String lastname;

    @NotNull
    @Pattern(regexp = "^[0-9]{4}.*")
    private String address;
    
    @NotNull
    @Pattern(regexp="(^06|^[+]36)\\d{9}")
    private String phone;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z-.]+$")
    private String email;
    
    private SexEnum sex;

    @NotNull
    @Past
    private Date registrationDate;

    @NotNull
    @Past
    private Date lastModifiedDate;
    
    private Date dateOfBirth;
    private boolean admin;

   
    UserEntity() {
      
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
