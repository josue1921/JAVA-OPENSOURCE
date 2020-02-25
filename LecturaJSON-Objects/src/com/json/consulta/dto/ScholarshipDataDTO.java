package com.json.consulta.dto;

import java.util.List;
import com.json.consulta.dao.Scholarship;

public class ScholarshipDataDTO {
	
	private List<Scholarship> student;
	private String reasonId;
	private String reasonAdditionalInformation;
	private String reasonSubreasonId;
	private String documentId;
	private String businessAgentId;
	
	
	public List<Scholarship> getStudent() {
		return student;
	}
	public void setStudent(List<Scholarship> student) {
		this.student = student;
	}
	public String getReasonId() {
		return reasonId;
	}
	public void setReasonId(String reasonId) {
		this.reasonId = reasonId;
	}
	public String getReasonAdditionalInformation() {
		return reasonAdditionalInformation;
	}
	public void setReasonAdditionalInformation(String reasonAdditionalInformation) {
		this.reasonAdditionalInformation = reasonAdditionalInformation;
	}
	public String getReasonSubreasonId() {
		return reasonSubreasonId;
	}
	public void setReasonSubreasonId(String reasonSubreasonId) {
		this.reasonSubreasonId = reasonSubreasonId;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getBusinessAgentId() {
		return businessAgentId;
	}
	public void setBusinessAgentId(String businessAgentId) {
		this.businessAgentId = businessAgentId;
	}
}
