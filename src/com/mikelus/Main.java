package com.mikelus;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws Exception {

        Survey survey = new Survey();
        survey.Active="True";
        survey.End_Period="01/01/2001";
        survey.Start_Period="01/01/2001";
        survey.FormUrl="http://www.meh.com";
        survey.ProjectCode="123";
        survey.LabId_In_UserName="True";
        survey.SurveySections = new ArrayList<SurveySection>();


        SurveySection surveySection =new SurveySection();
        surveySection.Biomarker="AML";
        surveySection.Disease="Lung Cancer";
        surveySection.SectionIndex=3;
        surveySection.QuestionIds= new ArrayList<Integer>();
        surveySection.QuestionIds.add(1);
        surveySection.QuestionIds.add(2);
        survey.SurveySections.add(surveySection);


        jaxbObjectToXML(survey);

        jaxbXmlFileToObject("E:\\survey1.xml");

        URL url = new URL("https://fs27.formsite.com/api/users/Diaceutics/forms/0m93ilhzv5/results?fs_api_key=kyVbVDxg0uFR&amp;fs_include_headings");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.addRequestProperty("User-Agent", "Mozilla/4.76");
        InputStream is = http.getInputStream();



        JAXBContext context = JAXBContext.newInstance(FsResponse.class, ObjectFactory.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
       // Object obj = unmarshaller.unmarshal(reader);
        Object obj = unmarshaller.unmarshal(is);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, System.out);

    }

    private static void jaxbObjectToXML(Survey survey) throws Exception
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Survey.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(survey, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println( xmlContent );


            java.io.FileWriter fw = new java.io.FileWriter("e:\\survey1.xml");
            fw.write(xmlContent);
            fw.close();



        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private static void jaxbXmlFileToObject(String fileName) {

        File xmlFile = new File(fileName);

        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Survey.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Survey survey = (Survey) jaxbUnmarshaller.unmarshal(xmlFile);

            System.out.println(survey);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }


}
