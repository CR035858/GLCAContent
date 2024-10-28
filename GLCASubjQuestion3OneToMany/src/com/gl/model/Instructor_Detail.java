package com.gl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Instructor_detail")
public class Instructor_Detail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="youtubeChannel")
	String youtubeChannel;	
	
	@Column(name="hobby")
	String hobby;

	
	public Instructor_Detail() {
		super();
	}


	public Instructor_Detail(int id, String youtubeChannel, String hobby) {
		super();
		this.id = id;
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getYoutubeChannel() {
		return youtubeChannel;
	}


	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	@Override
	public String toString() {
		return "Instructor_Detail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
}
