package site.metacoding.ds;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.Identity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doProcess 요청됨");
		String httpMethod = req.getMethod();
		System.out.println("호출방식은 : "+httpMethod);
		
		String identifier = req.getRequestURI();
		System.out.println("URI 파싱 결과 : "+identifier);
		
		UserController c = new UserController();
		
		Method[] methodList = UserController.class.getDeclaredMethods();
		
		for (Method method : methodList) {
			Annotation annotation = method.getDeclaredAnnotation(RequestMapping.class);
			RequestMapping requestMapping = (RequestMapping)annotation;
			
			try {
				if(identifier.equals(requestMapping.value())) {
					method.invoke(c);
				}
				
			} catch (Exception e) {
				System.out.println(method.getName()+"은 어노테이션이 없습니다.");
			}
		
			//System.out.println(method.getName());
		}
		
		
	}

}
