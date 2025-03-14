package trim.outer.api.test.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "testClient",
        url = "http:8080//api/access/check")
public class TestClient {

    @GetMapping
    public String feignTest(@RequestParam String message) {
        return message;
    }
}
