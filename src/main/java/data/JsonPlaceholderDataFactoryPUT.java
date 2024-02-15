package data;

import model.JsonPlaceholderModelPUT;

public class JsonPlaceholderDataFactoryPUT {

    private JsonPlaceholderModelPUT request;

    public JsonPlaceholderDataFactoryPUT(JsonPlaceholderModelPUT requestBody){
        request = requestBody;
    }

    public JsonPlaceholderDataFactoryPUT setTitle(String value){
        request.setTitle(value);
        return this;
    }
    public JsonPlaceholderDataFactoryPUT setBody(String value){
        request.setBody(value);
        return this;
    }
    public JsonPlaceholderModelPUT createRequest(){
        return request;
    }
}
