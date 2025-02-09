# [deepseek-demo](https://github.com/amclubs/deepseek-demo)
通过使用Ollama部署deepseek-r1大模型，使用Spring Boot + Spring AI来调用deepseek-r1模型的API 实现本地完全免费API使用

#
▶️ **新人[YouTube](https://youtube.com/@AM_CLUB?sub_confirmation=1)** 需要您的支持，请务必帮我**点赞**、**关注**、**打开小铃铛**，***十分感谢！！！*** ✅
</br>🎁 不要只是下载或Fork。请 **follow** 我的[GitHub](https://github.com/amclubs)、给我所有项目一个 **Star** 星星（拜托了）！你的支持是我不断前进的动力！ 💖
</br>✅**解锁更多技能** [YouTube频道【@AM_CLUB】](https://youtube.com/@AM_CLUB?sub_confirmation=1) 、[【博客(国内)】](https://amclubss.com) 、[【博客(国际)】](https://amclubs.blogspot.com) 、[TG群【AM科技 | 分享交流群】](https://t.me/AM_CLUBS) 、[免费节点【进群发送关键字: 订阅】](https://t.me/AM_CLUBS)
</br>✅点击观看[免费节点教程](https://www.youtube.com/playlist?list=PLGVQi7TjHKXbrY0Pk8gm3T7m8MZ-InquF) | [免费VPS教程](https://www.youtube.com/playlist?list=PLGVQi7TjHKXaVlrHP9Du61CaEThYCQaiY) | [免费域名教程](https://www.youtube.com/playlist?list=PLGVQi7TjHKXZGODTvB8DEervrmHANQ1AR) | [免费VPN教程](https://www.youtube.com/playlist?list=PLGVQi7TjHKXY7V2JF-ShRSVwGANlZULdk) | [免费IPTV教程](https://www.youtube.com/playlist?list=PLGVQi7TjHKXbkozDYVsDRJhbnNaEOC76w) | [Mac和Win工具教程](https://www.youtube.com/playlist?list=PLGVQi7TjHKXYBWu65yP8E08HxAu9LbCWm) | [AI分享教程](https://www.youtube.com/playlist?list=PLGVQi7TjHKXaodkM-mS-2Nwggwc5wRjqY)

# SpringBoot本地API调用教程

`①` [点击官网构建Spring Boot项目](https://start.spring.io)

`②` 点击ADD DEPENDENCIES，搜索Ollama添加依赖，这是Spring AI对Ollama的实现支持。

`③` 打开生成的项目，查看pom.xml，可以看到核心依赖：
```java
<dependency>
	<groupId>org.springframework.ai</groupId>
	<artifactId>spring-ai-ollama-spring-boot-starter</artifactId>
</dependency>
```
> **说明**：如果你要在现有项目中集成的话，就可以直接添加这个依赖即可。

`④` 配置Ollama的相关信息：**application.properties或application.yml**
```java
spring.ai.ollama.base-url=http://localhost:11434
spring.ai.ollama.chat.model=deepseek-r1:1.5b
```
> **说明**：Ollama API 默认调用端口号：11434

`⑤` 写个单元测试，尝试调用Ollama中的deepseek-r1模型，这里尝试实现一个翻译的功能
```java
@SpringBootTest
class TestApplicationTests {
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
```
`⑥` 运行单元测试，结果如下：
```
<think>
好的，用户让我把一段英文翻译成中文，并且反过来也行。首先，我需要仔细阅读原文，确保不遗漏任何关键信息。

原文是：“DeepSeek-V3 achieves a significant breakthrough in inference speed over previous models. It tops the leaderboard among open-source models and rivals the most advanced closed-source models globally.”

首先，“DeepSeek-V3”应该是模型名称，所以翻译成“深度求索-3”比较合适。“achievable in inference speed”可以译为“在推理速度上取得了重大突破”，这里的“inference speed”指的是计算速度。

然后，“over previous models”是说它超过了之前的模型，所以翻译成“相比之前的所有模型”。

接下来的部分：“tops the leaderboard among open-source models”意思是它超过了开源模型的排行榜，这里需要用“在开源模型中领先于所有”来表达。

最后一句，“rival the most advanced closed-source models globally”是说它和最先进、最复杂的闭源模型竞争全球，翻译成“与最前沿、最强大的闭源模型的竞争”。

组合起来就是：“深度求索-3在推理速度上取得了重大突破。相比之前的所有模型，在开源模型中领先于所有，并且与最前沿、最强大的闭源模型的竞争。”

完成这些翻译后，我需要检查一下是否准确传达了原文的意思，确保没有遗漏任何细节或者语法错误。

如果用户希望反过来翻译，也就是将中文翻译成英文，我可以继续回应这个请求。
</think>

深度求索-3在推理速度上取得了重大突破。相比之前的所有模型，在开源模型中领先于所有，并且与最前沿、最强大的闭源模型的竞争。
```
可以看到结果响应分成两部分，先是 `<think>` 标签包含的内容，这是模型根据提供的提示，生成了一个思考的过程，最后才输出了翻译后的结果。

 # 
<center>
<details><summary><strong> [点击展开] 赞赏支持 ~🧧</strong></summary>
*我非常感谢您的赞赏和支持，它们将极大地激励我继续创新，持续产生有价值的工作。*

- **USDT-TRC20:** `TWTxUyay6QJN3K4fs4kvJTT8Zfa2mWTwDD`
- **TRX-TRC20:** `TWTxUyay6QJN3K4fs4kvJTT8Zfa2mWTwDD`

<div align="center"> 
  <img src="https://github.com/user-attachments/assets/e6cdc42a-6374-4722-b833-601738f72196" width="200"></br> 
  TRC10/TRC20扫码支付 
</div> 
</details>
</center>

 #
 免责声明:
 - 1、该项目设计和开发仅供学习、研究和安全测试目的。请于下载后 24 小时内删除, 不得用作任何商业用途, 文字、数据及图片均有所属版权, 如转载须注明来源。
 - 2、使用本程序必循遵守部署服务器所在地区的法律、所在国家和用户所在国家的法律法规。对任何人或团体使用该项目时产生的任何后果由使用者承担。
 - 3、作者不对使用该项目可能引起的任何直接或间接损害负责。作者保留随时更新免责声明的权利，且不另行通知。
