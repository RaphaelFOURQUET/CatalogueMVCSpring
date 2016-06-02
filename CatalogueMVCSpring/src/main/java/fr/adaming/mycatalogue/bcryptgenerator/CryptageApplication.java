package fr.adaming.mycatalogue.bcryptgenerator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptageApplication {

	public static void main(String[] args) {

		/*Generation de BCrypt password*/

		int i = 0;
		while (i < 10) {
			String password = "0000";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}
	}
}
