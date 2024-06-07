package hlflapi;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MapFacility_Services {

    @Test
    public void mapFacilityResponseData () {
        RestAssured.baseURI = "https://dtpapitestv1.mloyalcapture.com";
        String response = given().log().all()
                .headers(ApiUtils.getHeaders())
                .body(HLFLPayloads.MapFacilityPayload()).when().post("/hlflapi/Transaction/MapFacility")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

    }
}
