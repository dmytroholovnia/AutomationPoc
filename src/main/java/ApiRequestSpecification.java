import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;

public class ApiRequestSpecification
//        implements RequestSpecification
{

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final RequestSpecification requestSpecification;

    public ApiRequestSpecification(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ApiRequestSpecification body(Object object) {
        String json = JsonUtils.toJson(object);
        return (ApiRequestSpecification) requestSpecification.body(json);
    }
}
