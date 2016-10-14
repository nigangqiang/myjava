import java.lang.reflect.*;
import java.util.Scanner;
public class Test{
	public static void main(String[] args) throws Exception{
		Scanner input=new Scanner(System.in);
		while(true){
			String className=input.next();
			String name=input.next();
			int age=input.nextInt();
			Object[] params=new Object[]{name,new Integer(age)};
			Class[] types=new Class[]{String.class,int.class};

			Object o=ReflectUtils.getInstance(className,types,params);
			System.out.println(o);
		}
	}	
}
class ReflectUtils{
	/*
	通过类名创建出无参的实例对象
	*/
	public static Object getInstance(String className)throws Exception{
		//通过className创建出Class对象
		Class clazz=Class.forName(className);
		//通过newInstance创建出无参对象
		return clazz.newInstance();
	}
	/*
	通过类名和参数创建出有参函数
	className类名
	types所有参数的类型
	params所有参数的值
	*@return Object返回创建好对象的值
	*/
	public static Object getInstance(String className,Class[] types,Object[] params)throws Exception{
		//通过className创建出Class对象
		Class clazz=Class.forName(className);
		Constructor con=clazz.getConstructor(types);
		return con.newInstance(params);
	}
}