package hlflapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

import static io.restassured.RestAssured.given;

public class HLFLApiServices extends ApiUtils {
    //String customerid=" ";

    @Test(priority =0)
    public void CreateCustServices() throws IOException {

        RestAssured.baseURI = "https://dtpapitestv1.mloyalcapture.com";
        String response = given().log().all()
                .headers(ApiUtils.getHeaders())
                .body(HLFLPayloads.CreateCustPayload()).when().post("/hlflapi/Transaction/CreateCustomer")
                .then().assertThat().statusCode(200)
                //.body("ClientCode", equalTo("HLFL"))
                //.header("X-Powered-By", "ASP.NET")
                .extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing json
        String clientCode = js.getString("ClientCode");
        System.out.println(clientCode);

        String customerid = js.getString("CustomerID");
       // this.customerid = customerid;

        Assert.assertEquals(clientCode, "[HLFL]");
        String responseMessage=js.getString("ResponseMessage");

        Assert.assertEquals(responseMessage,"[Duplicate Entry]");


    }

    @Test(priority =1,enabled = false)
    public void CreateCardServices() {
        RestAssured.baseURI = "https://dtpapitestv1.mloyalcapture.com";
        String response = given().log().all()
                .headers(ApiUtils.getHeaders())
                .body(HLFLPayloads.CreateCardPayload()).when().post("/hlflapi/Transaction/CreateCard")
                .then().assertThat().statusCode(200)
                //.body("ClientCode", equalTo("HLFL"))
                //.header("X-Powered-By", "ASP.NET")
                .extract().response().asString();
    }

    @Test(priority = 2,enabled = false)
    public void MapFacilityServices(){

    }

}
