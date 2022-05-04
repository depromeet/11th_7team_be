package inspiration.inspiration.request;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Getter
@ApiModel("Sample Request InspirationTagRequest")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InspirationTagRequest {

    @NotBlank(message = "영감 id는 필수 입력 입니다.")
    private Long id;
    @NotBlank(message = "태그 id는 필수 입력 입니다.")
    private Long tagId;

}
