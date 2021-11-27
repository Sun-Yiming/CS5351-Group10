import com.intellij.ide.util.PropertiesComponent;
import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CharComponent implements Component{

    public static final int DEFAULT_L = 20;
    public static final String KEY = "char_transfer";
//    public static final String DEFAULT_STRING = "�� ,";
    public static final String DEFAULT_STRING = "�� , �� . �� : �� ; �� ! �� ? �� ' �� '";
    public static final int NUMP = 5;
    public static final int ENP = 120;
    public static final int CHP = 35;
    public static final int SIGNP = 95;


//    String[] defaultStrs = DEFAULT_STRING.split(" ");

    //��Ӣ�����
    private JTextField[] charEn;
    private JTextField[] charCh;



    //���ص�ǰ���ַ���
    @Override
    public String getCurrentString(){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DEFAULT_L; i++) {
            sb.append(charCh[i].getText()+" "+charEn[i].getText()+" ");
        }
        return sb.toString().trim();
    }

    //�����ʼ��
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

    //������������
    @Override
    public void setApply(String string){
        String[] strings = string.split(" ");
        for (int i=0; i<DEFAULT_L; i++){
            charCh[i].setText(i<strings.length/2 ? strings[2*i] : "");
            charEn[i].setText(i<strings.length/2 ? strings[2*i+1] : "");
        }
    }

    //�������
    private void createField(int i, JPanel jPanel, int type){
        JTextField jt = new JTextField();
        jt.setBounds(type + (i / 10) * 300, 32 * (i % 10), 60, 32);

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

    private void createLabel(int i, JPanel jPanel, int type){
        JLabel jl = new JLabel();

        if(type == SIGNP){
            jl.setBounds(type + (i / 10) * 300, 32 * (i % 10), 25, 32);
            jl.setText("=>");
        }
        else if(type == NUMP){
            jl.setBounds(type + (i / 10) * 300, 32 * (i % 10), 30, 32);
            jl.setText((i+1)+".");
        }
        jl.setHorizontalAlignment(JLabel.CENTER);
        jPanel.add(jl);
    }


    //�����ظ��������ð�ť
    @Override
    public JLabel getDefaultBnt(){
        JLabel btn = new JLabel();
        btn.setText("reset");
        btn.setForeground(Color.RED);
        btn.setBounds(30, 32 * 10, 60, 32);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        btn.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int response = JOptionPane.showConfirmDialog(jPanel, "Do you make sure to restore default?", "ch -> en", JOptionPane.YES_NO_OPTION);
//                //��ʼ��
//                if (response == 0) {
//                    PropertiesComponent.getInstance().setValue(KEY, DEFAULT_STRING);
//                    CharacterReplaceHandler.reload();
//                    reset();
//                    //����ط���Ҫ����ˢ��һ�����,��Ҫ����resetզ��
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


    //��ʼ��JPanel���
    @Override
    public void init(JPanel jPanel){
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
