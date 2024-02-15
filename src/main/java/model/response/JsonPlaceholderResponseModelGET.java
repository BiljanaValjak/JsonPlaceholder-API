package model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonPlaceholderResponseModelGET {

    int userId;
    int id;
    String title;
    String body;

}
