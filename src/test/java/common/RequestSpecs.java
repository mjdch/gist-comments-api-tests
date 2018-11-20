package common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static common.ApiConstant.BASE_URI;
import static common.ApiConstant.OAUTH2_TOKEN;
import static io.restassured.RestAssured.oauth2;

public class RequestSpecs {


    public static RequestSpecification oauth2 = new RequestSpecBuilder().setBaseUri(BASE_URI).setAuth(oauth2(OAUTH2_TOKEN)).build();

    public static RequestSpecification unauthorized = new RequestSpecBuilder().setBaseUri(BASE_URI).build();

}
