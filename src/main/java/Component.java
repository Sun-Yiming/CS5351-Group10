import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;

public interface Component {
    JLabel getDefaultBnt();
    void init(JBScrollPane jPanel);
    void setApply(String string);
    String getCurrentString();
}
