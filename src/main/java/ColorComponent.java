import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import java.awt.*;

public class ColorComponent implements Component{

    public static final int DEFAULT_L = 30;
    public static final String KEY = "color_transfer";
    public static final String DEFAULT_STRING = "blue 0000FF red FF0000 green 00FF00";
    public static final int NUMP = 5;
    public static final int CODEP = 170;
    public static final int ENP = 35;
    public static final int SIGNP = 145;
    public static final int ABSHIGH = 32 * 17;

    //颜色对照数组
    private JTextField[] colorEn;
    private JTextField[] code;

    @Override
    public String getCurrentString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DEFAULT_L; i++) {
            sb.append(colorEn[i].getText()+" "+code[i].getText()+" ");
        }
        return sb.toString().trim();
    }

    @Override
    public void setApply(String string) {
        String[] strings = string.split(" ");
        for (int i=0; i<DEFAULT_L; i++){
            colorEn[i].setText(i<strings.length/2 ? strings[2*i] : "");
            code[i].setText(i<strings.length/2 ? strings[2*i+1] : "");
        }
    }

    //生产组件
    private void createField(int i, JBScrollPane jPanel, int type){
        JTextField jt = new JTextField();
        jt.setBounds(type + (i / 15) * 300, ABSHIGH+32 * (i % 15), 110, 32);

        if (type == ENP){
            jt.setHorizontalAlignment(JLabel.CENTER);
            colorEn[i] = jt;
            jPanel.add(colorEn[i]);
        }
        else if (type == CODEP){
            jt.setHorizontalAlignment(JLabel.CENTER);
            code[i] = jt;
            jPanel.add(code[i]);
        }
    }

    private void createLabel(int i, JBScrollPane jPanel, int type){
        JLabel jl = new JLabel();

        if(type == SIGNP){
            jl.setBounds(type + (i / 15) * 300, ABSHIGH + 32 * (i % 15), 25, 32);
            jl.setText("=>");
        }
        else if(type == NUMP){
            jl.setBounds(type + (i / 15) * 300, ABSHIGH + 32 * (i % 15), 30, 32);
            jl.setText((i+1)+".");
        }
        jl.setHorizontalAlignment(JLabel.CENTER);
        jPanel.add(jl);
    }


    @Override
    public JLabel getDefaultBnt() {
        JLabel btn = new JLabel();
        btn.setText("reset");
        btn.setForeground(Color.GREEN);
        btn.setBounds(30, ABSHIGH + 32 * 15, 60, 32);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    @Override
    public void init(JBScrollPane jPanel) {
        colorEn = new JTextField[DEFAULT_L];
        code = new JTextField[DEFAULT_L];
//        initList();
        for (int i=0; i < DEFAULT_L; i++){
            createLabel(i, jPanel, NUMP);
            createField(i, jPanel, ENP);
            createField(i, jPanel, CODEP);
            createLabel(i, jPanel, SIGNP);
        }
    }




}
