import java.io.IOException;

public class Proc extends Thread {
	int n;
	Construct cons;
	Proc(Construct a){
		cons=a;
	}

	@Override
	public void run() {
		try {
			FileScanner.scan(cons.iD, cons.oD, cons.mask, cons.inSubfold, cons.aDel);
			Thread.sleep(cons.wI * 1000);
			this.run();
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
}
