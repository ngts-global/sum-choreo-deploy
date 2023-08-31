package com.ngts.projects.scm.core.api.payload.response;

import java.util.List;

public class UserInfoResponse {
	private Integer id;
	private String username;
	private String email;
	private List<String> roles;
	private List<?> functionsList;
	private int timeoutValue;

	public UserInfoResponse(Integer id, String username, String email, List<String> roles, List<?> apiList, int timeoutValue) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.functionsList = apiList;
		this.timeoutValue = timeoutValue;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<?> getFunctionsList() {
		return functionsList;
	}

	public void setFunctionsList(List<?> functionsList) {
		this.functionsList = functionsList;
	}

	public int getTimeoutValue() {
		return timeoutValue;
	}

	public void setTimeoutValue(int timeoutValue) {
		this.timeoutValue = timeoutValue;
	}
}
