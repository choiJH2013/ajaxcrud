package cafe.jjdev.ajaxajaxcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AjaxcrudApplication {

	public static void main(String[] args) {
		System.out.println("구동을 실행 합니다.");
		SpringApplication.run(AjaxcrudApplication.class, args);
		System.out.println("SpringApplication 구동 완료.");
	}

}
