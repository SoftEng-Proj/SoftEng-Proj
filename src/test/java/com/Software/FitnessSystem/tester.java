package com.Software.FitnessSystem;
import static org.junit.Assert.*;

import org.junit.Test;

public class tester {
	App app;
	private AdminControllers adminProcedures;
	
	public tester() {
		this.app = new App();
		adminProcedures = new AdminControllers();
	}
	
	@Test
	public void i_navigate_to_the_page() {
	    boolean expected = true;  // القيمة المتوقعة
	    boolean actual = adminProcedures.navigateToManagementPage();  // القيمة الفعلية
	    assertTrue(actual == expected);  // التحقق مما إذا كانت القيمة الفعلية متساوية مع المتوقعة
	}
}