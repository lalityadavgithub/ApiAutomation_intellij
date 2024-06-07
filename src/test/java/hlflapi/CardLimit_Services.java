package hlflapi;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CardLimit_Services {

    public void cardLimitResponseData() {
        RestAssured.baseURI = "https://dtpapitestv1.mloyalcapture.com";
        String response = given().log().all()
                .headers(ApiUtils.getHeaders())
                .body(HLFLPayloads.CardLimit()).when().post("/hlflapi/Transaction/updateCardLimit")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
    }
}
