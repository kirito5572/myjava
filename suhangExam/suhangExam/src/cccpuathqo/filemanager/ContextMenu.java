package cccpuathqo.filemanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ResourceBundle;

class ContextMenu extends JPopupMenu {
    private JMenuItem open = new JMenuItem();
    private JMenuItem showInFolder = new JMenuItem();
    private JMenuItem copy = new JMenuItem();
    private JMenuItem paste = new JMenuItem();
    private JMenuItem delete = new JMenuItem();

    private JTable table;

    ContextMenu(MainForm form, JTable table, ResourceBundle bundle) {
        this.table = table;

        add(open);
        open.addActionListener((ActionEvent) -> form.open((String) table.getValueAt(table.getSelectedRow(), 0)));
        add(showInFolder);
        showInFolder.addActionListener((ActionEvent) -> form.open("."));

        addSeparator();

        add(copy);
        copy.addActionListener((ActionEvent) -> {
            form.copy((String) table.getValueAt(table.getSelectedRow(), 0));
            paste.setEnabled(true);
        });
        add(paste);
        paste.addActionListener((ActionEvent) -> form.paste());
        paste.setEnabled(false);

        addSeparator();

        add(delete);
        delete.addActionListener((ActionEvent) -> form.delete((String) table.getValueAt(table.getSelectedRow(), 0)));

        changeLocale(bundle);
    }

    MouseListener getMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    boolean enable = table.getSelectedRow() != -1;
                    open.setEnabled(enable);
                    copy.setEnabled(enable);
                    delete.setEnabled(enable);
                    show((Component) e.getSource(), e.getX(), e.getY());
                }
            }
        };
    }

    void changeLocale(ResourceBundle bundle) {
        open.setText(bundle.getString("open"));
        showInFolder.setText(bundle.getString("showInFolder"));
        copy.setText(bundle.getString("copy"));
        paste.setText(bundle.getString("paste"));
        delete.setText(bundle.getString("delete"));
    }
}
