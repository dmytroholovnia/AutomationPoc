import dto.createpage.CreatePageResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Service {

    private static final String INIT_PATH = "/init";

    public CreatePageResponseDto createPage(String payload) {
        var generatedSignature = SignatureGenerator
                .generateSignature(Constants.PUBLIC_API_KEY, payload, Constants.SECRET_API_KEY);

        return RestAssured
                .given()
                    .baseUri(Constants.BASE_URI)
                    .basePath(INIT_PATH)
                    .header(new Header("merchant", Constants.PUBLIC_API_KEY))
                    .header(new Header("signature", generatedSignature))
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .log().all()
                .when()
                    .post()
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract()
                .as(CreatePageResponseDto.class);
    }

}
