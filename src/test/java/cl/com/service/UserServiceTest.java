package cl.com.service;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.com.model.User;

//public class UserServiceTest extends DBTestCase{
		class UserServiceTest{

	UserService userService=mock(UserService.class);
	
	//UserRepository userRepository=mock(UserRepository.class);	

	/*
    public UserServiceTest(String name)
    {
        super( name );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.h2.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:h2:mem:dcbapp" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
	// System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "" );
    }
    
    protected IDataSet getDataSet() throws Exception
    {
       // return new FlatXmlDataSetBuilder().build(new FileInputStream("dataset.xml"));
    	return null;
    }
	*/
	@BeforeEach
	public void beforeClass() {
	}
	
	
	@Test
	void testGetAllUser() {
		//fail("Not yet implemented");

		//System.out.println("getall:" + userService.getAllUser());
		//assertEquals("c", "c");
	}

	@Test
	void testGetUserById() {
		//fail("Not yet implemented");
	}

	@Test
	void testSave() {
		//fail("Not yet implemented");
		
		List<cl.com.model.Telephone> telephones = new ArrayList<cl.com.model.Telephone>();
		
		User user = new User("diego","asd","123",telephones);
			
		//when(userService.save(user)).thenReturn((ResponseEntity<?>) ResponseEntity.ok(HttpStatus.OK));
		
		//System.out.println("saved:" + userService.save(user));
		//assertEquals("c", "c");
	}

}
