package parkYoungHawn.FileManager;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import parkYoungHawn.FileManager.MainForm;

//오른쪽 마우스를 누르면 드는 메뉴 창을 만든 클래스
class RightMenu extends JPopupMenu {
	//메뉴 버튼 설정
    private JMenuItem showInFolder = new JMenuItem();
    private JMenuItem copy = new JMenuItem();
    private JMenuItem paste = new JMenuItem();
    private JMenuItem delete = new JMenuItem();

    private JTable table;
    
    //menu를 만듬
    RightMenu(MainForm form, JTable table, ResourceBundle bundle) {
        this.table = table;

        add(showInFolder);
        showInFolder.addActionListener((ActionEvent) -> form.open("."));//파일이 있는 폴더를 열음

        addSeparator();//구분 줄 표시

        add(copy);
        //파일을 복사함
        copy.addActionListener((ActionEvent) -> {
            form.copy((String) table.getValueAt(table.getSelectedRow(), 0));
            paste.setEnabled(true);//copy를 할 시 활성화
        });
        add(paste);
        //파일을 붙여넣음
        paste.addActionListener((ActionEvent) -> form.paste());
        paste.setEnabled(false);//붙여넣으면 비활성화

        addSeparator();//구분 줄 표시

        add(delete);
        //파일 삭제함
        delete.addActionListener((ActionEvent) -> form.delete((String) table.getValueAt(table.getSelectedRow(), 0)));

        changeLocale(bundle);//언어 변경되면 적용됨
    }

    MouseListener getMouseListener() { //마우스 우클릭시 메뉴 표시
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    boolean enable = table.getSelectedRow() != -1;
                    copy.setEnabled(enable);//활성화
                    delete.setEnabled(enable);//활성화
                    show((Component) e.getSource(), e.getX(), e.getY());
                }
            }
        };
    }
    
    void changeLocale(ResourceBundle bundle) {
        showInFolder.setText(bundle.getString("showInFolder"));//strings_" " projecties에서 showInFolder에 저장된 문장을 가져옴
        copy.setText(bundle.getString("copy"));		//strings_" " projecties에서 copy에 저장된 문장을 가져옴
        paste.setText(bundle.getString("paste"));	//strings_" " projecties에서 paste에 저장된 문장을 가져옴
        delete.setText(bundle.getString("delete"));	//strings_" " projecties에서 delete에 저장된 문장을 가져옴
    }
}
