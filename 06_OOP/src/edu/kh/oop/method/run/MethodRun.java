package edu.kh.oop.method.run;

import edu.kh.oop.method.model.service.MemberService;
import edu.kh.oop.method.model.service.MethodExample;

public class MethodRun {

	public static void main(String[] args) {
		
		MethodExample me = new MethodExample();
		
		// me.method1();
		
		MemberService ms = new MemberService();
		
		ms.displayMenu();
	}

}
