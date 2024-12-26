package trim.api.question.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateQuestionRequest {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

}
