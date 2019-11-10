package com.spring.restful.users.app.common;

public interface UserURIs {
	String USER_API_ROOT = "/users";
	String USER_API_ROOT_BATCH = USER_API_ROOT + "/" + "batch";
	String USER_API_URI_BY_ID = USER_API_ROOT + "/" + "{id}";
	String GET_USER_BY_NAME_ID = USER_API_ROOT + "/" + "{name}/{id}";

}
