package com.github.njuptSakura;

import com.github.njuptSakura.assistant.IAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChatMemoryTest {

  @Autowired private IAssistant assistant;

  @Test
  public void testChatMemory() {
    var ans = assistant.chat("我是 Java 大王");
    System.out.println(ans);
    var ans2 = assistant.chat("你知道我的身份吗");
    System.out.println(ans2);
  }

  @Autowired private QwenChatModel qwenChatModel;

  @Test
  public void testChatMemory2() {
    // First chat
    var msg = UserMessage.userMessage("我是 Java 大王");
    var res = qwenChatModel.chat(msg);
    var aiMsg = res.aiMessage();
    System.out.println(aiMsg.text());

    // Second chat
    var msg2 = UserMessage.userMessage("你知道我的身份吗");
    var res2 = qwenChatModel.chat(Arrays.asList(msg, aiMsg, msg2));
    var aiMsg2 = res2.aiMessage();
    System.out.println(aiMsg2.text());
  }

  @Test
  public void testChatMemory3() {
    var chatMemory = MessageWindowChatMemory.withMaxMessages(128);
    var assistant2 =
        AiServices.builder(IAssistant.class)
            .chatLanguageModel(qwenChatModel)
            .chatMemory(chatMemory)
            .build();

    var ans = assistant2.chat("我是 Java 大王");
    System.out.println(ans);
    var ans2 = assistant2.chat("你知道我的身份吗");
    System.out.println(ans2);
  }
}
