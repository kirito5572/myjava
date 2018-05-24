package Make_FileTree_With_JTreeClass;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JScrollPane;

public class TreeTest extends JFrame {
	JTree tree;
	DefaultTreeModel treeModel;
	public TreeTest() {
		super("Tree Test Example");
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode subroot = new DefaultMutableTreeNode("SubRoot");
		DefaultMutableTreeNode leaf1 = new DefaultMutableTreeNode("Leaf 1");
		DefaultMutableTreeNode leaf2 = new DefaultMutableTreeNode("leaf 2");
		
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		
		treeModel.insertNodeInto(subroot,root,0);
		subroot.add(leaf1);
		root.add(leaf2);
		
		getContentPane().add(tree, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TreeTest();
	}

}
