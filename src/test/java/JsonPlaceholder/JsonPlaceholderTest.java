package JsonPlaceholder;

import client.JsonPlaceholderClient;
import data.JsonPlaceholderDataFactoryPOST;
import data.JsonPlaceholderDataFactoryPUT;
import io.restassured.response.Response;
import model.request.JsonPlaceholderRequestModelPOST;
import model.JsonPlaceholderModelPUT;
import model.response.*;
import org.junit.Test;

import java.util.List;

import static mother.JsonPlaceholderMotherPOST.createBodyForPost;
import static mother.JsonPlaceholderMotherPUT.createBodyForPut;
import static org.junit.Assert.*;

public class JsonPlaceholderTest {

    String titleById = "optio molestias id quia eum";
    String bodyById = "quo et expedita modi cum officia vel magni\ndoloribus qui repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error";


    @Test
    public void getAllRequestJsonPlaceholderTest() {

        Response getAllResponse = new JsonPlaceholderClient().getAllPosts();

        List<JsonPlaceholderResponseModelGET> jsonPlaceholderResponse = getAllResponse
                .body()
                .jsonPath()
                .getList("", JsonPlaceholderResponseModelGET.class);

        assertEquals(200, getAllResponse.statusCode());
        assertFalse(jsonPlaceholderResponse.isEmpty());
    }
        @Test
    public void getByIdRequestJsonPlaceholderTest(){

        Response responseById = new JsonPlaceholderClient()
                .getPostsById("10");
        JsonPlaceholderResponseModelGET jsonPlaceholderResponse = responseById.body().as(JsonPlaceholderResponseModelGET.class);

        assertEquals(200, responseById.statusCode());
        assertEquals(1, jsonPlaceholderResponse.getUserId());
        assertEquals(10, jsonPlaceholderResponse.getId());
        assertEquals(titleById, jsonPlaceholderResponse.getTitle());
        assertEquals(bodyById, jsonPlaceholderResponse.getBody());
    }
    @Test
    public void postRequestJsonPlaceholderDefaultValuesTest(){
        JsonPlaceholderRequestModelPOST request = new JsonPlaceholderDataFactoryPOST(createBodyForPost())
                .setTitle("Default title")
                .setBody("Default body")
                .createRequest();
        Response postResponse = new JsonPlaceholderClient()
                .postNewPost(request);
        JsonPlaceholderResponseModelPOST responseJsonPlaceholder = postResponse.body().as(JsonPlaceholderResponseModelPOST.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Default title", responseJsonPlaceholder.getTitle());
        assertEquals("Default body", responseJsonPlaceholder.getBody());
    }
    @Test
    public void postRequestJsonPlaceholderTest(){

        JsonPlaceholderRequestModelPOST request = new JsonPlaceholderDataFactoryPOST(createBodyForPost())
                .setTitle("Makedonija osvoi svetsko prvenstvo vo fudbal")
                .setBody("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid")
                .createRequest();
        Response postResponse = new JsonPlaceholderClient()
                .postNewPost(request);
        JsonPlaceholderResponseModelPOST responseJsonPlaceholder = postResponse.body().as(JsonPlaceholderResponseModelPOST.class);

        assertEquals(201, postResponse.statusCode());
        assertEquals("Makedonija osvoi svetsko prvenstvo vo fudbal", responseJsonPlaceholder.getTitle());
        assertEquals("Noviot svetski prvak Makedonija go osvoi svetskoto prvenstvo vo fudbal odrzano vo Madrid", responseJsonPlaceholder.getBody());
    }
    @Test
    public void putRequestJsonPlaceholderDefaultValuesTest(){
        JsonPlaceholderModelPUT request = new JsonPlaceholderDataFactoryPUT(createBodyForPut())
                .setTitle("Default title")
                .setBody("Default body")
                .createRequest();
        Response postResponse = new JsonPlaceholderClient()
                .updatePost(request, "12");
        JsonPlaceholderModelPUT responseJsonPlaceholder = postResponse.body().as(JsonPlaceholderModelPUT.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("Default title", responseJsonPlaceholder.getTitle());
        assertEquals("Default body", responseJsonPlaceholder.getBody());
    }
    @Test
    public void putRequestJsonPlaceholderTest(){

        JsonPlaceholderModelPUT request = new JsonPlaceholderDataFactoryPUT(createBodyForPut())
                .setTitle("The magic of Bilingual education")
                .setBody("Seven educators and one former student on how learning another language can change lives.")
                .createRequest();
        Response putResponse = new JsonPlaceholderClient()
                .updatePost(request, "12");
        JsonPlaceholderModelPUT responseJsonPlaceholder = putResponse.body().as(JsonPlaceholderModelPUT.class);

        assertEquals(200, putResponse.getStatusCode());
        assertEquals("The magic of Bilingual education", responseJsonPlaceholder.getTitle());
        assertEquals("Seven educators and one former student on how learning another language can change lives.", responseJsonPlaceholder.getBody());
    }
    @Test
    public void deleteRequestJsonPlaceholderTest(){

        Response deleteResponse = new JsonPlaceholderClient()
                .deletePost( "12");

        assertEquals(200, deleteResponse.getStatusCode());
    }
}

