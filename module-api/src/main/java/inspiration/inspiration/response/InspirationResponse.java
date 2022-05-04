package inspiration.inspiration.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import inspiration.inspiration.Inspiration;
import inspiration.inspiration.InspirationType;
import inspiration.member.response.MemberResponse;
import inspiration.tag.response.TagResponse;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InspirationResponse {

    private Long id;
    private MemberResponse memberResponse;
    private List<TagResponse> tagResponses;
    private InspirationType type;
    private String content;
    private String memo;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDatetime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedDatetime;

    public static InspirationResponse from(Inspiration inspiration) {
        return InspirationResponse.builder()
                                    .id(inspiration.getId())
                                    .type(inspiration.getType())
                                    .content(inspiration.getContent())
                                    .memo(inspiration.getMemo())
                                    .createdDatetime(inspiration.getCreatedDateTime())
                                    .updatedDatetime(inspiration.getUpdatedDateTime())
                                    .memberResponse(MemberResponse.of(inspiration.getMember()))
                                    .tagResponses(inspiration.getInspirationTags().stream()
                                                                                .map(inspirationTag -> TagResponse.from(inspirationTag.getTag()))
                                                                                .collect(Collectors.toList()))
                                    .build();
    }


}
