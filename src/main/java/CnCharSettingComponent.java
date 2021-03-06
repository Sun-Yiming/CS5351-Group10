import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.ui.components.JBScrollPane;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.ui.components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.charset.StandardCharsets;

public class CnCharSettingComponent implements SearchableConfigurable {
//    public static final int LENGTH = 45;
//    public static final String DEFAULT_STRING = "?? , ?? . ?? : ?? ; ?? ! ?? ? ?? \" ?? \" ?? ' ?? ' ?? [ ?? ] ?? ( ?? ) ?? { ?? } ?? < ?? >".replace(" ", "\n");
//    public static final String DEFAULT_STRING = ". , , .".replace(" ", "\n");


//    public static final String KEY = "cnchar_config_string";
//    private JPanel settingPanel;
//    private JTextField[] text1;
//    private JTextField[] text2;
//    private JLabel[] labels1;
//    private JLabel[] labels2;
//    private JLabel btnDefault;

    private JPanel myPanel;//JPanel
    private Component charComponent;
    private Component colorComponent;
    private CharComponentFactory charComponentFactory;
    private ColorComponentFactory colorComponentFactory;

    public void initPanel(){

        myPanel = new JPanel();
//        JBScrollPane  myPanel = new JBScrollPane();
        myPanel.setLayout(null);

        charComponentFactory = new CharComponentFactory();
        colorComponentFactory = new ColorComponentFactory();

        charComponent = charComponentFactory.Makecomponent();
        colorComponent = colorComponentFactory.Makecomponent();

//        myPanel.add(getJSP());
        charComponent.init(myPanel);
        colorComponent.init(myPanel);

    }

    //???ɹ???
//    public JScrollPane getJSP(){
//        JBScrollPane jsp = new JBScrollPane();
//        jsp.setBounds(0, 0, 350, 350);
//        return jsp;
//    }

    public static void main(String[] args) {

    }

    @NotNull
    public String getId() {
        return "codeTran";
    }

    @Nls
    public String getDisplayName() {
        return this.getId();
    }

    @Nullable
    public String getHelpTopic() {
        return this.getId();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (myPanel != null) {
            myPanel.repaint();
            return myPanel;
        }
        initPanel();

        JLabel btn1 = charComponent.getDefaultBnt();
        btn1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int response = JOptionPane.showConfirmDialog(myPanel, "Do you make sure to restore default?", "ch -> en", JOptionPane.YES_NO_OPTION);
                //??ʼ??
                if (response == 0) {
                    PropertiesComponent.getInstance().setValue(CharComponent.KEY, CharComponent.DEFAULT_STRING);
                    CharacterReplaceHandler.reload();
                    reset();
                    //?????ط???Ҫ????ˢ??һ??????,??Ҫ????resetզ??
//                    initList();
//                    init(jPanel);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        myPanel.add(btn1);

        JLabel btn2 = colorComponent.getDefaultBnt();
        btn2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int response = JOptionPane.showConfirmDialog(myPanel, "Do you make sure to restore default?", "color transfer", JOptionPane.YES_NO_OPTION);
                //??ʼ??
                if (response == 0) {
                    PropertiesComponent.getInstance().setValue(ColorComponent.KEY, ColorComponent.DEFAULT_STRING);
                    CharacterReplaceHandler.reload();
                    reset();
                    //?????ط???Ҫ????ˢ??һ??????,??Ҫ????resetզ??
//                    initList();
//                    init(jPanel);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        myPanel.add(btn2);


        return myPanel;
//        return settingPanel;
    }

    //???û??޸????ò????????ڵ?????OK????Apply????ťǰ?????ܻ??Զ????ø÷??????ж??Ƿ????޸ģ????????ư?ť??OK????Apply?????Ƿ????á?
    @Override
    public boolean isModified() {
        String oldStr = PropertiesComponent.getInstance().getValue(CharComponent.KEY, CharComponent.DEFAULT_STRING).trim();
        String newStr = charComponent.getCurrentString();

        String oldStr1 = PropertiesComponent.getInstance().getValue(ColorComponent.KEY, ColorComponent.DEFAULT_STRING).trim();
        String newStr1 = colorComponent.getCurrentString();

        return !newStr.equals(oldStr) || !oldStr1.equals(newStr1);
    }

    //?û???????OK??????Apply????ť???????ø÷?????ͨ????????????????Ϣ?־û???
    @Override
    public void apply() {
        String str = charComponent.getCurrentString();
        PropertiesComponent.getInstance().setValue(CharComponent.KEY, str);
        CharacterReplaceHandler.reload();

        String str1 = colorComponent.getCurrentString();
        PropertiesComponent.getInstance().setValue(ColorComponent.KEY, str1);
        CharacterReplaceHandler.reload();
    }

    //??reset??ť,????ҳ??ʱ????
    @Override
    public void reset() {
        String str = PropertiesComponent.getInstance().getValue(CharComponent.KEY, CharComponent.DEFAULT_STRING);
        charComponent.setApply(str);

        String str1 = PropertiesComponent.getInstance().getValue(ColorComponent.KEY, ColorComponent.DEFAULT_STRING);
        colorComponent.setApply(str1);
    }

//    private String getConfigString() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < LENGTH; i++) {
//            sb.append(text1[i].getText().trim()).append("\n").append(text2[i].getText().trim()).append("\n");
//        }
//        return sb.toString().trim();
//    }

}
