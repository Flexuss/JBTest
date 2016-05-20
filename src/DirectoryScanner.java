
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//Запуск консоли и считывание данных
public class DirectoryScanner {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		ArrayList<Proc> procArr = new ArrayList<Proc>();//Массив потоков. Каждый сканер в новом потоке.
		while (sc.hasNext()) {
			String in = sc.next();
			if (in.equals("scan")) {//Если встречается scan запуск скана в новом потоке с входной строкой
				String a = sc.nextLine();
				Construct b = new Construct(a);
				procArr.add(new Proc(b));
				procArr.get(n).start();
				n++;

			} else if (in.equals("exit")) {//Если exit "убивает" программу
					System.exit(0);
			}else if(in.equals("stop")){//Если stop+int останавлевает поток с нужным номером
				procArr.get(sc.nextInt()).stop();
			}
		}
	}
}
