package pers.laineyc.blackdream.framework.util;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author LaineyC
 */
public final class ReflectionUtil {
	
	/**
	 * 反射获取父类的泛型参数的实际类型。
	 * @param clazz   需要反射的类，该类继承泛型父类。
	 * @param index   泛型参数所在索引，从0开始。
	 * @return 泛型参数的实际类型，如果没有实现ParameterizedType接口，既不支持泛型，直接返回<code>Object.class</code>
	 */
	public static Class getSuperClassGenericsType(Class clazz, int index){
		ParameterizedType parameterizedType = getParameterizedType(clazz,true);
		if(parameterizedType == null){
			return Object.class;
		}
		Type []params = parameterizedType.getActualTypeArguments(); 
		if (!(params[index] instanceof Class)) {
			return Object.class;   
		}   
		return (Class) params[index];
	}
	
	/**
	 * 反射获取父类的泛型参数
	 * @param clazz 需要反射的类，该类继承泛型父类。
	 * @param deep	是否递归查找，如果父类不是泛型类则继续查找，如果没有泛型父类返回null
	 * @return 泛型参数类型
	 */
	public static ParameterizedType getParameterizedType(Class clazz, boolean deep){
		if(clazz == null){
			return null;
		}
		Type genType = clazz.getGenericSuperclass();
		if( genType instanceof ParameterizedType ){
			return (ParameterizedType)genType;            
		}
		if( deep ){
			return getParameterizedType(clazz.getSuperclass(), true);
		}
		return null;
	}

	public static Field getField(Class<?> beanClass, String fieldName){
		Field field = null;
		Class<?> target = beanClass;
		do{
			try {
				field = target.getDeclaredField(fieldName);
			}
			catch (NoSuchFieldException e){
				target = target.getSuperclass();
			}
		}
		while(target != null && field == null);
		return field;
	}

	public static Object getFieldValue(Field field, Object object){
		try {
			return field.get(object);
		}
		catch (Exception e){
			return  null;
		}
	}

}

