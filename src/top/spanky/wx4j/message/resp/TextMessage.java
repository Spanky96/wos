package top.spanky.wx4j.message.resp;

/**
 * 文本消息
 *
 * @author liufeng
 * @date 2013-09-11
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public static final String[] defaultMessage = new String[] { "抱歉，小滨太笨啦 T.T。这个忙帮不上！",
            "您好，我是小滨。滨江厨房每日都可以获取红包哦。回复【我要红包】试试！", "哦。。", "你说为什么人家Siri这么聪明，但是Siri不会发红包。", "据说皮蛋瘦肉粥很好吃，你要不要尝尝？" };

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
