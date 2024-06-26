package com.sparta.schedule.dto.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentRequest {

    @NotBlank
    private Long scheduleId;

    @NotBlank
    private String content;

}
