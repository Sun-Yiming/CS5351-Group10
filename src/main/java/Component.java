import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;

public interface Component {
    JLabel getDefaultBnt();
    void init(JPanel jPanel);
    void setApply(String string);
    String getCurrentString();
}
