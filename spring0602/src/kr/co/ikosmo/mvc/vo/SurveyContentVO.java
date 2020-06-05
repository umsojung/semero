package kr.co.ikosmo.mvc.vo;

public class SurveyContentVO {
	private int subcode, surveycnt;
	private String surveytitle;
	private String surveytype;
	

	public String getSurveytype() {
		return surveytype;
	}
	public void setSurveytype(String surveytype) {
		this.surveytype = surveytype;
	}
	public int getSubcode() {
		return subcode;
	}
	public void setSubcode(int subcode) {
		this.subcode = subcode;
	}
	public int getSurveycnt() {
		return surveycnt;
	}
	public void setSurveycnt(int surveycnt) {
		this.surveycnt = surveycnt;
	}
	public String getSurveytitle() {
		return surveytitle;
	}
	public void setSurveytitle(String surveytitle) {
		this.surveytitle = surveytitle;
	}
	
	
}
