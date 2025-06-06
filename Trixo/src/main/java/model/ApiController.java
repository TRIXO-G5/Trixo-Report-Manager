package model;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class ApiController {

	private static final String API_URL = "http://143.47.51.248:43433/api/posts";
	
    public List<Post> getOnRevisionPosts(String status) {
    	Post[] posts = new Post[0];
    	try {
    		RestTemplate restTemplate = new RestTemplate();
    		posts = restTemplate.getForObject(API_URL + "/{status}/status", Post[].class, status);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return Arrays.asList(posts);
    }
    
    public void updatePostStatus(String postId, String status) {
    	try {
    	    RestTemplate restTemplate = new RestTemplate();
    	    String url = API_URL + "/" + postId + "/status/" + status;

    	    HttpHeaders headers = new HttpHeaders();
    	    headers.set("Content-Type", "application/json");

    	    HttpEntity<Void> entity = new HttpEntity<>(headers);

    	    restTemplate.exchange(url, HttpMethod.PUT, entity, Void.class);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
}
