import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileScanner {
	//Сканирование директории
	static void scan(String iD, String oD, String mask, boolean inSubfold, boolean aDel) throws IOException, InterruptedException {
		File[] input = new File(iD).listFiles();
		System.out.println("File search");
		for (int i = 0; i < input.length; i++) {
			if (input[i].isFile()) {
				if (chek(input[i], mask)) {//Если совпадает с маской создает новый файл
					File output = new File(oD, input[i].getName());
					output.createNewFile();
					if (aDel) {
						input[i].delete();//Если требуется, удаляет файл
					}
				}
			} else {
				if (input[i].isDirectory() && inSubfold) {//Если требуется, сканирует поддиректории
					File dir = new File(oD, input[i].getName());
					String iD1 = iD + "\\\\" + dir.getName();
					String oD1 = oD + "\\\\" + dir.getName();
					dir.mkdir();
					System.out.println("Create subfolder "+oD1)
					System.out.println("Scan subfolder "+iD1);
					scan(iD1, oD1, mask, inSubfold, aDel);
				} 
			}
		}
	}
	//Проверка файла по маске
	private static boolean chek(File a, String mask) {
		Pattern p = Pattern.compile(mask);
		Matcher m = p.matcher(a.getName());
		return m.matches();
	}
}
