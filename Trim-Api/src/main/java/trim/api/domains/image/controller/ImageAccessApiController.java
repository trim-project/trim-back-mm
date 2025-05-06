package trim.api.domains.image.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import trim.api.common.dto.ApiResponseDto;
import trim.api.common.util.DataBucketUtil;

@Tag(name = "[이미지]")
@RestController
@RequestMapping("/api/access/images")
@RequiredArgsConstructor
public class ImageAccessApiController {

    private final DataBucketUtil dataBucketUtil;

    @Operation(summary = "이미지 파일을 url 형태로 변환합니다.")
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponseDto<String> convertImageFileToURL(@RequestPart MultipartFile multipartFile) {
        String url = dataBucketUtil.uploadImage(multipartFile);
        return ApiResponseDto.onSuccess(dataBucketUtil.appendPrefix(url));
    }
}
