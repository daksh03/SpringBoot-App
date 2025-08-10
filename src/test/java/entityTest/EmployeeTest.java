package entityTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.entity.Employee;

public class EmployeeTest {

	@Test
	public void testEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Daksh");
		emp.setEmail("da@gmail.com");
		emp.setAddress("Bijnor");
		emp.setPhno("79967xxxxx");
		emp.setSalary(987654);
		
		Assertions.assertEquals(1, emp.getId());
		Assertions.assertEquals("Daksh", emp.getName());
		Assertions.assertEquals("da@gmail.com", emp.getEmail());
		Assertions.assertEquals("Bijnor", emp.getAddress());
		Assertions.assertEquals("79967xxxxx", emp.getPhno());
		Assertions.assertEquals(987654, emp.getSalary());
	}
}
