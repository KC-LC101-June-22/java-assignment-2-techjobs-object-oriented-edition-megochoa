package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.naming.Name;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertNotEquals(firstJob.getId(), secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job();
        Job jobCartoon = new Job(job.getId(),"Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobCartoon.getEmployer() instanceof Employer);
        assertTrue(jobCartoon.getLocation() instanceof Location);
        assertTrue(jobCartoon.getPositionType() instanceof PositionType);
        assertTrue(jobCartoon.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(jobCartoon.getName() instanceof String);

        assertEquals("Product tester", jobCartoon.getName());
        assertEquals(("ACME"), jobCartoon.getEmployer().getValue());
        assertEquals(("Desert"), jobCartoon.getLocation().getValue());
        assertEquals(("Quality control"), jobCartoon.getPositionType().getValue());
        assertEquals(("Persistence"), jobCartoon.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job firstJob = new Job(2,"Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job secondJob = new Job(1,"Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(firstJob.getId(), secondJob.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobCartoon = new Job(3,"Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actual = "\nID: " + jobCartoon.getId() +
                "\nName: " + jobCartoon.getName() +
                "\nEmployer: " + jobCartoon.getEmployer().getValue() +
                "\nLocation: " + jobCartoon.getLocation().getValue() +
                "\nPosition Type: " + jobCartoon.getPositionType().getValue() +
                "\nCore Competency: " + jobCartoon.getCoreCompetency().getValue() + "\n";
        String expected =  "\nID: " + 3 +
                "\nName: " + "Product tester" +
                "\nEmployer: " + "ACME" +
                "\nLocation: " + "Desert" +
                "\nPosition Type: " + "Quality control" +
                "\nCore Competency: " +"Persistence" + "\n";
        assertTrue(actual.charAt(0) == '\n');
        assertTrue(actual.charAt(actual.length() - 1 ) == '\n');



//        //tests that it's in the correct format
//
//



//        Job jobEmptyFields = new Job();
//                    String unavailableActual = jobEmptyFields.getName();
//                    String unavailableExpected = "OOPS! This job does not seem to exist.";
//        assertEquals(unavailableExpected, unavailableActual);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobCartoon = new Job(3,"Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actual = jobCartoon.toString();
        String expected =  "\nID: " + 3 +
                "\nName: " + "Product tester" +
                "\nEmployer: " + "ACME" +
                "\nLocation: " + "Desert" +
                "\nPosition Type: " + "Quality control" +
                "\nCore Competency: " +"Persistence" + "\n";
        assertEquals(expected, actual);
    }

    @Test
    public  void testToStringHandlesEmptyField(){
        Job jobEmpty = new Job(3,"", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        String noData = "Data not available";
        String blankActual = jobEmpty.toString();
        String blankExpected ="\nID: " + 3 +
                "\nName: " + noData +
                "\nEmployer: " + noData +
                "\nLocation: " + noData +
                "\nPosition Type: " + noData +
                "\nCore Competency: " + noData + "\n";

        assertEquals(blankExpected, blankActual);
    }


}
