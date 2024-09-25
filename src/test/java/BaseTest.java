import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected ApiService apiService;

    @BeforeEach
    public void setup() {
        apiService = new ApiService();
    }

}
