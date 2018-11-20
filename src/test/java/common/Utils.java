package common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.ApiConstant.*;
import static io.restassured.RestAssured.given;
import static common.RequestSpecs.*;

public class Utils {

    public static int getCommentsLength() {

        return given().spec(oauth2).pathParam("gist_id", GIST_ID).
                when().get(COMMENTS_API_PATH).
                then().extract().path("size()");
    }

    public static List<Integer> getCommentsIdsAsList() {
        return given().spec(oauth2).pathParam("gist_id", GIST_ID).
                when().get(COMMENTS_API_PATH).
                then().extract().path("id");
    }

    public static int createComment(String body) {

        body = body == null ? "" : body;
        int commentId;

        Map<String, String> json = new HashMap<String, String>();
        json.put("body", body);

        commentId = given().spec(oauth2).pathParam("gist_id", GIST_ID).body(json).
                when().post(COMMENTS_API_PATH).
                then().extract().path("id");

        return commentId;
    }

    public static String getCommentBody(int commentId) {

        String body = given().spec(oauth2).pathParam("gist_id", GIST_ID).pathParam("comment_id", commentId).
                when().get(SINGLECOMMENT_API_PATH).
                then().extract().path("body");

        return body;

    }

    public static void updateCommentBody(String body, int commentId) {
        body = body == null ? "" : body;
        Map<String, String> json = new HashMap<String, String>();
        json.put("body", body);


        given().spec(oauth2).pathParam("gist_id", GIST_ID).pathParam("comment_id", commentId).body(json).when().patch(SINGLECOMMENT_API_PATH);


    }


}
