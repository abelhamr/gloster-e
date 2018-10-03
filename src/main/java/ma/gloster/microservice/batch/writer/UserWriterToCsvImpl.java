package ma.gloster.microservice.batch.writer;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import ma.gloster.microservice.business.IUserBusiness;
import ma.gloster.microservice.dto.UserDto;

public class UserWriterToCsvImpl {
	private static final Logger logger = Logger.getLogger(UserWriterImpl.class);
	
	/** The file input path. */
	@Value("${spring.job.userInJob.output}")
	private String fileoutputPath;

	 public  FlatFileItemWriter<UserDto> write(String fileoutputPath){
	  FlatFileItemWriter<UserDto> writer = new FlatFileItemWriter<UserDto>();

	  writer.setResource(new FileSystemResource(fileoutputPath));
	  writer.setLineAggregator(new DelimitedLineAggregator<UserDto>() {{
	   setDelimiter("");
	   setFieldExtractor(new BeanWrapperFieldExtractor<UserDto>() {{
	    setNames(new String[] {"address","email" });
	   }});
	  }});
	  return writer;
	 }



}
