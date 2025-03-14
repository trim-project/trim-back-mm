package trim.outer.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trim.outer.test.client.TestClient;

@RequestMapping("/external/test")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestClient testClient;

    @GetMapping
    public ResponseEntity<String> testMessage(@RequestParam String message) {
        return ResponseEntity.ok(testClient.testMessage(message).getMessage());
    }
}
