import java.io.IOException;

public class Construct {
	String iD = "", oD = "", mask = "";
	int wI;
	boolean inSubfold = false, aDel = false;
	boolean corr = true;

	Construct(String string) throws IOException{
		String[] a=string.split("\"");
		String[] b=new String[0];
		for(int i=0;i<a.length;i++){
			switch (a[i]) {
			case " -input ": {
				iD=a[++i];
				break;
			}
			case " -output ": {
					oD = a[++i];
				break;
			}
			case " -mask ": {
					mask = getMask(a[++i]);
				break;
			}
			default:
				b=a[i].split(" ");
				break;
			}
		}
		for(int i=0;i<b.length;i++){
			switch(b[i]){

			case "-waitInterval": {
				wI =new Integer(b[++i]);
				break;
			}
			case "-includeSubfolders": {
				inSubfold = setBool(b[++i]);
				break;
			}
			case "-autoDelete": {
				aDel = setBool(b[++i]);
				break;
			}
			default : break;
			}
		}
	}

	private static String getMask(String string) {
		StringBuffer a = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			switch (string.charAt(i)) {
			case '?': {
				a.append('.');
				break;
			}
			case '*': {
				a.append(".*");
				break;
			}
			case '.': {
				a.append("\\.");
				break;
			}
			default:
				a.append(string.charAt(i));
				break;
			}
		}
		return a.toString();
	}

	private static boolean setBool(String string) {
		if (string.equals("false")) {
			return false;
		} else {
			return true;
		}
	}
}
