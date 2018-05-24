package Make_FileTree_With_JTreeClass;

import java.io.File;
import java.io.FileFilter;

public class DirectoryList {
	public static void main(String[] args) {
		File dir = new File("C:\\");
		File[] files = dir.listFiles();
		FileFilter fileFilter = new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
				return file.isDirectory();
			}
		};
		files = dir.listFiles(fileFilter);
		if(files.length == 0) {
			System.out.println("Either dir dose not exist r is not a directory");
		} else {
			for(int i = 0; i < files.length; i++ ) {
				File filename = files[i];
				if (filename.toString().contains("$") || filename.toString().contains("Recovery") 
						|| filename.toString().contains("System") || filename.toString().contains("Temp")
						|| filename.toString().contains("PeftLogs"))
				continue;
				else
					System.out.println(filename.toString());
			}
		}
	}
}
