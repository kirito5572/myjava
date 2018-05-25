package parkYoungHawn.FileManager;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import parkYoungHawn.FileManager.MainForm;

/*
strings_en properties.txt - 언어가 영어 일때  불러옴
strings_ko properties.txt - 언어가 한국어 일때 불러옴 (한글을 코드화 시킴)
 */
//전체적인 틀과 기능을 하는 클래스
public class MainForm {
    private static final String RESOURCE_NAME = "strings";	//txt파일을 불러 오기 위함
    private static final Font FONT = new Font("Malgun Gothic", Font.PLAIN, 12); //폰트
    private static final String[] PREFIX = {"", "K", "M", "G"}; //파일의 용량 단위
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//파일 최종 수정 날따
   
    private String con[][]={{"1", "2", "3"}};

    private JPanel basic=new JPanel();
    private JPanel below=new JPanel();
    private JList<String> direrorylist = new JList<String>();
    private JScrollPane tPane=new JScrollPane();
    private JScrollPane dPane=new JScrollPane();
    

    private JLabel dLabel=new JLabel();
    private JComboBox<ComboBoxLeguese> legueseBox=new JComboBox<ComboBoxLeguese>();
    private JLabel titleLabel=new JLabel();

    private JFrame frame = new JFrame();
    private File dir = new File("C:\\");
    private File dir2 = new File("D:\\");
    private ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_NAME, Locale.ENGLISH);//영어txt를 받음
    
    private String header[] = {bundle.getString("column0"), bundle.getString("column1"),bundle.getString("column2")};
    private JTable fileTable=new JTable(con,header);
    
    //각각 변수 선언
    private String errorTitle; 
    private String directoryError;
    private String openError;
    private String deleteError;
    private String copyError;
    private String copySuffix;
    private String replaceMessage;
    private String replaceTitle;
    
    //복사 변수 선언
    private File copySourceDir;
    private String copySourceName;
    
    
    //생성자 호출
    private MainForm() {
    	//폰트 설정
        UIManager.put("rightMenuItem.font", FONT);
        UIManager.put("OptionPane.messageFont", FONT);
        UIManager.put("OptionPane.buttonFont", FONT);

        updateLeguese();	//한국어 or 영어 업테이터
        updateDir();		//테이블 업데이트

        direrorylist.addMouseListener(new MouseAdapter() {//더블 클릭 시 테이블에 파일 목록 출력
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                	if(e.getClickCount()==2) {
                    dir = new File(dir, direrorylist.getSelectedValue());
                    updateDir();
                	}
                }
            }
        });
        //메뉴 불러옴
        RightMenu rightMenu = new RightMenu(this, fileTable, bundle);
        //메뉴의 마우스 리스너
        MouseListener listener = rightMenu.getMouseListener(); 
        tPane.addMouseListener(listener);
        fileTable.addMouseListener(listener);
        //파일 이름 더블 클릭시 열기
        fileTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if (e.getButton() == MouseEvent.BUTTON1) {
                	if(e.getClickCount()==2) {
                	int row = fileTable.getSelectedRow();
					int col = fileTable.getSelectedColumn();
					open(fileTable.getValueAt(row, col).toString());
                	}
                }
        	}
        });
        
        fileTable.getTableHeader().setReorderingAllowed(false);
        fileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //언어 선택시 이벤트 발생
        legueseBox.addItemListener((ItemEvent e) -> {
        	//언어 선택을 하면 strings_"  " projetise를 불러옴
            bundle = ResourceBundle.getBundle(RESOURCE_NAME, ((ComboBoxLeguese) e.getItem()).getLocale());
            //언어에 맞게 변수 재정의
            updateLeguese();
            //테이블의 header적용된 언어로 화면 재출력
            updateDir();
            rightMenu.changeLocale(bundle);
        });
        
        legueseBox.addItem(new ComboBoxLeguese("English", Locale.ENGLISH));//영어 설정
        legueseBox.addItem(new ComboBoxLeguese("한국어", Locale.KOREAN));//한글 설정
        
        basic.setLayout(new BorderLayout());//보드 레이아웃
        
        frame.add(basic); //기본 패널
        frame.setBounds(120, 80, 613, 433);//프레임 조절
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 종료
        
        //수정시작부분//
        FixUI();
        
    }
    
    
    private void FixUI(){    //프레임 배치 수정
    	frame.setTitle(bundle.getString("title"));//제목
    	
    	//각각 배치
    	tPane=new JScrollPane(fileTable); 
    	dPane=new JScrollPane(direrorylist);
    	basic.add(dPane,BorderLayout.WEST);
    	basic.add(tPane,BorderLayout.CENTER);
    	
    	
    	below.setLayout(new BorderLayout());
    	below.add(titleLabel,BorderLayout.WEST);
    	below.add(legueseBox, BorderLayout.EAST);
    	
    	frame.add(basic,BorderLayout.CENTER);
    	frame.add(below, BorderLayout.SOUTH);
    	
    	
    }
    // 여기까지 UI수정종료

    private void updateLeguese() { 
    	//언어가 바꿜 때 각 언어에 맞게 변수 재정의
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
        UIManager.put("OptionPane.noButtonText", bundle.getString("no"));//모양 변경
        UIManager.put("OptionPane.okButtonText", bundle.getString("ok"));
        UIManager.put("OptionPane.yesButtonText", bundle.getString("yes"));
    }

    private synchronized void updateDir() {
    	//파일 선택시 그 파일안에 있는  것을 테이블로 표시
    	//배열 이용(Vector)
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
                            else//파일 용량 단위 표시
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

            direrorylist.setListData(dirVector);
            fileTable.setModel(new DefaultTableModel(rowVector, headVector) {
                @Override
                public boolean isCellEditable(int row, int column) { return false; }
            });
            dLabel.setText(dir.getCanonicalPath());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(frame, directoryError, errorTitle, JOptionPane.ERROR_MESSAGE);
            dir = new File(dir, "..");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //파일을 열음
    void open(String filename) {
        try {
            Desktop.getDesktop().open(new File(dir, filename));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, openError, errorTitle, JOptionPane.ERROR_MESSAGE);
        }
    }
    //파일을 복사함
    void copy(String filename) {
        copySourceDir = dir;
        copySourceName = filename;
    }
    //파일을 붙여넣기함
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
        //무조건 실행
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
    //파일 삭제
    void delete(String filename) {
        if (new File(dir, filename).delete()) {
            updateDir();
        } else {
            JOptionPane.showMessageDialog(frame, deleteError, errorTitle, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        new MainForm();	//생성자 호출 -> 모두 실행
    }
}
