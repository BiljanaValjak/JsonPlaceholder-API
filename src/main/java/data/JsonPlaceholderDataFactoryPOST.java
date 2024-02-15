package data;

import model.request.JsonPlaceholderRequestModelPOST;

public class JsonPlaceholderDataFactoryPOST {

    private JsonPlaceholderRequestModelPOST request;

    public JsonPlaceholderDataFactoryPOST(JsonPlaceholderRequestModelPOST requestBody){
        request = requestBody;
    }

    public JsonPlaceholderDataFactoryPOST setTitle(String value){
        request.setTitle(value);
        return this;
    }
    public JsonPlaceholderDataFactoryPOST setBody(String value){
        request.setBody(value);
        return this;
    }
    public JsonPlaceholderRequestModelPOST createRequest(){
        return request;
    }
}
