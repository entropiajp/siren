package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = AuthoritiesListener.class)
@Table(name = "authorities")
public class Authorities {

    /**  */
    @Column(name = "username")
    String username;

    /**  */
    @Column(name = "authority")
    String authority;

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
     * Returns the authority.
     * 
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /** 
     * Sets the authority.
     * 
     * @param authority the authority
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}