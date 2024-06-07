package hlflapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CustomerRecharge_Services {

    JsonPath js;

    @BeforeClass
    public void customerRechargeResponseData() throws IOException {
        RestAssured.baseURI = "https://dtpapitestv1.mloyalcapture.com";
        String response = given().log().all()
                .headers(ApiUtils.getHeaders())
                .body(HLFLPayloads.ProcessCustomerRecharge()).when().post("/hlflapi/Transaction/ProcessCustomerRecharge")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println(response);
        this.js = new JsonPath(response);
    }

    @Test(priority = 2)
    public void SuccessRecharge(){

        String responseMessage = js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Success");


        int status = js.getInt("Status");
        Assert.assertEquals(status, 0);
    }

    @Test(priority = 3)
    public void testWithInvalidhaskey(){

        String responseMessage=js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Invalid hasKey");

        int status = js.getInt("Status");
        Assert.assertEquals(status, 1);

    }
    @Test(priority = 4)
    public void testWithInvalidClientCode(){

        String responseMessage=js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Invalid ClientCode");

        int status = js.getInt("Status");
        Assert.assertEquals(status, 31);
    }
    @Test(priority = 5)
    public void testWithInvalidCustomerID(){
        String responseMessage=js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Invalid Details");

        int status = js.getInt("Status");
        Assert.assertEquals(status, 17);
    }
    @Test(priority = 6)
    public void testWithInvalidControlCardNo(){
        String responseMessage=js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Invalid Details");

        int status = js.getInt("Status");
        Assert.assertEquals(status, 17);
    }

    @Test(priority = 7)
    public void testWithInvalidHLFLCustomerID(){
        String responseMessage=js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Invalid Details");

        int status = js.getInt("Status");
        Assert.assertEquals(status, 17);
    }
    @Test(priority = 8)
    public void testWithInvalidFacilityNo(){

        String responseMessage=js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Invalid Facility Number.");

        int status = js.getInt("Status");
        Assert.assertEquals(status, 1);


    }
    @Test(priority = 9)
    public void testWithInvalidAmount(){

        String responseMessage=js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Minimum recharge amount should be 1.00");

        int status = js.getInt("Status");
        Assert.assertEquals(status, 1);
    }

    @Test(priority = 10)
    public void testWithInvalidTransDate(){

        //invalid date

    }
    @Test(priority = 11)
    public void testWithInvalidTransNumber(){
        String responseMessage=js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Invalid Transaction No. ");

        int status = js.getInt("Status");
        Assert.assertEquals(status, 0);
    }
    @Test(priority = 12)
    public void testWithInvalidPanNumber(){
        //user is able to do transaction with blank pan card

        String responseMessage=js.getString("ResponseMessage");
        Assert.assertEquals(responseMessage, "Pan Card does not belong to this customer");

        int status = js.getInt("Status");
        Assert.assertEquals(status, 1);
    }


}
