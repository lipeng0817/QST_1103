package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);	//键盘输入
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		//创建对象并定义输入的格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	//创建对象并定义输出的格式
		while (scanner.hasNext()){		//while循环，判断是否有输入
			String line = scanner.nextLine();	//接受下一行的输入传递给line
			Date lineDate = null;	//定义Date类型的变量
			long lineTimestamp;		//定义long类型的变量
			try {					//捕获异常
				lineDate = inputFormat.parse(line);		//把每行输入的结果转成日期格式并赋值给lineDate
				lineTimestamp = lineDate.getTime();		//把输入的结果转换成一个long型，时间戳
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);	//输出日期格式和时间戳
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	//输出异常类型
			}
		}
	}
}
