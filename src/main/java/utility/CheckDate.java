package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat f = new SimpleDateFormat("ddMMMyyyy");
		Date sysDate = new Date();
		String fsysdate = f.format(sysDate);
		System.out.println(fsysdate);
		

	}

}
