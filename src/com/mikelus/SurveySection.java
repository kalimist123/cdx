package com.mikelus;

import java.util.ArrayList;
import java.util.List;

public class SurveySection
{
    public int SectionIndex;
    public String SectionName;

    public SurveySection(int sectionIndex, String sectionName, String biomarker, String disease, List<Integer> questionIds) {
        SectionIndex = sectionIndex;
        SectionName = sectionName;
        Biomarker = biomarker;
        Disease = disease;
        QuestionIds = questionIds;
    }

    public String getBiomarker() {
        return Biomarker;
    }

    public void setBiomarker(String biomarker) {
        Biomarker = biomarker;
    }

    public String Biomarker ;
    public String Disease ;
    public List<Integer> QuestionIds;

    public int getSectionIndex() {
        return SectionIndex;
    }

    public void setSectionIndex(int sectionIndex) {
        SectionIndex = sectionIndex;
    }

    public SurveySection()
    {
        QuestionIds = new ArrayList<Integer>();

    }
}
