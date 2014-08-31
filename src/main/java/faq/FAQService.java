package faq;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("faqService")
@SessionScoped
public class FAQService implements Serializable{
	
	private String questionText = "How to run eclipse?";
	private String answerText = "Double-click its icon.";
	private boolean isShowingAnswer = false;
	
	public String getQuestionText(){
		return questionText;
	}
	
	public String getAnswerText(){
		return answerText;
	}
	
	public String trigger(){
		isShowingAnswer = !isShowingAnswer;
		return null;
	}
	
	public boolean isShowingAnswer(){
		return isShowingAnswer;
	}
}
