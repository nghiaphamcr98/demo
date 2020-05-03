package com.example.demo.languague;

public enum ErrorContent {
    ERROR("Có lỗi xảy ra","Error",""),
    SUCCESS("Thành công", "Success", ""),
    INVALID("Vui lòng nhập đầy đủ thông tin","Info invalid request", ""),
	INVALID_LOGIN("Thông tin đăng nhập chưa chính xác","Invalid username or password", ""),
	USER_NOT_EXSIST("Tài khoản không tồn tại","", ""),
	USER_IS_EXSIST("Tài khoản đã tồn tại","", ""),
	PASSWORD_WRONG("Sai mật khẩu","", ""),
	TAG_NOT_EXSIST("Tag không tồn tại","", ""),
	QUESTION_NOT_EXSIST("Câu hỏi không tồn tại","", ""),
	QUESTION_NOT_OPEN("Câu hỏi đang đóng","", ""),
	QUESTION_ANSWER_NOT_EXSIST("Câu hỏi/ câu trả lời không tồn tại","", ""),
	;

	private Language language;

	ErrorContent(String vi, String en, String cam) {
		this.language = new Language();
		this.language.setVi(vi);
		this.language.setEn(en);
		this.language.setCam(cam);
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getError(int languageType) {
		String result = "";
		if (languageType == LanguageType.VI.getValue())
			result = this.language.getVi();
		else if (languageType == LanguageType.EN.getValue())
			result = this.language.getEn();
		else if (languageType == LanguageType.CAM.getValue())
			result = this.getLanguage().getCam();
		return result;
	}

	public static ErrorContent from(int type) {
		for (ErrorContent errorType : ErrorContent.values()) {
			if (errorType.ordinal() == type) {
				return errorType;
			}
		}

		return ERROR;
	}

}
