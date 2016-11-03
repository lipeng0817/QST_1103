package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");
		String filePath = "./access.log";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		String pattern = "(\\d+.\\d+.\\d+.\\d+) [^ ]* [^ ]* \\[([^ ]*) [^ ]*\\] \"[^ ]+ ([^ ]+) .*";
		Pattern r = Pattern.compile(pattern);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy:ss:mm:HH", Locale.US);
		while (scanner.hasNext()) {
			// 对每行进行处理
			String line = scanner.nextLine();
			// 切分获取IP，Time
			String strIp = null;
			String strTime = null;
			Matcher m = r.matcher(line);
			if (m.find()) {
				Date date = dateFormat.parse(m.group(2));
				if (date.before(endDate) && date.after(beginDate)) {
					strIp = m.group(1);
					strTime = date.toString();
					// 对在时间区间内的数据进行输出
					System.out.println(strIp + "\t" + strTime);
				}
			}	
		}
	}
}
