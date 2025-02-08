package com.java_mess.java_mess.dto.message;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageEvent {
    @NotEmpty
    private String clientUserId;
    @NotEmpty
    private String channelId;
    @NotEmpty
    private String message;
    @NotEmpty
    private String imgUrl;
}
