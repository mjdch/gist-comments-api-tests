package gists.crud;

import common.BaseTest;
import org.testng.annotations.Test;

import static common.ApiConstant.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetCommentTest extends BaseTest{


    @Test
    public void getCommentsListTest() {
        given().
                spec(authorized).
                pathParam("gist_id", GIST_ID).
        when().
                get(COMMENTS_API_PATH).
        then().
                log().ifValidationFails().
                statusCode(200).
                body("size()", greaterThan(0)).
                body("[0].body", equalTo("FirstTest"));
    }

    @Test
    public void getCommentListWithHTMLMediaTypeHeaderTest() {
        given().
                spec(authorized).
                header("Accept", "application/vnd.github.html+json").
                pathParam("gist_id", GIST_ID).
        when().
                get(COMMENTS_API_PATH).
        then().
                log().ifValidationFails().
                statusCode(200).
                body("size()", greaterThan(0)).
                body("[0].body_html", equalTo("<p>FirstTest</p>"));
    }

    @Test
    public void getSingleCommentTest() {
        given().
                spec(authorized).
                pathParam("gist_id", GIST_ID).
                pathParam("comment_id", GET_COMMENT).
        when().
                get(SINGLECOMMENT_API_PATH).
        then().
                log().ifValidationFails().
                statusCode(200).
                body("body", equalTo("FirstTest"));
    }

    @Test
    public void wrongCommentIdGetCommentTest() {
        given().
                spec(authorized).
                pathParam("gist_id", GIST_ID).
                pathParam("comment_id", 123).
        when().
                get(SINGLECOMMENT_API_PATH).
        then().
                log().ifValidationFails().
                statusCode(404).
                body("message", equalTo("Not Found"));
    }

}
