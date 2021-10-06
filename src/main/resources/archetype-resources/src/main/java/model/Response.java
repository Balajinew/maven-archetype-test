package ${package}.model;

import org.springframework.stereotype.Component;

@Component
public class Response {

	String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
}
