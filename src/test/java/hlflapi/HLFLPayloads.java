package hlflapi;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class HLFLPayloads extends ApiUtils {

    //HLFl Customer Creation Payload
    public static String CreateCustPayload() throws IOException {

        JSONObject payload = new JSONObject();

        payload.put("clientCode", "HLFL");
        payload.put("HLFLCustomerID", "199910876");
        payload.put("RecordStatus", "I");
        payload.put("DTPCustomerID", "0");
        payload.put("CustomerTitle", "Mr");
        payload.put("CustomerName", "Lalit HLFL");
        payload.put("PermanentAddress1", "LOGIC1");
        payload.put("PermanentAddress2", "FAIL");
        payload.put("PermanentAddress3", "FAIL");
        payload.put("PermanentAddressLocation", "noida3");
        payload.put("PermanentAddressCity", "noida4");
        payload.put("PermanentAddressDistrict", "114");
        payload.put("PermanentAddressState", "100");
        payload.put("PermanentAddressPincode", "355580");
        payload.put("CustomerEmail", "lalit.shiv@paytmmloyal.com");
        payload.put("CommunicationAddress1", "FAIL.");
        payload.put("CommunicationAddress2", "FAIL");
        payload.put("CommunicationAddress3", "FAILw");
        payload.put("CommunicationAddressLocation", "noida2");
        payload.put("CommunicationAddressCity", "noida");
        payload.put("CommunicationAddressDistrict", "237");
        payload.put("CommunicationAddressState", "71");
        payload.put("CommunicationAddressPincode", "547745");
        payload.put("MobileNumber", "8652671260");
        payload.put("NameOnCard", "Ajay");
        payload.put("KeyTitle", "Mr");
        payload.put("KeyFirstName","Lalit Yadav");
        payload.put("KeyDesignation","QA");
        payload.put("KeyMobile","8652671260");
        payload.put("Pan_Card","CCNPS55804");

        return payload.toString();

    }

    //HLFL Card Creation Payload
    public static String CreateCardPayload() {
        JSONObject payload = new JSONObject();
        File fileToUpload = new File("C:\\Users\\lalit.pmloyal\\Pictures\\Screenshots\\Billerappcrashed.png"); // replace with the actual file path

        payload.put("ClientCode", "HLFL");
        payload.put("CustomerID", "4000000148");
        payload.put("ControlCardNumber", "4000000148");
        payload.put("HLFLCustomerID", "19901089");
        payload.put("vehicleType", "HCV");
        payload.put("vehicleNumber", "AP39TE9256");
        payload.put("registrationYear", "2019");
        payload.put("cardPreferenceType", "Magstripe");
        payload.put("mobileNo", "6000000159");
        payload.put("manufacturer", "Ashoke Layland");
        payload.put("RCDoc," , "fileToUpload");


        return payload.toString();

    }

    //HLFL Facility Mapping Payload
    public static String MapFacilityPayload(){

        JSONObject payload = new JSONObject();

        payload.put("ClientCode", "HLFL");
        payload.put("CustomerID", "4000000206");
        payload.put("ControlCardNumber", "4000000206");
        payload.put("HLFLCustomerID", "19901019");
        payload.put("FacilityNumber", "FC0009808");

        return payload.toString();
    }

    //HLFL Card Limit Payload
    public static String CardLimit(){
        JSONObject payload = new JSONObject();

        payload.put("ClientCode", "HLFL");
        payload.put("CustomerID", "4000000087");
        payload.put("CardNumber", "8201003000066807");
        payload.put("HLFLCustomerID", "10001042");
        payload.put("LimitType","CCMSMonthlyLimit");
        payload.put("LimitValue","800000");

      return payload.toString();
    }

    public static String ProcessCustomerRecharge() throws IOException {
        JSONObject payload = new JSONObject();

//        FileInputStream fs=new FileInputStream("D:\\IntelliJ-WorkSpace\\ApiAutomation\\src\\test\\test.csv");
//
//        Properties p=new Properties();
//        p.load(fs);
      //  String browserName=p.getProperty("Browser");

            payload.put("ClientCode", "HLFL");
            payload.put("CustomerID", "4000000087");
            payload.put("ControlCardNumber", "4000000087");
            payload.put("HLFLCustomerID", "10001042");
            payload.put("FacilityNumber", "FC0000532");
            payload.put("Amount", "20");
            payload.put("TransactionDate", "15-02-2024 13:58:46");
            payload.put("TransactionNumber", "HLFL123153");
            payload.put("Pan_Card", "EHRPS6984R");
            payload.put("HashKey", "e39abecf08472773948c148c35328e53c36b824e5940dcf5c9e1f70d42692fce");


        return payload.toString();
    }
}
