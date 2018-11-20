package gists.crud;

import common.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static common.ApiConstant.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateCommentTest extends BaseTest{

    @Test
    public void unauthorizedUserUpdateTest() {

        given().
                spec(unauthorized).
                pathParam("gist_id",GIST_ID).
                pathParam("comment_id",EDIT_COMMENT).
        when().
               patch(SINGLECOMMENT_API_PATH).
        then().
               log().ifValidationFails().
               statusCode(404).
               body("message", equalTo("Not Found"));
    }

    @Test
    public void successfullyUpdateTest() {

        Map<String, String> json = new HashMap<String, String>();
        json.put("body", "Automatic test updated body");

        given().
                spec(authorized).
                pathParam("gist_id",GIST_ID).
                pathParam("comment_id",EDIT_COMMENT).
                body(json).
        when().
               patch(SINGLECOMMENT_API_PATH).
        then().
               log().ifValidationFails().
               statusCode(200);
    }

    @Test
    public void wrongCommentIdUpdateTest() {

        Map<String, String> json = new HashMap<String, String>();
        json.put("body", "Automatic test body");


        given().
                spec(authorized).
                pathParam("gist_id",GIST_ID).
                pathParam("comment_id",123).
        when().
                patch(SINGLECOMMENT_API_PATH).
        then().
                log().ifValidationFails().
                statusCode(404).
                body("message", equalTo("Not Found"));
    }

}
