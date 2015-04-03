package jp.entropia.sirens.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity
public class VoteResult {

	@Column(name = "tune_id")
	Integer tuneId;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "count")
	Integer count;

	public Integer getTuneId() {
		return tuneId;
	}

	public void setTuneId(Integer tuneId) {
		this.tuneId = tuneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
