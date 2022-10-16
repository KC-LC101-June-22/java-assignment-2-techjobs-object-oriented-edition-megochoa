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
        Job jobCartoon = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

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
        Job firstJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(firstJob.equals(secondJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobCartoon = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actual = jobCartoon.toString();
        assertEquals(actual.charAt(0), '\n');
        assertEquals(actual.charAt(actual.length() - 1 ), '\n');


    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobCartoon = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actual = jobCartoon.toString();
        String expected =  "\nID: " + jobCartoon.getId() +
                "\nName: " + "Product tester" +
                "\nEmployer: " + "ACME" +
                "\nLocation: " + "Desert" +
                "\nPosition Type: " + "Quality control" +
                "\nCore Competency: " +"Persistence" + "\n";
        assertEquals(expected, actual);
    }

    @Test
    public  void testToStringHandlesEmptyField(){
        Job jobEmpty = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        String noData = "Data not available";
        String blankActual = jobEmpty.toString();
        String blankExpected ="\nID: " + jobEmpty.getId() +
                "\nName: " + noData +
                "\nEmployer: " + noData +
                "\nLocation: " + noData +
                "\nPosition Type: " + noData +
                "\nCore Competency: " + noData + "\n";

        assertEquals(blankExpected, blankActual);
    }


}
