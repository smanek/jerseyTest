package com.greplin;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class TemplateMessage {

  private final String param;

  @JsonCreator
  public TemplateMessage(@JsonProperty("param") String param) {
    this.param = param;
  }

  public String getParam() {
    return param;
  }
}
