import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileScanner {

	static void scan(String iD, String oD, String mask, boolean inSubfold, boolean aDel) throws IOException, InterruptedException {
		File[] input = new File(iD).listFiles();
		System.out.println("Сканирую деректорию");
		for (int i = 0; i < input.length; i++) {
			if (input[i].isFile()) {
				if (chek(input[i], mask)) {
					File output = new File(oD, input[i].getName());
					output.createNewFile();
					if (aDel) {
						input[i].delete();
					}
				}
			} else {
				if (input[i].isDirectory() && inSubfold) {
					File dir = new File(oD, input[i].getName());
					String iD1 = iD + "\\\\" + dir.getName();
					String oD1 = oD + "\\\\" + dir.getName();
					System.out.println(iD1);
					System.out.println(oD1);
					dir.mkdir();
					System.out.println("Создал директорию");
					scan(iD1, oD1, mask, inSubfold, aDel);
				} else {
					System.out.println("Баг");
				}
			}
		}
	}

	private static boolean chek(File a, String mask) {
		Pattern p = Pattern.compile(mask);
		Matcher m = p.matcher(a.getName());
		return m.matches();
	}
}
