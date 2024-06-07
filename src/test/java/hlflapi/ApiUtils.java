package hlflapi;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.Properties;

public class ApiUtils {
    private Properties properties;

    public static Headers getHeaders() {
        Header h1 = new Header("Username", "fTw42vIbHSTW8xNJSU3GH/hcmAE3X5kQq1QZuG56Qa0=");
        Header h2 = new Header("Password", "ITYh76YdXLBbMv1HaqjNhltSikIoki5d9QmeHyZPT4o=");
        Header h3 = new Header("Content-Type", "Application/Json");
        Header h4 = new Header("Authorization", "Key AFF72766A04E47A289082CB1251625AA");

        Headers headers = new Headers(h1, h2, h3, h4);
        return headers;
    }









}

