package com.mikelus;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Survey
{
    public String ProjectCode;
    public String FormUrl ;

    public Survey(String projectCode, String formUrl, String start_Period, String end_Period, String labId_In_UserName, String active, List<SurveySection> surveySections) {
        ProjectCode = projectCode;
        FormUrl = formUrl;
        Start_Period = start_Period;
        End_Period = end_Period;
        LabId_In_UserName = labId_In_UserName;
        Active = active;
        SurveySections = surveySections;
    }

    public String getFormUrl() {
        return FormUrl;
    }

    public void setFormUrl(String formUrl) {
        FormUrl = formUrl;
    }

    public String getStart_Period() {
        return Start_Period;
    }

    public void setStart_Period(String start_Period) {
        Start_Period = start_Period;
    }

    public String getEnd_Period() {
        return End_Period;
    }

    public void setEnd_Period(String end_Period) {
        End_Period = end_Period;
    }

    public String getLabId_In_UserName() {
        return LabId_In_UserName;
    }

    public void setLabId_In_UserName(String labId_In_UserName) {
        LabId_In_UserName = labId_In_UserName;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String active) {
        Active = active;
    }

    public List<SurveySection> getSurveySections() {
        return SurveySections;
    }

    public void setSurveySections(List<SurveySection> surveySections) {
        SurveySections = surveySections;
    }

    public String Start_Period ;
    public String End_Period ;
    public String LabId_In_UserName ;
    public String Active ;
    public List<SurveySection> SurveySections;

    public Survey()
    {
        SurveySections = new ArrayList<SurveySection>();
    }

    public String getProjectCode() {
        return ProjectCode;
    }

    public void setProjectCode(String projectCode) {
        ProjectCode = projectCode;
    }
}

