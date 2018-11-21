package common;

public class ApiConstant {

    public static final String BASE_URI = "https://api.github.com";

    public static final String COMMENTS_API_PATH = "/gists/{gist_id}/comments";

    public static final String SINGLECOMMENT_API_PATH = "/gists/{gist_id}/comments/{comment_id}";

    public static final String OAUTH2_TOKEN = System.getProperty("OATH2_TOKEN");

    // Predefined gist_id
    public static final String GIST_ID = "aced6c34a0e894cfce32ce2b6e172a5e";

    //Test data for pre added comment
    public static final String GET_COMMENT = System.getProperty("GET_COMMENT");

    public static final String EDIT_COMMENT = System.getProperty("EDIT_COMMENT");

    public static final String DELETE_COMMENT = System.getProperty("DELETE_COMMENT");



}
