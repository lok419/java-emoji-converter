package com.github.binarywang.java.emoji;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class EmojiConverterTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private EmojiConverter emojiConverter = EmojiConverter.getInstance();

    @BeforeTest
    public void init(){
        BasicConfigurator.configure();
    }

    @Test
    public void testToAlias() {
        String str = "  An 😃😀awesome 😃😃string with a few 😃😉emojis!";
        String alias = this.emojiConverter.toAlias(str);
        this.logger.info(str);
        this.logger.info("EmojiConverterTest.testToAlias()=====>");
        this.logger.info(alias);
        assertEquals(
            ":no_good: :ok_woman: :couple_with_heart:An :smiley::grinning:awesome :smiley::smiley:string with a few :smiley::wink:emojis!",
            alias);
    }

    @Test
    public void testToHtml() {
        String str = "  An 😀😃awesome 😃😃string with a few 😉😃emojis!";
        String result = this.emojiConverter.toHtml(str);
        this.logger.info(str);
        this.logger.info("EmojiConverterTest.testToHtml()=====>");
        this.logger.info(result);
        assertEquals(
            "&#128581; &#128582; &#128145;An &#128512;&#128515;awesome &#128515;&#128515;string with a few &#128521;&#128515;emojis!",
            result);
    }

    @Test
    public void testToUnicode() {
        String str = "\uE412\uE409\uE40D\uE107\uE403\uE40E";
        String result = this.emojiConverter.toUnicode(str);
        this.logger.info(str);
        this.logger.info("EmojiConverterTest.testToUnicode()=====>");
        this.logger.info(result);
        assertEquals("\uD83D\uDE02\uD83D\uDE1D\uD83D\uDE33\uD83D\uDE31\uD83D\uDE14\uD83D\uDE12", result);
    }

}
