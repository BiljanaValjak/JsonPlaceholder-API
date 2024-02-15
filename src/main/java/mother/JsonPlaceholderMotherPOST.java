package mother;

import model.request.JsonPlaceholderRequestModelPOST;

public class JsonPlaceholderMotherPOST {
    public static JsonPlaceholderRequestModelPOST createBodyForPost(){
        return JsonPlaceholderRequestModelPOST.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
