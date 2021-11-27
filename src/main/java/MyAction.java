import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MyAction extends AnAction {
    static {
        //允许注册输入和导航栏激活操作
        final EditorActionManager actionManager = EditorActionManager.getInstance();
        //允许注册编辑块输入操作
        final TypedAction typedAction = actionManager.getTypedAction();
        //TypeAction类型需要一个TypeActionHandler组件
        typedAction.setupHandler(new CharacterReplaceHandler(typedAction.getHandler()));
    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
//        Project project = anActionEvent.getData(PlatformDataKeys.PROJECT);
//        String txt= Messages.showInputDialog(project, "What is your name?", "Input your name", Messages.getQuestionIcon());
//        Messages.showMessageDialog(project, "Hello, " + txt + "!\n I am glad to see you.", "Information", Messages.getInformationIcon());

    }
}




//class CnCharReplaceTypedHandler implements TypedActionHandler {
//    public static Map<String, String> cnCharMap = new HashMap<>();
//    private TypedActionHandler orignTypedActionHandler;
//    private char lastChar = ' ';
//
//    static {
//        reload();
//    }
//
//    public CnCharReplaceTypedHandler(TypedActionHandler orignTypedActionHandler) {
//        this.orignTypedActionHandler = orignTypedActionHandler;
//    }
//
//    public static void reload() {
//        //清除
//        cnCharMap.clear();
//        //PropertiesComponent实现允许简单持久化,获取目标字符串转换成数组
//        String[] configString = PropertiesComponent.getInstance().getValue(CnCharSettingComponent.KEY, CnCharSettingComponent.DEFAULT_STRING).split("\n");
//        for (int i = 0; i < configString.length / 2; i++) {
//            cnCharMap.put(configString[2 * i].trim(), configString[2 * i + 1].trim());
//        }
//    }
//
//    //处理在编辑器中键入的密钥。如果处理程序没有处理类型化的键，则处理程序负责委托给以前注册的处理程序。
//    @Override
//    public void execute(@NotNull Editor editor, char c, @NotNull DataContext dataContext) {
//        final Document document = editor.getDocument();
//        //获取当前项目
//        final Project project = editor.getProject();
//        //返回文档的插入符号模型，该模型可用于向编辑器添加和删除插入符号，以及查询和更新插入符号和相应选择的位置。
//        final CaretModel caretModel = editor.getCaretModel();
//        //
//        final Caret primaryCaret = caretModel.getPrimaryCaret();
//        //返回文档中插入符号的偏移量。对于已处理（无效）插入符号返回0。
//        int caretOffset = primaryCaret.getOffset();
//        //找到对应的英文字符
//        String enChar = cnCharMap.get(String.valueOf(c));
//        if (lastChar == '/' && enChar != null) {
//            Runnable runnable = () -> {
//                //删除'/'字符
//                document.deleteString(caretOffset - 1, caretOffset);
//                //插入对应的中文字符
//                document.insertString(caretOffset - 1, String.valueOf(c));
//                primaryCaret.moveToOffset(caretOffset);
//            };
//            WriteCommandAction.runWriteCommandAction(project, runnable);
//        } else if (enChar != null) {
//            this.orignTypedActionHandler.execute(editor, enChar.charAt(0), dataContext);
//        } else {
//            this.orignTypedActionHandler.execute(editor, c, dataContext);
//        }
//        //更新编辑界面中最有一个字符
//        this.lastChar = c;
//    }
//}


