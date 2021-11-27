import org.junit.Test;
import org.junit.Assert;

public class ColorComponentTest {

    @Test
    public void test1(){
        ColorComponent cc = new ColorComponent();
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"blue 0000FF red FF0000 green 00FF00");
    }

    @Test
    public void test2(){
        ColorComponent cc = new ColorComponent();

        cc.setApply("red FF0000 black FFFFFF");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"red FF0000 black FFFFFF");
    }

    @Test
    public void test3(){
        ColorComponent cc = new ColorComponent();

        cc.setApply(null);
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"");
    }

    @Test
    public void test4(){
        ColorComponent cc = new ColorComponent();

        cc.setApply(" 。 . ： : ； ; ‘ ' ’ ' （ ( ） ) 「 { 」 } ");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst," 。 . ： : ； ; ‘ ' ’ ' （ ( ） ) 「 { 」 } ");
    }

    @Test
    public void test5(){
        ColorComponent cc = new ColorComponent();

        cc.setApply("red FF0000 black");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"red FF0000 black");
    }

    @Test
    public void test6(){
        ColorComponent cc = new ColorComponent();

        cc.setApply("red FF0000 black FFFFFF    ");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"red FF0000 black FFFFFF");
    }

    @Test
    public void test7(){
        ColorComponent cc = new ColorComponent();

        cc.setApply("    red FF0000 black FFFFFF");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"red FF0000 black FFFFFF");
    }

    @Test
    public void test8(){
        ColorComponent cc = new ColorComponent();

        cc.setApply("abdasbjksadbkab");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"");
    }

    @Test
    public void test9(){
        ColorComponent cc = new ColorComponent();

        cc.setApply("12321321312");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"");
    }

    @Test
    public void test10(){
        ColorComponent cc = new ColorComponent();

        cc.setApply("啊啊啊 呜呜呜");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"");
    }
}
