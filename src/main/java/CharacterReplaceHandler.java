import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;


import java.util.*;

public class CharacterReplaceHandler implements TypedActionHandler {
    public static Map<String, String> cnCharMap = new HashMap<>();
    public static Map<String, String> colorMap = new HashMap<>();
    public static Set<String> colorKeys = new HashSet<>();

    private TypedActionHandler typedActionHandler;
    private char lastChar = ' ';
//    private Stack<Integer> lastSignPos = new Stack<>();
    private List<Integer> lastSignPos = new ArrayList<Integer>();

    static {
        reload();
    }

    public CharacterReplaceHandler(TypedActionHandler typedActionHandler) {
        this.typedActionHandler = typedActionHandler;
    }

    public static void reload() {
        //清除
        cnCharMap.clear();
        colorMap.clear();
        //PropertiesComponent实现允许简单持久化,获取目标字符串转换成数组
        String[] configString = PropertiesComponent.getInstance().getValue(CharComponent.KEY, CharComponent.DEFAULT_STRING).split(" ");
        for (int i = 0; i < configString.length / 2; i++) {
            cnCharMap.put(configString[2 * i].trim(), configString[2 * i + 1].trim());
        }

        String[] colorString = PropertiesComponent.getInstance().getValue(ColorComponent.KEY, ColorComponent.DEFAULT_STRING).split(" ");
        for (int i = 0; i < colorString.length / 2; i++) {
            colorMap.put(colorString[2 * i].trim(), colorString[2 * i + 1].trim());
        }
        colorKeys = colorMap.keySet();
    }

    //处理在编辑器中键入的密钥。如果处理程序没有处理类型化的键，则处理程序负责委托给以前注册的处理程序。
    @Override
    public void execute(@NotNull Editor editor, char c, @NotNull DataContext dataContext) {
        final Document document = editor.getDocument();
        //获取当前项目
        final Project project = editor.getProject();
        //返回文档的插入符号模型，该模型可用于向编辑器添加和删除插入符号，以及查询和更新插入符号和相应选择的位置。
        final CaretModel caretModel = editor.getCaretModel();
        //
        final Caret primaryCaret = caretModel.getPrimaryCaret();
        //返回文档中插入符号的偏移量。对于已处理（无效）插入符号返回0。
        int caretOffset = primaryCaret.getOffset();
        //找到对应的英文字符
        String enChar = cnCharMap.get(String.valueOf(c));

        if(c == ' ') {
            if (!lastSignPos.isEmpty()) {
                Runnable runnable = () -> {

                    for (int i=0; i<lastSignPos.size(); i++){
                        //获取目标#的值
//                        String target = document.getText(new TextRange(lastSignPos.peek(), caretOffset));
                        String target = document.getText(new TextRange(lastSignPos.get(i), caretOffset));

                        //如果获取有映射值
                        if (colorKeys.contains(target)) {
                            //key的长度
                            int len = target.length();

                            document.deleteString(lastSignPos.get(i), caretOffset);
                            document.insertString(lastSignPos.get(i), colorMap.get(target));
                            primaryCaret.moveToOffset(caretOffset - len + 6);
                            lastSignPos.remove(i);
                        } else {
//                        translate
                            int len = target.length();
                            String transtext = null;
                            try {
                                transtext = Translate.dotrans(target);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            document.deleteString(lastSignPos.get(i), caretOffset);
                            document.insertString(lastSignPos.get(i), transtext);
                            primaryCaret.moveToOffset(caretOffset - len + transtext.length());
                            lastSignPos.remove(i);
                        }

                    }


                };
//
                WriteCommandAction.runWriteCommandAction(project, runnable);
            }
        }
        //刷新最新一个#的位置
        if(c == '#'){
//            lastSignPos.push(caretOffset+1);

            Runnable runnable = () -> {
                for (int i=0; i<lastSignPos.size(); i++){
                    if (lastSignPos.get(i)>(caretOffset+1)){
                        lastSignPos.set(i,lastSignPos.get(i)+1);
                    }
                }
            };
            lastSignPos.add(caretOffset+1);
            WriteCommandAction.runWriteCommandAction(project, runnable);
        }

        if (enChar != null) {
            //修改中文字符
            if(lastChar == '/'){
                Runnable runnable = () -> {
                    //删除'/'字符
                    document.deleteString(caretOffset - 1, caretOffset);

                    //插入对应的中文字符
                    document.insertString(caretOffset - 1, String.valueOf(c));
                    primaryCaret.moveToOffset(caretOffset);
                };
                WriteCommandAction.runWriteCommandAction(project, runnable);
            }
            this.typedActionHandler.execute(editor, enChar.charAt(0), dataContext);
        }
        else {
            this.typedActionHandler.execute(editor, c, dataContext);
        }
        //更新编辑界面中最有一个字符
        this.lastChar = c;
    }
}
