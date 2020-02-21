package exampleGroupProject.principledDesign.principles.OCP;

import java.util.List;


public class ListPrint {

	public void print( List<Employee> employees ) {

		for( int i = 0; employees != null && i < employees.size(); ++i ) employees.get( i ).toPrint();
	}
}
