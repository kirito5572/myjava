package parkYoungHawn.FileManager;

import java.util.Locale;

//콤보박스에서 언어를 선택 하면 그 값을 보냈다가 불러오는 클래스
class ComboBoxLeguese {
    private String text;	
    private Locale locale;		

    ComboBoxLeguese(String text, Locale locale) {
        this.text = text;		//재정의
        this.locale = locale;	//재정의
    }

    @Override
    public String toString() {	//Text를 반환
        return text;
    }

    Locale getLocale() {		//locale값 반환
        return locale;
    }
}
