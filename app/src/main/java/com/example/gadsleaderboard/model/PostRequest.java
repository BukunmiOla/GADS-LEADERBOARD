package com.example.gadsleaderboard.model;

import com.google.gson.annotations.SerializedName;

public class PostRequest{

	@SerializedName("entry.1877115667")
	private String name;

	@SerializedName("entry.2006916086")
	private String lastName;

	@SerializedName("entry.1824927963")
	private String mail;

	@SerializedName("entry.284483984")
	private String projectLink;


	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return name;
	}

	public String getProjectLink() {
		return projectLink;
	}

	public String getMail() {
		return mail;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setProjectLink(String projectLink){
		this.projectLink = projectLink;
	}

	public void setMail(String mail){
		this.mail = mail;
	}

}