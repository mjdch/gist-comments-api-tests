package common;

import io.restassured.specification.RequestSpecification;

public class BaseTest {

    protected RequestSpecification authorized = RequestSpecs.oauth2;

    protected RequestSpecification unauthorized = RequestSpecs.unauthorized;

}
