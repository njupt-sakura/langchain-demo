package com.github.njuptSakura;

import com.github.njuptSakura.assistant.IAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssistantTest2 {

  @Autowired private QwenChatModel qwenChatModel;

  @Test
  public void testQwen() {
    var assistant = AiServices.create(IAssistant.class, qwenChatModel);
    var ans = assistant.chat("你好");
    System.out.println(ans);
  }

  @Autowired private IAssistant assistant;

  @Test
  public void testAssistant() {
    var ans = assistant.chat("你好");
    System.out.println(ans);
  }
}
