package hide.common;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {

		if (name != null && (name.equals("userPassWord")|| name.equals("password"))) {
			// 암호화 코드 실행
			return getSHA512(super.getParameter(name));

		} else {
			return super.getParameter(name); // 원래 가진 값 출력하기
		}

	}
	private static String getSHA512(String pwd) {

		try {
			// import java.util.Base64;으로 설정
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);

			return Base64.getEncoder().encodeToString(md.digest());
			//import java.security.NoSuchAlgorithmException;으로 설정
		} catch (NoSuchAlgorithmException e) {

			System.out.println("암호화 에러 발생!");
			e.printStackTrace();

			return null;
		}
	}

}
