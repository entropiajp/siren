package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = DataListener.class)
@Table(name = "data")
public class Data {

    /**  */
    @Id
    @Column(name = "userId")
    String userid;

    /**  */
    @Column(name = "data")
    String data;

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
     * Returns the data.
     * 
     * @return the data
     */
    public String getData() {
        return data;
    }

    /** 
     * Sets the data.
     * 
     * @param data the data
     */
    public void setData(String data) {
        this.data = data;
    }
}