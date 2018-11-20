package gists.crud;

import common.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static common.ApiConstant.*;

public class CreateCommentTest extends BaseTest {



    @Test
    public void emptyPostBodyTest() {
        given().
               spec(authorized).
               pathParam("gist_id", GIST_ID).
        when().
               post(COMMENTS_API_PATH).
        then().
               log().ifValidationFails().
               statusCode(422).
               body("errors[0].code", equalTo("missing_field")).
               body("errors[0].field", equalTo("body") );
    }

    /**
     * Strange behaviour from Gists API returning 404 when no authorized for creating comment.
     */
    @Test
    public void unathorizedUserTest() {
        given().
               spec(unauthorized).
               pathParam("gist_id", GIST_ID).
         when().
                post(COMMENTS_API_PATH).
         then().
               log().ifValidationFails().
               statusCode(404).
               body("message", equalTo("Not Found"));
    }

    @Test
    public void succesfullCreateTest() {

        Map<String, String> json = new HashMap<String, String>();
        json.put("body", "Automatic test body");

        given().
               spec(authorized).
               pathParam("gist_id", GIST_ID).
               body(json).
        when().
               post(COMMENTS_API_PATH).
        then().
               log().ifValidationFails().
               statusCode(201).
               body("body", equalTo(json.get("body")));

    }


}
