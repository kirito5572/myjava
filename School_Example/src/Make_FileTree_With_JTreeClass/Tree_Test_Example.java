package Make_FileTree_With_JTreeClass;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Tree_Test_Example extends JFrame {
	
	JTree tree;
	DefaultTreeModel treeModel;
	File filename,subfilename;
	File[] files;
	File[] subfiles;
	public Tree_Test_Example() {
		super("Tree Test Example");
		File dir = new File("C:\\");
		FileFilter fileFilter = new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
				return file.isDirectory();
			}
		};
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("디스크 드라이브(C:)");
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		files = dir.listFiles(fileFilter);
		if(files.length == 0) {
			System.out.println("Either dir dose not exist or is not a directory");
		} else {
			for(int i = (files.length-1); i >= 0; i-- ) {
				filename = files[i];
				if (filename.toString().contains("$") || filename.toString().contains("Recovery") 
						|| filename.toString().contains("System") || filename.toString().contains("Temp")
						|| filename.toString().contains("PeftLogs"))
				continue;
				DefaultMutableTreeNode subroot = new DefaultMutableTreeNode(filename.toString().substring(dir.toString().length()));
				treeModel.insertNodeInto(subroot,root,0);
				File subdir = new File(filename.toString());
				FileFilter subfileFilter = new FileFilter() {
					
					@Override
					public boolean accept(File subfile) {
						// TODO Auto-generated method stub
						return subfile.isDirectory();
					}
				};
				subfiles = subdir.listFiles(subfileFilter);
				try {
					if (subfiles.length == 0) {
						System.out.println("Either dir dose not exist or is not a directory");
					} else {
						for (int ia = 0; ia < subfiles.length; ia++) {
							subfilename = subfiles[ia];
							if (subfilename.toString().contains("$") || subfilename.toString().contains("Recovery")
									|| subfilename.toString().contains("System")
									|| subfilename.toString().contains("Temp")
									|| subfilename.toString().contains("PeftLogs"))
								continue;
							DefaultMutableTreeNode subsubroot = new DefaultMutableTreeNode(subfilename.toString().substring(1+(int)filename.toString().length()));
							subroot.add(subsubroot);
						}
					} 
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		add(tree, BorderLayout.CENTER);
		
		setSize(300,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Tree_Test_Example();
	}
}

