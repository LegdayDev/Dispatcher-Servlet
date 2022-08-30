package site.metacoding.ds;

public class UserController {

	@RequestMapping("/login")
	public void login() {
		System.out.println("login 호출됨");
	}
	@RequestMapping("/join")
	public void join() {
		System.out.println("join 호출됨");
	}
	@RequestMapping("/joinForm")
	public void joinForm() {
		System.out.println("joinForm호출됨");
	}
}
