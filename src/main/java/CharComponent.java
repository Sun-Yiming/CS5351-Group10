import com.intellij.ide.util.PropertiesComponent;
import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CharComponent implements Component{

    public static final int DEFAULT_L = 30;
    public static final String KEY = "char_transfer";
//    public static final String DEFAULT_STRING = "， ,";
    public static final String DEFAULT_STRING = "， , 。 . ： : ； ; ！ ! ？ ? ‘ ' ’ ' 【 [ 】 ] （ ( ） ) 「 { 」 } 《 < 》 >";
    public static final int NUMP = 5;
    public static final int ENP = 120;
    public static final int CHP = 35;
    public static final int SIGNP = 95;


//    String[] defaultStrs = DEFAULT_STRING.split(" ");

    //中英文组件
    private JTextField[] charEn;
    private JTextField[] charCh;



    //返回当前总字符串
    @Override
    public String getCurrentString(){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DEFAULT_L; i++) {
            sb.append(charCh[i].getText()+" "+charEn[i].getText()+" ");
        }
        return sb.toString().trim();
    }

    //数组初始化
//    public void initList(){
//        charEn = new String[DEFAULT_L];
//        charCh = new String[DEFAULT_L];
//
//        String[] defaultArr = DEFAULT_STRING.split(" ");
//        for (int i=0; i<defaultArr.length/2; i++){
//            charCh[i] = defaultArr[2*i];
//            charEn[i] = defaultArr[2*i+1];
//        }
//    }

    //重新设置数组
    @Override
    public void setApply(String string){
        String[] strings = string.split(" ");
        for (int i=0; i<DEFAULT_L; i++){
            charCh[i].setText(i<strings.length/2 ? strings[2*i] : "");
            charEn[i].setText(i<strings.length/2 ? strings[2*i+1] : "");
        }
    }

    //生产组件
    private void createField(int i, JBScrollPane jPanel, int type){
        JTextField jt = new JTextField();
        jt.setBounds(type + (i / 15) * 300, 32 * (i % 15), 60, 32);

        if (type == ENP){
//            jt.setText(i<defaultStrs.length/2 ? defaultStrs[2*i+1] : "");
            jt.setHorizontalAlignment(JLabel.CENTER);
            charEn[i] = jt;
            jPanel.add(charEn[i]);
        }
        else if (type == CHP){
//            jt.setText(i<defaultStrs.length/2 ? defaultStrs[2*i] : "");
            jt.setHorizontalAlignment(JLabel.CENTER);
            charCh[i] = jt;
            jPanel.add(charCh[i]);
        }


    }

    private void createLabel(int i, JBScrollPane jPanel, int type){
        JLabel jl = new JLabel();

        if(type == SIGNP){
            jl.setBounds(type + (i / 15) * 300, 32 * (i % 15), 25, 32);
            jl.setText("=>");
        }
        else if(type == NUMP){
            jl.setBounds(type + (i / 15) * 300, 32 * (i % 15), 30, 32);
            jl.setText((i+1)+".");
        }
        jl.setHorizontalAlignment(JLabel.CENTER);
        jPanel.add(jl);
    }


    //生产回复出厂设置按钮
    @Override
    public JLabel getDefaultBnt(){
        JLabel btn = new JLabel();
        btn.setText("reset");
        btn.setForeground(Color.RED);
        btn.setBounds(30, 32 * 15, 60, 32);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        btn.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int response = JOptionPane.showConfirmDialog(jPanel, "Do you make sure to restore default?", "ch -> en", JOptionPane.YES_NO_OPTION);
//                //初始化
//                if (response == 0) {
//                    PropertiesComponent.getInstance().setValue(KEY, DEFAULT_STRING);
//                    CharacterReplaceHandler.reload();
//                    reset();
//                    //这个地方需要重新刷新一下面板,需要调用reset咋整
////                    initList();
//                    init(jPanel);
//                }
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
//        jPanel.add(btn);
        return btn;
    }


    //初始化JPanel面板
    @Override
    public void init(JBScrollPane jPanel){
        charEn = new JTextField[DEFAULT_L];
        charCh = new JTextField[DEFAULT_L];
//        initList();
        for (int i=0; i < DEFAULT_L; i++){
            createLabel(i, jPanel, NUMP);
            createField(i, jPanel, ENP);
            createField(i, jPanel, CHP);
            createLabel(i, jPanel, SIGNP);
        }
//        createDefaultBnt(jPanel);
    }

}
