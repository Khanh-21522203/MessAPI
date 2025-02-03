package com.java_mess.java_mess.dto.app;

import com.java_mess.java_mess.model.App;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InspectAppResponse {
  private App app;
}
