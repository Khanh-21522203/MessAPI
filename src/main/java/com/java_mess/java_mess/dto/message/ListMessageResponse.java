package com.java_mess.java_mess.dto.message;

import java.util.List;

import com.java_mess.java_mess.model.Message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListMessageResponse {
    private List<Message> messages;
}
