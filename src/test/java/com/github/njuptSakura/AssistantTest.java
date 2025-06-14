package com.github.njuptSakura;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssistantTest {

  @Test
  public void testGpt() {
    var model =
        OpenAiChatModel.builder()
            .baseUrl("http://langchain4j.dev/demo/openai/v1")
            .apiKey("demo")
            .modelName("gpt-4o-mini")
            .build();

    var ans = model.chat("你好");
    System.out.println(ans);
  }

  @Autowired private OpenAiChatModel openAiChatModel;

  @Test
  public void testGpt2() {
    var ans = openAiChatModel.chat("你好");
    System.out.println(ans);
  }
}
