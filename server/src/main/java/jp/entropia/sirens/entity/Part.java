package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = PartListener.class)
@Table(name = "part")
public class Part {

    /** 楽器歌唱パートID */
    @Id
    @Column(name = "part_id")
    Integer partId;

    /** パート名 */
    @Column(name = "name")
    String name;

    /** 
     * Returns the partId.
     * 
     * @return the partId
     */
    public Integer getPartId() {
        return partId;
    }

    /** 
     * Sets the partId.
     * 
     * @param partId the partId
     */
    public void setPartId(Integer partId) {
        this.partId = partId;
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
}