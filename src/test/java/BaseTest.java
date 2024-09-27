import core.ApiService;
import core.CoreDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected ApiService apiService;
    protected CoreDriver coreDriver;

    @BeforeEach
    public void setup() {
        apiService = new ApiService();
        coreDriver = new CoreDriver();
    }

    @AfterEach
    public void tearDown() {
        coreDriver.tearDown();
    }

}
