import dto.createpage.CreatePageRequestDto;
import dto.createpage.CreatePageResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import lombok.NoArgsConstructor;

import static utils.Constants.*;

@NoArgsConstructor
public class ApiService {

    private static final String INIT_PATH = "/init";

    public CreatePageResponseDto createPage(CreatePageRequestDto dto) {
        return getSpecification(dto)
                .basePath(INIT_PATH)
                    .log().all()
                .when()
                    .post()
                .then()
                    .log().all()
                    .statusCode(200)
                    .extract()
                .as(CreatePageResponseDto.class);
    }

    public RequestSpecification getSpecification(Object object) {
        var payload = JsonUtils.toJson(object);
        var generatedSignature = SignatureGenerator
                .generateSignature(PUBLIC_API_KEY, payload, SECRET_API_KEY);

        return RestAssured
                .given()
                .baseUri(BASE_URI)
                .header(new Header("merchant", PUBLIC_API_KEY))
                .header(new Header("signature", generatedSignature))
                .contentType(ContentType.JSON)
                .body(JsonUtils.toJson(object));
    }

}
