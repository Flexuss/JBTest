import java.io.IOException;
//Поток
public class Proc extends Thread {
	int n;
	Construct cons;
	Proc(Construct a){
		cons=a;
	}

	@Override
	public void run() {
		try {
			System.put.println("Scan started")
			FileScanner.scan(cons.iD, cons.oD, cons.mask, cons.inSubfold, cons.aDel);//Запуск скана
			System.out.println("Scan completed")
			Thread.sleep(cons.wI * 1000);//Интервал
			this.run();//Повторный запуск
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
}
