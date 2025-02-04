package com.java_mess.java_mess.dto.message;

import com.java_mess.java_mess.model.Message;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendMessageResponse {
    @NotNull
    private Message message;
}
