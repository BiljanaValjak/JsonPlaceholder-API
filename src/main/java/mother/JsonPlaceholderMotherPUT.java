package mother;

import model.JsonPlaceholderModelPUT;

public class JsonPlaceholderMotherPUT {

    public static JsonPlaceholderModelPUT createBodyForPut(){
        return JsonPlaceholderModelPUT.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
