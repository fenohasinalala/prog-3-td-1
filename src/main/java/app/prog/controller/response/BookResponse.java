package app.prog.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/*@JsonPropertyOrder({
        BookResponse.JSON_PROPERTY_ID,
        BookResponse.JSON_PROPERTY_AUTHOR,
        BookResponse.JSON_PROPERTY_TITLE,
        BookResponse.JSON_PROPERTY_HASAUTHOR
})

 */


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookResponse {
    private Long id;
    private List<Long> authors_id;
    private String title;;
    private boolean hasAuthor;
}
