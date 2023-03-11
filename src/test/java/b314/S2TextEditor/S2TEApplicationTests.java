package b314.S2TextEditor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(loader = TestContextLoader.class)
class S2TEApplicationTests {

	@Test
	void contextLoads() {
	}

}
