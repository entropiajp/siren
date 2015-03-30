package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = RoleListener.class)
@Table(name = "role")
public class Role {

    /** ロールID */
    @Id
    @Column(name = "role_id")
    Integer roleId;

    /** メンバID */
    @Column(name = "member_id")
    Integer memberId;

    /** 演奏曲ID */
    @Column(name = "song_id")
    Integer songId;

    /** ロール名 */
    @Column(name = "name")
    String name;

    /** 必須フラグ */
    @Column(name = "is_required")
    Short isRequired;

    /** 
     * Returns the roleId.
     * 
     * @return the roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /** 
     * Sets the roleId.
     * 
     * @param roleId the roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /** 
     * Returns the memberId.
     * 
     * @return the memberId
     */
    public Integer getMemberId() {
        return memberId;
    }

    /** 
     * Sets the memberId.
     * 
     * @param memberId the memberId
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /** 
     * Returns the songId.
     * 
     * @return the songId
     */
    public Integer getSongId() {
        return songId;
    }

    /** 
     * Sets the songId.
     * 
     * @param songId the songId
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
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
     * Returns the isRequired.
     * 
     * @return the isRequired
     */
    public Short getIsRequired() {
        return isRequired;
    }

    /** 
     * Sets the isRequired.
     * 
     * @param isRequired the isRequired
     */
    public void setIsRequired(Short isRequired) {
        this.isRequired = isRequired;
    }
}