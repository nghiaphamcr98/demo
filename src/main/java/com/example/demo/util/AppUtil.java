package com.example.demo.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.util.UUID;

import org.apache.log4j.Logger;

public class AppUtil {

    private static final Logger logger = Logger.getLogger(AppUtil.class);
    public static final int LOGOUT_CODE = -1;
    public static final int ERROR_CODE = 0;
    public static final int SUCCESS_CODE = 1;

    public static String generateOTP() {
        SecureRandom random = new SecureRandom();
        int rand = random.nextInt(10000);
        String result = String.format("%04d", rand);
        return result;
    }

    public static String generateOTPId() {
        UUID token = UUID.randomUUID();
        return token.toString();
    }

    public static String generateUserName() {
        UUID username = UUID.randomUUID();
        return username.toString();
    }

    public static String getStackTrace(Exception e) {
        String result = "";
        try {
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw, true);
            e.printStackTrace(pw);
            result = sw.getBuffer().toString();
        } catch (Exception ex) {
            result = "";
        }
        return result;
    }

    public static double roundUp(double number) {
		return Math.round(number * 100.0) / 100.0;
    }
    
    public static int getOffSetStart(int page, int size) {
		int result = 0;
		if (page == 0)
			page = 1;
		result = (page - 1) * size;

		return result;
	}
}
