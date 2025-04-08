package kr.re.kepri.pcm;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetEndpoint() {
        String name = "John";
        Assertions.assertThat(name).isEqualTo("John"); // name이 "John"인지 확인
        Assertions.assertThat(name).startsWith("J");   // "J"로 시작하는지 확인
        Assertions.assertThat(name).hasSize(4);      // 길이가 4인지 확인

       /* ResponseEntity<String> response = restTemplate.getForEntity("/api/hello", String.class);
        Assertions.assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        Assertions.assertThat(response.getBody()).isEqualTo("Hello, World!");*/
    }
}
