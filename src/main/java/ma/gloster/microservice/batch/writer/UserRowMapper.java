package ma.gloster.microservice.batch.writer;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ma.gloster.microservice.dto.UserDto;

public class UserRowMapper implements RowMapper<UserDto>{
	
	  @Override
	  public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		  UserDto userDto = new UserDto();
		  userDto.setAddress(rs.getString("address"));
		  userDto.setEmail(rs.getString("email"));
	  // System.out.println(userDto.getAddress()+","+userDto.getEmail());
	   String chaine = userDto.getAddress();
	   String email = userDto.getEmail();
	  // System.out.println(chaine.length());
	  // System.out.println(email.length());
	   while(chaine.length()<=14){
		  chaine = chaine + " " ;
	   }
	 //  System.out.println(chaine);
	   while(email.length()<=20){
			  email = email + " " ;
		   }
	  // System.out.println(email);
	   userDto.setAddress(chaine);
	   userDto.setEmail(email);
	   return userDto;
	  }
	 }