package org.launchcode.techjobs.oo;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job employee1 = new Job();
        Job employee2 = new Job();
        assertNotEquals(employee1, employee2);
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1 instanceof Job);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String result = job1.toString();

        assertTrue(result.startsWith(System.lineSeparator()));
        assertTrue(result.endsWith(System.lineSeparator()));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
   Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       String result = job1.toString();
       String expected =
               System.lineSeparator() +
                       "ID: " + job1.getId() + System.lineSeparator() +
                       "Name: " + job1.getName() + System.lineSeparator() +
                       "Employer: " + job1.getEmployer().getValue() + System.lineSeparator() +
                       "Location: " + job1.getLocation().getValue() + System.lineSeparator() +
                       "Position Type: " + job1.getPositionType().getValue() + System.lineSeparator() +
                       "Core Competency: " + job1.getCoreCompetency().getValue() + System.lineSeparator() +
                       System.lineSeparator();

       assertEquals(expected, result);

   }

   @Test
    public void testToStringHandlesEmptyField () {
       Job job1 = new Job("Product tester", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       String result = job1.toString();
       String expected =
               System.lineSeparator() + "ID: " + job1.getId() + System.lineSeparator() +
                       "Name: " + (job1.getName().isEmpty() ? "Data not available" : job1.getName()) + System.lineSeparator() +
                       "Employer: " + (job1.getEmployer().getValue().isEmpty() ? "Data not available" : job1.getEmployer()) + System.lineSeparator() +
                       "Location: " + (job1.getLocation().getValue().isEmpty() ? "Data not available" : job1.getLocation()) + System.lineSeparator() +
                       "Position Type: " + (job1.getPositionType().getValue().isEmpty() ? "Data not available" : job1.getPositionType()) + System.lineSeparator() +
                       "Core Competency: " + (job1.getCoreCompetency().getValue().isEmpty() ? "Data not available" : job1.getCoreCompetency()) + System.lineSeparator() +
                       System.lineSeparator();

       assertEquals(expected, result);

   }

}
