import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class getAPITest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate;

    @BeforeEach
    void setup() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void testGetRequest() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        String url = "https://postman-echo.com/get?source=newman-sample-github-collection";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testPostRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        String body = "Duis posuere augue vel cursus pharetra. In luctus a ex nec pretium...";
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        String url = "https://postman-echo.com/post";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testPostRequestWithJsonBody() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{\"text\":\"Duis posuere augue vel cursus pharetra. In luctus a ex nec pretium...\"}";
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        String url = "https://postman-echo.com/post";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
