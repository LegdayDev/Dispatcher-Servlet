package site.metacoding.ds;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) //메서드위에만 사용하는 어노테이션
@Retention(RetentionPolicy.RUNTIME) //RUNTIME(런타임시),SOURCE(컴파일시) 어노테이션이 동작함
public @interface RequestMapping {
	String value(); //value메서드는 키값, 고정이다.
	
	//예시 : @RequestMapping("hello") -> hello가 value로 들어간다
}
