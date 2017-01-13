package xyz.codingmentor.firsteehomework.entities;

import xyz.codingmentor.firsteehomework.constraints.BirthdateExaminer;
import xyz.codingmentor.firsteehomework.constraints.NameExaminer;
import java.util.Date;
import java.util.Objects;
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
        @Pattern(regexp = ".*[a-z].*"),
        @Pattern(regexp = ".*[A-Z].*"),
        @Pattern(regexp = ".*[0-9=+<>.,].*")
    })
    private String password;

    private String firstname;
    private String lastname;

    @NotNull
    @Pattern(regexp = "^[0-9]{4}.*")
    private String address;

    @NotNull
    @Pattern(regexp = "(^06|^[+]36)\\d{9}")
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

    public UserEntity() {
        //empty on purpose
    }

    private UserEntity(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.sex = builder.sex;
        this.registrationDate = builder.registrationDate;
        this.lastModifiedDate = builder.lastModifiedDate;
        this.dateOfBirth = builder.dateOfBirth;
        this.admin = builder.admin;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.username);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.firstname);
        hash = 71 * hash + Objects.hashCode(this.lastname);
        hash = 71 * hash + Objects.hashCode(this.address);
        hash = 71 * hash + Objects.hashCode(this.phone);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.sex);
        hash = 71 * hash + Objects.hashCode(this.registrationDate);
        hash = 71 * hash + Objects.hashCode(this.lastModifiedDate);
        hash = 71 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 71 * hash + (this.admin ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserEntity other = (UserEntity) obj;
        if (this.admin != other.admin) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        if (!Objects.equals(this.registrationDate, other.registrationDate)) {
            return false;
        }
        if (!Objects.equals(this.lastModifiedDate, other.lastModifiedDate)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;

    }


    public static class Builder {

        private String username;
        private String password;
        private String firstname;
        private String lastname;
        private String address;
        private String phone;
        private String email;
        private SexEnum sex;
        private Date registrationDate;
        private Date lastModifiedDate;
        private Date dateOfBirth;
        private boolean admin;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }


        public Builder sexEnum(SexEnum sex) {

            this.sex = sex;
            return this;
        }

        public Builder registrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder lastModifiedDate(Date lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder admin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
