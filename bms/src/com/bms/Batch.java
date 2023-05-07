package com.bms;
import java.io.*;
import java.util.Objects;
public class Batch implements Serializable {

	int BatchID;
	String courseName;
	int seats;
	String startDate;
	String duration;
	
	Batch(){
		super();
	}
	Batch(int b,String a,int s,String sd,String du){
		this.BatchID=b;
		this.courseName=a;
		this.seats=s;
		this.startDate=sd;
		this.duration=du;
	}

	public int getBatchID() {
		return BatchID;
	}

	public void setBatchID(int batchID) {
		BatchID = batchID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Batch [BatchID=" + BatchID + ", courseName=" + courseName + ", seats=" + seats + ", startDate="
				+ startDate + ", duration=" + duration + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(BatchID, courseName, duration, seats, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		return BatchID == other.BatchID && Objects.equals(courseName, other.courseName)
				&& Objects.equals(duration, other.duration) && seats == other.seats
				&& Objects.equals(startDate, other.startDate);
	}
	
}
