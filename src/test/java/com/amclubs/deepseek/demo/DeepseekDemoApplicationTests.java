package com.amclubs.deepseek.demo;

import org.junit.jupiter.api.Test;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeepseekDemoApplicationTests {

	@Autowired
	private OllamaChatModel ollamaChatModel;

	@Test
	void testChatModel() {
		String prompt = "你是一个精通中文和英文的翻译大师。如果我给你英文就翻译成中文，给你中文就翻译成英文。";
		String message =
			"""
			 DeepSeek-V3 achieves a significant breakthrough in inference speed over previous models.
			 It tops the leaderboard among open-source models and rivals the most advanced closed-source models globally.
			""";
		String result = this.ollamaChatModel.call(prompt + ":" + message);
		System.out.println(result);
	}

}
