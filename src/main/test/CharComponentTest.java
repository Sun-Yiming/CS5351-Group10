import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CharComponentTest {

    @Before
    public void before1(){

    }

    @Test
    public void test1(){
        CharComponent cc = new CharComponent();
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"， , 。 . ： : ； ; ！ ! ？ ? ‘ ' ’ ' 【 [ 】 ] （ ( ） ) 「 { 」 } 《 < 》 >");
    }

    @Test
    public void test2(){
        CharComponent cc = new CharComponent();

        cc.setApply(" 。 . ： : ； ; ‘ ' ’ ' （ ( ） ) 「 { 」 } ");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst," 。 . ： : ； ; ‘ ' ’ ' （ ( ） ) 「 { 」 } ");
    }

    @Test
    public void test3(){
        CharComponent cc = new CharComponent();

        cc.setApply(null);
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"");
    }

    @Test
    public void test4(){
        CharComponent cc = new CharComponent();

        cc.setApply("   （ ( ） ) ");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"（ ( ） ) ");
    }

    @Test
    public void test5(){
        CharComponent cc = new CharComponent();

        cc.setApply("   （ ( ）");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"（ ( ）");
    }

    @Test
    public void test6(){
        CharComponent cc = new CharComponent();

        cc.setApply("( ）    ");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"( ）");
    }

    @Test
    public void test7(){
        CharComponent cc = new CharComponent();

        cc.setApply("abdasbjksadbkab");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"");
    }

    @Test
    public void test8(){
        CharComponent cc = new CharComponent();

        cc.setApply("12321321312");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"");
    }

    @Test
    public void test9(){
        CharComponent cc = new CharComponent();

        cc.setApply("啊啊啊 呜呜呜");
        String rst = cc.getCurrentString();

        Assert.assertEquals(rst,"");
    }
}
