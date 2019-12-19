/**
 * 文件名：MenuFrame.java
 * 功能描述：菜单窗口类
 */
import java.awt.event.*;
import java.lang.reflect.Modifier;
import javax.swing.*;
public class MenuFrame extends JFrame {
    public MenuFrame() {
        initFrame();
        initMenu();
    }

    private void initFrame() {
        setTitle("窗口及菜单Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗口关闭方式
        setSize(700,450);
        setLocationRelativeTo(null); //居中显示
    }

    private void initMenu() {
        JMenuBar menubar = new JMenuBar();
        JMenu menuFile = new JMenu("文件(F)");
        JMenu menuEdit = new JMenu("编辑(E)");
        JMenu menuView = new JMenu("查看(L)");

        menuFile.setMnemonic('F'); //设置菜单的快捷键为字母键F，需按下Alt键和字母键F
        menuEdit.setMnemonic('E');
        menuView.setMnemonic('L');

        menubar.add(menuFile); //把主菜单条加入菜单栏容器中
        menubar.add(menuEdit);
        menubar.add(menuView);

        JMenu menuOpen = new JMenu("打开(O)"); //文件菜单下的一个二级主菜单条

        menuOpen.setMnemonic('O');
        JMenuItem miOpenCVS = new JMenuItem("打开CVS格式文件");
        JMenuItem miOpenTXT = new JMenuItem("打开TXT格式文件");

        JMenuItem miSave=new JMenuItem("保存(S)");
        miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        JMenuItem miExit=new JMenuItem("退出(X)");

        menuFile.add(menuOpen);
        menuFile.add(miSave);
        menuFile.addSeparator(); //分隔线
        menuFile.add(miExit);

        menuOpen.add(miOpenCVS);
        menuOpen.add(miOpenTXT);

        JMenuItem miCopy = new JMenuItem("复制(C)");
        miCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
        JMenuItem miCut=new JMenuItem("剪切(X)");
        miCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
        JMenuItem miPaste=new JMenuItem("粘贴(V)");
        miPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));

        menuEdit.add(miCopy);
        menuEdit.add(miCut);
        menuEdit.addSeparator();
        menuEdit.add(miPaste);

        JMenuItem miRefresh=new JMenuItem("刷新(R)");
        miRefresh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,Modifier.FINAL));
        JMenuItem miStop=new JMenuItem("停止(T)");
        miStop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,Modifier.FINAL));

        menuView.add(miRefresh);
        menuView.addSeparator();
        menuView.add(miStop);

        setJMenuBar(menubar);
        validate();
    }

}