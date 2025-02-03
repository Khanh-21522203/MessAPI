package com.java_mess.java_mess.dto.user;

import com.java_mess.java_mess.model.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserResponse {
  private User user;

}
