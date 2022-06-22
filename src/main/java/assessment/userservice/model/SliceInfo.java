package assessment.userservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SliceInfo implements Serializable {

	private static final long serialVersionUID = 1368220888871388590L;

	public SliceInfo(int number, boolean hasPrevious, boolean hasNext) {
		super();
		this.number = number;
		this.hasPrevious = hasPrevious;
		this.hasNext = hasNext;
	}

	@JsonProperty("number")
	private int number;
	
	@JsonProperty("hasPrevious")
	private boolean hasPrevious;
	
	@JsonProperty("hasNext")
	private boolean hasNext;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	@Override
	public String toString() {
		return "SliceInfo [number=" + number + ", hasPrevious=" + hasPrevious + ", hasNext=" + hasNext + "]";
	}
	
}
