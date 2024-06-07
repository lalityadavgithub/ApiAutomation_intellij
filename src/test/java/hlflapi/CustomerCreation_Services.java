package hlflapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CustomerCreation_Services {

   // String customerid=" ";
    JsonPath js;

    @Test(priority =0)
    public void customerResponseData() throws IOException {

        RestAssured.baseURI = "https://dtpapitestv1.mloyalcapture.com";
        String response = given().log().all()
                .headers(ApiUtils.getHeaders())
                .body(HLFLPayloads.CreateCustPayload()).when().post("/hlflapi/Transaction/CreateCustomer")
                .then().assertThat().statusCode(200)
                .extract().response().asString();


        System.out.println(response);
        this.js = new JsonPath(response); //for parsing json

    }
        @Test(priority = 1)
        public void ValidateResponseWithValidData() {

            String clientCode = js.getString("[0].ClientCode");
            Assert.assertEquals(clientCode, "HLFL");

            // Validate DTPCustomerID
            String dtpCustomerId = js.getString("[0].DTPCustomerID");
           // Assert.assertEquals(dtpCustomerId, "4000001552");
            Assert.assertNotNull(dtpCustomerId);
            // Assert that the runtime value is of correct type, e.g., it's a string
            Assert.assertTrue(dtpCustomerId instanceof String);

            // Validate ControlCardNumber
            String controlCardNumber = js.getString("[0].ControlCardNumber");
           // Assert.assertEquals(controlCardNumber, "5000001552");
            Assert.assertNotNull(controlCardNumber);
            // Assert that the runtime value is of correct type, e.g., it's a string
            Assert.assertTrue(controlCardNumber instanceof String);


            // Validate HLFLCustomerID
            String hlflCustomerId = js.getString("[0].HLFLCustomerID");
            Assert.assertEquals(hlflCustomerId, "199910876");

            // Validate ResponseMessage
            String responseMessage = js.getString("[0].ResponseMessage");
            Assert.assertEquals(responseMessage, "Active");

            // Validate Status
            int status = js.getInt("[0].Status");
            Assert.assertEquals(status, 0);

        }

        @Test(priority = 2)
        public void testWithDuplicateHLFLCustomerID(){

            String clientCode = js.getString("[0].ClientCode");
            Assert.assertEquals(clientCode, "HLFL");

            String dtpCustomerId = js.getString("[0].DTPCustomerID");
            Assert.assertEquals(dtpCustomerId, "0");


            String hlflCustomerId = js.getString("[0].HLFLCustomerID");
            Assert.assertEquals(hlflCustomerId, "199910876");

            String responseMessage = js.getString("[0].ResponseMessage");
            Assert.assertEquals(responseMessage, "Duplicate Entry");

            int status = js.getInt("[0].Status");
            Assert.assertEquals(status, 2);

            System.out.println(responseMessage + "-" + hlflCustomerId);
        }

        @Test(priority = 3)
        public void testWithDuplicatePan_Card(){

            String responseMessage = js.getString("[0].ResponseMessage");
            Assert.assertEquals(responseMessage, "Pan already mapped");

            int status = js.getInt("[0].Status");
            Assert.assertEquals(status, 89);

        }

        @Test(priority = 4)
        public void testUpdateDTPCustomerRecords_U(){
            String responseMessage = js.getString("[0].ResponseMessage");
            Assert.assertEquals(responseMessage, "Customer updated successfully");

            int status = js.getInt("[0].Status");
            Assert.assertEquals(status, 0);


        }

        @Test(priority = 5)
        public void testInvalidPermanentAddressState(){

            String responseMessage = js.getString("[0].ResponseMessage");
            Assert.assertEquals(responseMessage, "Permanent Address State does not exist please enter correct state.");

            int status = js.getInt("[0].Status");
            Assert.assertEquals(status, 61);


        }
        @Test(priority = 6)
        public void testPermanentDistrictNotExistInState(){
            String responseMessage = js.getString("[0].ResponseMessage");
            Assert.assertEquals(responseMessage, "Permanent District does not belong to Permanent state");

            int status = js.getInt("[0].Status");
            Assert.assertEquals(status, 65);


        }
    @Test(priority = 7)
    public void testCommunicationAddressState(){

        String responseMessage = js.getString("[0].ResponseMessage");
        Assert.assertEquals(responseMessage, "Communication Address State does not exist please enter correct state");

        int status = js.getInt("[0].Status");
        Assert.assertEquals(status, 62);


    }
    @Test(priority = 8)
    public void testCommunicationDistrictNotExistInState(){
        String responseMessage = js.getString("[0].ResponseMessage");
        Assert.assertEquals(responseMessage, "Communication District does not belong to Communication state");

        int status = js.getInt("[0].Status");
        Assert.assertEquals(status, 66);


    }

    }

