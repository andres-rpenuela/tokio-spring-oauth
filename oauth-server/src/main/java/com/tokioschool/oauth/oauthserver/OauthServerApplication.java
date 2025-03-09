package com.tokioschool.oauth.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Para comprobar que levanto correctamente, devuelvel os datos del servidor
 * http://localhost:9000/.well-known/openid-configuration
 */
@SpringBootApplication
public class OauthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}

}
