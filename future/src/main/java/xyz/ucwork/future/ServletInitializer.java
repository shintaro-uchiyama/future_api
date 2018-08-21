package xyz.ucwork.future;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * warファイルをTomcatに展開するにあたって必要らしい
 * @author uchiyama-shintaro
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {
 	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FutureApplication.class);
	}
 }