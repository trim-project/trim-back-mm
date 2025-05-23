package trim.api.common.dto;

import io.swagger.v3.oas.models.examples.Example;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ExampleHolder {
    private Example holder;
    private String name;
    private int code;
}
