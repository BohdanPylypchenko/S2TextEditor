package b314.S2TextEditor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class S2TEApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(S2TEApplication.class);
		builder.headless(false);
		builder.run(args);
	}

}
