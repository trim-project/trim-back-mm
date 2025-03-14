package trim.outer.test.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import trim.outer.test.dto.TestDto;

@FeignClient(
        name = "testClient",
        url = "http://localhost:8080/api/access/test"
)
public interface TestClient {
    @GetMapping
    TestDto testMessage(@RequestParam String message);
}
