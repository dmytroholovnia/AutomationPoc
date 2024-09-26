import dto.createpage.CreatePageRequestDto;
import dto.createpage.CreatePageResponseDto;
import dto.status.StatusRequestDto;
import dto.status.StatusResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import lombok.NoArgsConstructor;
import utils.JsonUtils;

import static utils.Constants.*;

@NoArgsConstructor
public class ApiService {

    private static final String INIT_PATH = "/init";
    private static final String STATUS = "/status";

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

    public StatusResponseDto getStatus(StatusRequestDto requestDto) {
        return getSpecification(requestDto)
                .baseUri(PAYMENT_URI)
                .basePath(STATUS)
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(StatusResponseDto.class);
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
