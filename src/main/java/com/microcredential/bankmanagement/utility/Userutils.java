package com.microcredential.bankmanagement.utility;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.microcredential.bankmanagement.entity.User;

@Component
public class Userutils {

	private static final Logger log = LoggerFactory.getLogger(Userutils.class);

	public String createuserid(List<User> userlist) {
		log.info("Inside createuserid method");
		boolean isIdNew = false;
		int smallest = 100;
		int biggest = 999;
		String newid = "R-" + ThreadLocalRandom.current().nextInt(smallest, biggest + 1);
		while (!isIdNew) {
			isIdNew=true;
			for (User user : userlist) {
				if ((user.getCustomerId() != null)) {
					String id = user.getCustomerId();
					if (id.equalsIgnoreCase(newid)) {
						newid = "R-" + ThreadLocalRandom.current().nextInt(smallest, biggest + 1);
						isIdNew = false;
						break;
					}
				}
			}
		}
		log.info("Userid is : {} ",newid);
		return newid;
	}
}
