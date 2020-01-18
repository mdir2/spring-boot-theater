package me.wook.springboot.web.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ResponseVO {
    @Builder.Default
    private int status = 200;
    @Builder.Default
    private int errorCode = 200;
    @Builder.Default
    private String message = "";
    @Builder.Default
    private String errorMessage = "";
}