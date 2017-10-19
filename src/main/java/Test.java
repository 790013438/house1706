import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Student {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class Test {

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void change(String str) {
		str = "goodbye";
	}

	public static void change(Student stu) {
		stu.setName("Jack");
		// stu = new Student("Jack");
	}

	// ջ֡
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\w{6,20}?");
		Matcher matcher = pattern.matcher("jackfruedjackfruedjackfrued");
		// System.out.println(matcher.matches());
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	
		
//		Student stu = new Student("Tom");
//		change(stu);
//		System.out.println(stu.getName());
		// String str = "hello";
		// change(str);
		// System.out.println(str);
		// int a = 5, b = 10;
		// swap(a, b);
		// System.out.printf("a = %d, b = %d\n", a, b);
	}
}
