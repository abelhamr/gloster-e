package ma.gloster.microservice.batch.reader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;


import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import ma.gloster.microservice.batch.writer.UserRowMapper;
import ma.gloster.microservice.dto.UserDto;


//@Configuration
//@EnableAutoConfiguration
//@PropertySource("classpath:application.properties")
@Service
public class UserReaderDbImpl {
	
	@Autowired
	DataSource dataSosurce;
	
	@Value("${spring.job.userOutJob.sql}")
	private String sqlRequête;
	
	@Value("${spring.datasource.driver-class-name}")
	private  String driverPostgresql;
	
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	
	@Value("${spring.datasource.username}")
	private String datasourceUsername;
	

	@Value("${spring.datasource.password}")
	private String datasourcePassword;
	
	@Value("test")
	private String k ;
	
	//@Bean
	 public  DataSource dataSource() {
	  final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName("org.postgresql.Driver");
	  dataSource.setUrl("jdbc:postgresql://localhost:5432/User");
	  dataSource.setUsername("postgres");
	  dataSource.setPassword("1234");
	  return dataSource;
	 }
	
	@Bean
	
	  public   JdbcCursorItemReader<UserDto> reader(){
	
	  JdbcCursorItemReader<UserDto> reader = new JdbcCursorItemReader<UserDto>();
	   reader.setDataSource(dataSource());
	  reader.setSql("SELECT ADDRESS,EMAIL FROM USER_TABLE");
	  reader.setRowMapper(new UserRowMapper()); 
	  return reader;
	 }
}
