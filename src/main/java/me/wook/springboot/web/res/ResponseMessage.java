package me.wook.springboot.web.res;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ResponseMessage {
    private int status;
    private int errorCode;
    private String message;
    private String errorMessage;
}
