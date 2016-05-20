
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DirectoryScanner {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		ArrayList<Proc> procArr = new ArrayList<Proc>();
		while (sc.hasNext()) {
			String in = sc.next();
			if (in.equals("scan")) {
				String a = sc.nextLine();
				Construct b = new Construct(a);
				procArr.add(new Proc(b));
				procArr.get(n).start();
				n++;

			} else if (in.equals("exit")) {
					System.exit(0);
			}else if(in.equals("stop")){
				procArr.get(sc.nextInt()).stop();
			}
		}
	}
}
