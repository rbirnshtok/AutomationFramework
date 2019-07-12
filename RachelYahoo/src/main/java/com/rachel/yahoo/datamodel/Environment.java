package com.rachel.yahoo.datamodel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

	public class Environment {
		@JsonProperty("url")
		public String url;
		
		@JsonProperty("users")
		public Map<String, User> users;
		
		public static class User{
			
			@JsonProperty("username")
			public String username;
			
			@JsonProperty("password")
			public String password;
			
		}

	public static Environment get(String filename, String envname) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Environment> mapEnvironments = mapper.readValue(new File(filename), new TypeReference<Map<String,Environment>>(){});
		return mapEnvironments.get(envname.toUpperCase());
	}
}
