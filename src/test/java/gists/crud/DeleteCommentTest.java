package gists.crud;

import common.BaseTest;
import org.testng.annotations.Test;

import static common.ApiConstant.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteCommentTest extends BaseTest {


    @Test
    public void unauthorizedUserDeleteTest() {
        given().
                spec(unauthorized).
                pathParam("gist_id", GIST_ID).
                pathParam("comment_id", DELETE_COMMENT).
        when().
                delete(SINGLECOMMENT_API_PATH).
        then().
                log().ifValidationFails().
                statusCode(404).
                body("message", equalTo("Not Found"));
    }

    @Test
    public void successfullDeleteTest() {

        given().
                spec(authorized).
                pathParam("gist_id", GIST_ID).
                pathParam("comment_id", DELETE_COMMENT).
        when().
                delete(SINGLECOMMENT_API_PATH).
        then().
                log().ifValidationFails().
                statusCode(204);

    }

    @Test
    public void wrongCommentIdDelete() {

        given().
                spec(authorized).
                pathParam("gist_id", GIST_ID).
                pathParam("comment_id", 123).
        when().
                delete(SINGLECOMMENT_API_PATH).
        then().
                log().ifValidationFails().
                statusCode(404).
                body("message", equalTo("Not Found"));

    }


}
