package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = UsersListener.class)
@Table(name = "users")
public class Users {

    /**  */
    @Id
    @Column(name = "username")
    String username;

    /**  */
    @Column(name = "password")
    String password;

    /**  */
    @Column(name = "enabled")
    int enabled;

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

    /** 
     * Returns the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Sets the password.
     * 
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * Returns the enabled.
     * 
     * @return the enabled
     */
    public int getEnabled() {
        return enabled;
    }

    /** 
     * Sets the enabled.
     * 
     * @param enabled the enabled
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}