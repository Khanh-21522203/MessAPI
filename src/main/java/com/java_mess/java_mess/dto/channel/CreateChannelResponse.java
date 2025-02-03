package com.java_mess.java_mess.dto.channel;

import com.java_mess.java_mess.model.Channel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateChannelResponse {
  private Channel channel;
}
