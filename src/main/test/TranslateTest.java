import org.junit.Test;
import org.junit.Assert;

public class TranslateTest {

    @Test
    public void test1() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("こんにちは私はいい人です");

        Assert.assertEquals(rst,"Hello i am a nice person");
    }

    @Test
    public void test2() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("प्रायः अहं भोजनः अस्मि");

        Assert.assertEquals(rst,"Hello, I'm a good man");
    }

    @Test
    public void test3() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("สวัสดีครับผมเป็นคนดี");

        Assert.assertEquals(rst,"Hello, I'm a man.");
    }

    @Test
    public void test4() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("שלום, אני אדם טוב.");

        Assert.assertEquals(rst,"Hello, I'm a good person.");
    }

    @Test
    public void test5() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("Γεια σας, είμαι καλός άνθρωπος");

        Assert.assertEquals(rst,"Hello, I'm a good person");
    }

    @Test
    public void test6() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("你好，我是个好人");

        Assert.assertEquals(rst,"Hello i am a good person");
    }

    @Test
    public void test7() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("Привет, я хороший человек");

        Assert.assertEquals(rst,"Hi i am a good person");
    }

    @Test
    public void test8() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("Hallo, ich bin ein guter Mann");

        Assert.assertEquals(rst,"Hi i am a good man");
    }

    @Test
    public void test9() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("Bonjour, je suis quelqu'un de bien.");

        Assert.assertEquals(rst,"Hello, I am a good person.");
    }

    @Test
    public void test10() throws Exception {
        Translate ts = new Translate();
        String rst = ts.dotrans("안녕하세요");

        Assert.assertEquals(rst,"Hello?");
    }
}
