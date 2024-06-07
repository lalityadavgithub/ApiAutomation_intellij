//package testHelpers;
//
//import io.restassured.path.json.JsonPath;
//
//public class ValidationHelpers {
//
//    public static void validateCommonApiAssertions(JsonPath response) {
//        SoftAssertions softAssert = new SoftAssertions();
//        softAssert.assertThat(response.getString("status.result")).equals("success");
//        softAssert.assertThat(response.getString("code")).equals("200");
//        softAssert.assertAll();
//    }
//}
