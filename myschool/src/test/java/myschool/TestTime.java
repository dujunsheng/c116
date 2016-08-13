/**
 * 
 */
package myschool;




import java.util.Date;

import org.junit.Test;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.school.util.DateFormatUtil;

/**
 * @author c116
 *
 */
public class TestTime {

	@Test
	public void testTime(){
		String time = "19962752";
		Date date = DateFormatUtil.parseToDay(time);
		System.out.println(date);
	}
}
