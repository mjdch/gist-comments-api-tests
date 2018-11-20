package gists.scenario;

import common.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static common.ApiConstant.*;
import static common.Utils.createComment;
import static common.Utils.getCommentsIdsAsList;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AddAndRemove extends BaseTest {

    private int commentId;

    @Test
    public void AddAndRemoveTest() {

        //Create comment and fetch commentId
        commentId = createComment("Automation test");

        //Check if comment is on the list

        assertThat(commentId, isIn(getCommentsIdsAsList()));

        // Delete comment

        given().spec(authorized).pathParam("gist_id", GIST_ID).pathParam("comment_id", commentId).
                when().delete(SINGLECOMMENT_API_PATH);

        // Check if if element dissapear from the list

        assertThat(commentId, not(isIn(getCommentsIdsAsList())));

    }


}
