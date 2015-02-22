package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = UserprofileListener.class)
@Table(name = "UserProfile")
public class Userprofile {

    /**  */
    @Id
    @Column(name = "userId")
    String userid;

    /**  */
    @Column(name = "email")
    String email;

    /**  */
    @Column(name = "firstName")
    String firstname;

    /**  */
    @Column(name = "lastName")
    String lastname;

    /**  */
    @Column(name = "name")
    String name;

    /**  */
    @Column(name = "username")
    String username;

    /** 
     * Returns the userid.
     * 
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /** 
     * Sets the userid.
     * 
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /** 
     * Returns the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Sets the email.
     * 
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Returns the firstname.
     * 
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /** 
     * Sets the firstname.
     * 
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /** 
     * Returns the lastname.
     * 
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /** 
     * Sets the lastname.
     * 
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /** 
     * Returns the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** 
     * Sets the name.
     * 
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Returns the username.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /** 
     * Sets the username.
     * 
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}