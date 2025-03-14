package trim.api.common.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/access/test")
@RequiredArgsConstructor
public class TestApiController {

    @GetMapping
    public TestDto test(@RequestParam String message) {
        TestDto dto = new TestDto(message);

        return dto;
    }

    @Getter
    private class TestDto{
        private String message;

        public TestDto(String message) {
            this.message = message;
        }
    }
}
