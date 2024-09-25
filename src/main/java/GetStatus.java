import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

public class GetStatus {

    private static final String BASE_URI = "https://pay.solidgate.com/api/v1/status";
    private static final String PUBLIC_API_KEY = "api_pk_423f18b5_3e89_4024_958b_5bde0e2c7fc2";
    private static final String SECRET_API_KEY = "api_sk_294baa6f_c199_4759_bef0_9907a864e792";

    public static void main(String[] args) {
        var orderStatusBody = "{\n" +
                "  \"order_id\": \"5a0ca834-d22b-4d95-aa1d-460cbac8fdce\"\n" +
                "}";
        var generatedSignature = SignatureGenerator
                .generateSignature(PUBLIC_API_KEY, orderStatusBody, SECRET_API_KEY);

        RestAssured
                .given()
                .baseUri(BASE_URI)
                .header(new Header("merchant", PUBLIC_API_KEY))
                .header(new Header("signature", generatedSignature))
                .contentType(ContentType.JSON)
                .body(orderStatusBody)
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
    }

    //created order id 788bcfc8-4960-4ff2-b404-93fd7c54b794
}
