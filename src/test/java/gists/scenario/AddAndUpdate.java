package gists.scenario;

import common.BaseTest;
import org.testng.annotations.Test;

import static common.Utils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddAndUpdate extends BaseTest {

    private int commentId;

    @Test
    public void AddAndUpdateTest() {

        String bodyBefore = "Update Test Check";
        String bodyAfter = "Changed body";

        commentId = createComment(bodyBefore);

        // Check If created comment contains passed body
        assertThat(bodyBefore, equalTo(getCommentBody(commentId)));


        //Update body of created comment
        updateCommentBody(bodyAfter, commentId);

        //Check if body changed for selected comment
        assertThat(bodyAfter, equalTo(getCommentBody(commentId)));

    }

}
