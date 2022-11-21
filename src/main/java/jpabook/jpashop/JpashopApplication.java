package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {


	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

	//지연 로딩을 무시하라는 모듈
	//쓰지 말라 (엔티티를 노출하지 말라는 뜻)
	//해당 모듈의 필요한 기능은 써도 된다.
	@Bean
	Hibernate5Module hibernate5Module() {
		return new Hibernate5Module();
	}

}
