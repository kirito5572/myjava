package cccpuathqo.filemanager;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainForm {
    private static final String RESOURCE_NAME = "strings";
    private static final Font FONT = new Font("Malgun Gothic", Font.PLAIN, 12);
    private static final String[] PREFIX = {"", "K", "M", "G"};
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private JPanel basePanel;
    private JList<String> dirList;
    private JScrollPane tablePane;
    private JTable fileTable;
    private JLabel dirLabel;
    private JComboBox<ComboBoxLocale> localeBox;
    private JLabel titleLabel;

    private JFrame frame = new JFrame();
    private File dir = new File("C:\\");
    private ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_NAME, Locale.ENGLISH);

    private String errorTitle;
    private String directoryError;
    private String openError;
    private String deleteError;
    private String copyError;
    private String copySuffix;
    private String replaceMessage;
    private String replaceTitle;

    private File copySourceDir;
    private String copySourceName;

    private MainForm() {
        UIManager.put("MenuItem.font", FONT);
        UIManager.put("OptionPane.messageFont", FONT);
        UIManager.put("OptionPane.buttonFont", FONT);

        updateLocale();
        updateDir();

        dirList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    dir = new File(dir, dirList.getSelectedValue());
                    updateDir();
                }
            }
        });

        ContextMenu menu = new ContextMenu(this, fileTable, bundle);
        MouseListener listener = menu.getMouseListener();
        tablePane.addMouseListener(listener);
        fileTable.addMouseListener(listener);
        fileTable.getTableHeader().setReorderingAllowed(false);
        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        localeBox.addItemListener((ItemEvent e) -> {
            bundle = ResourceBundle.getBundle(RESOURCE_NAME, ((ComboBoxLocale) e.getItem()).getLocale());
            updateLocale();
            updateDir();
            menu.changeLocale(bundle);
        });
        localeBox.addItem(new ComboBoxLocale("English", Locale.ENGLISH));
        localeBox.addItem(new ComboBoxLocale("한국어", Locale.KOREAN));

        frame.add(basePanel);
        frame.setBounds(120, 80, 613, 433);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void updateLocale() {
        frame.setTitle(bundle.getString("title"));
        titleLabel.setText(bundle.getString("titleLabel"));
        copyError = bundle.getString("copyError");
        copySuffix = bundle.getString("copySuffix");
        errorTitle = bundle.getString("errorTitle");
        deleteError = bundle.getString("deleteError");
        directoryError = bundle.getString("directoryError");
        openError = bundle.getString("openError");
        replaceMessage = bundle.getString("replaceMessage");
        replaceTitle = bundle.getString("replaceTitle");
        UIManager.put("OptionPane.noButtonText", bundle.getString("no"));
        UIManager.put("OptionPane.okButtonText", bundle.getString("ok"));
        UIManager.put("OptionPane.yesButtonText", bundle.getString("yes"));
    }

    private synchronized void updateDir() {
        Vector<String> dirVector = new Vector<>();
        dirVector.add("..");
        Vector<Vector<String>> rowVector = new Vector<>();
        Vector<String> headVector = new Vector<>();
        headVector.add(bundle.getString("column0"));
        headVector.add(bundle.getString("column1"));
        headVector.add(bundle.getString("column2"));

        try {
            for (File f : Objects.requireNonNull(dir.listFiles())) {
                if (f.isDirectory()) {
                    dirVector.add(f.getName());
                } else {
                    Vector<String> fileRow = new Vector<>();
                    fileRow.add(f.getName());

                    String size = "";
                    double length = f.length();
                    for (int i = 0; i < 3; i++) {
                        if (length < 1024.0) {
                            if (length % 1.0 == 0.0)
                                size = String.format("%.0f %sB", length, PREFIX[i]);
                            else
                                size = String.format("%.2f %sB", length, PREFIX[i]);
                            break;
                        }
                        length /= 1024.0;
                    }
                    fileRow.add(size);
                    fileRow.add(DATE_FORMAT.format(f.lastModified()));
                    rowVector.add(fileRow);
                }
            }

            dirList.setListData(dirVector);
            fileTable.setModel(new DefaultTableModel(rowVector, headVector) {
                @Override
                public boolean isCellEditable(int row, int column) { return false; }
            });
            dirLabel.setText(dir.getCanonicalPath());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(frame, directoryError, errorTitle, JOptionPane.ERROR_MESSAGE);
            dir = new File(dir, "..");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void open(String filename) {
        try {
            Desktop.getDesktop().open(new File(dir, filename));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, openError, errorTitle, JOptionPane.ERROR_MESSAGE);
        }
    }

    void copy(String filename) {
        copySourceDir = dir;
        copySourceName = filename;
    }

    void paste() {
        File copyFile = new File(dir, copySourceName);
        if (copyFile.exists()) {
            try {
                if (copySourceDir.getCanonicalPath().equals(dir.getCanonicalPath())) {
                    int extensionPoint = copySourceName.lastIndexOf('.');
                    String name = (extensionPoint != -1) ? copySourceName.substring(0, extensionPoint) : copySourceName;
                    String extension = (extensionPoint != -1) ? copySourceName.substring(extensionPoint) : "";
                    copyFile = new File(dir, name + " - " + copySuffix + extension);
                    {
                        int i = 2;
                        while (copyFile.exists()) {
                            copyFile = new File(dir, name + " - " + copySuffix + " (" + i++ + ")" + extension);
                        }
                    }
                } else {
                    int choice = JOptionPane.showConfirmDialog(frame, replaceMessage, replaceTitle, JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.NO_OPTION) return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final File newCopyFile = copyFile;
        Thread pasteThread = new Thread(() -> {
            try (
                    FileInputStream inputStream = new FileInputStream(new File(copySourceDir, copySourceName));
                    FileOutputStream outputStream = new FileOutputStream(newCopyFile);
                    FileChannel inChannel = inputStream.getChannel();
                    FileChannel outChannel = outputStream.getChannel()) {
                long size = inChannel.size();
                inChannel.transferTo(0, size, outChannel);
                updateDir();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(frame, copyError, errorTitle, JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pasteThread.start();
    }

    void delete(String filename) {
        if (new File(dir, filename).delete()) {
            updateDir();
        } else {
            JOptionPane.showMessageDialog(frame, deleteError, errorTitle, JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MainForm();
    }
}
