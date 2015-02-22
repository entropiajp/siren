package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = UserconnectionListener.class)
@Table(name = "UserConnection")
public class Userconnection {

    /**  */
    @Id
    @Column(name = "userId")
    String userid;

    /**  */
    @Id
    @Column(name = "providerId")
    String providerid;

    /**  */
    @Id
    @Column(name = "providerUserId")
    String provideruserid;

    /**  */
    @Column(name = "rank")
    Integer rank;

    /**  */
    @Column(name = "displayName")
    String displayname;

    /**  */
    @Column(name = "profileUrl")
    String profileurl;

    /**  */
    @Column(name = "imageUrl")
    String imageurl;

    /**  */
    @Column(name = "accessToken")
    String accesstoken;

    /**  */
    @Column(name = "secret")
    String secret;

    /**  */
    @Column(name = "refreshToken")
    String refreshtoken;

    /**  */
    @Column(name = "expireTime")
    Long expiretime;

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
     * Returns the providerid.
     * 
     * @return the providerid
     */
    public String getProviderid() {
        return providerid;
    }

    /** 
     * Sets the providerid.
     * 
     * @param providerid the providerid
     */
    public void setProviderid(String providerid) {
        this.providerid = providerid;
    }

    /** 
     * Returns the provideruserid.
     * 
     * @return the provideruserid
     */
    public String getProvideruserid() {
        return provideruserid;
    }

    /** 
     * Sets the provideruserid.
     * 
     * @param provideruserid the provideruserid
     */
    public void setProvideruserid(String provideruserid) {
        this.provideruserid = provideruserid;
    }

    /** 
     * Returns the rank.
     * 
     * @return the rank
     */
    public Integer getRank() {
        return rank;
    }

    /** 
     * Sets the rank.
     * 
     * @param rank the rank
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /** 
     * Returns the displayname.
     * 
     * @return the displayname
     */
    public String getDisplayname() {
        return displayname;
    }

    /** 
     * Sets the displayname.
     * 
     * @param displayname the displayname
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    /** 
     * Returns the profileurl.
     * 
     * @return the profileurl
     */
    public String getProfileurl() {
        return profileurl;
    }

    /** 
     * Sets the profileurl.
     * 
     * @param profileurl the profileurl
     */
    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    /** 
     * Returns the imageurl.
     * 
     * @return the imageurl
     */
    public String getImageurl() {
        return imageurl;
    }

    /** 
     * Sets the imageurl.
     * 
     * @param imageurl the imageurl
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /** 
     * Returns the accesstoken.
     * 
     * @return the accesstoken
     */
    public String getAccesstoken() {
        return accesstoken;
    }

    /** 
     * Sets the accesstoken.
     * 
     * @param accesstoken the accesstoken
     */
    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    /** 
     * Returns the secret.
     * 
     * @return the secret
     */
    public String getSecret() {
        return secret;
    }

    /** 
     * Sets the secret.
     * 
     * @param secret the secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /** 
     * Returns the refreshtoken.
     * 
     * @return the refreshtoken
     */
    public String getRefreshtoken() {
        return refreshtoken;
    }

    /** 
     * Sets the refreshtoken.
     * 
     * @param refreshtoken the refreshtoken
     */
    public void setRefreshtoken(String refreshtoken) {
        this.refreshtoken = refreshtoken;
    }

    /** 
     * Returns the expiretime.
     * 
     * @return the expiretime
     */
    public Long getExpiretime() {
        return expiretime;
    }

    /** 
     * Sets the expiretime.
     * 
     * @param expiretime the expiretime
     */
    public void setExpiretime(Long expiretime) {
        this.expiretime = expiretime;
    }
}