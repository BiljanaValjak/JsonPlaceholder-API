package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.request.JsonPlaceholderRequestModelPOST;
import model.JsonPlaceholderModelPUT;
import util.Configuration;

public class JsonPlaceholderClient {
    public Response getAllPosts(){
        return RestAssured
                .given()
                .when().log().all()
                .get(Configuration.JSONPLACEHOLDER_BASE_URL)
                .thenReturn();
    }

    public Response getPostsById(String id){
        return RestAssured
                .given()
                .when().log().all()
                .get(Configuration.JSONPLACEHOLDER_BASE_URL + "/" + id)
                .thenReturn();
    }
    public Response postNewPost(JsonPlaceholderRequestModelPOST request){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Configuration.JSONPLACEHOLDER_BASE_URL)
                .thenReturn();
    }
    public Response updatePost(JsonPlaceholderModelPUT request, String id){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .put(Configuration.JSONPLACEHOLDER_BASE_URL + "/" + id)
                .thenReturn();
    }
    public Response deletePost(String id){
        return RestAssured
                .given()
                .when().log().all()
                .delete(Configuration.JSONPLACEHOLDER_BASE_URL + "/" + id)
                .thenReturn();
    }

}
