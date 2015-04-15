package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

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
    @Column(name = "required")
    boolean required;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * Returns the required.
     * 
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /** 
     * Sets the required.
     * 
     * @param required the required
     */
    public void setRequired(boolean required) {
        this.required = required;
    }
}