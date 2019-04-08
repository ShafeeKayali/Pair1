/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddedmediaplayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author comqsjb
 */
public class ClipTest {
    
    private Clip instanceClip1 = new Clip(); // creating new clip for the class
    private Clip instanceClip2 = new Clip(); // creating another new clip for the class
    
    public ClipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        int initialStartTime = 10, initialEndTime = 50, initialMax = 100;
        String initialTitle = "Title";
        instanceClip1.setStart(initialStartTime); // Set the initial start time for the sub-clip at 10 to used in the class
        instanceClip1.setEnd(initialEndTime); // Set the initial end time for the sub-clip at 50 to used in the class
        instanceClip1.setTitle(initialTitle); // Set the initial Title for the sub-clip as Title to used in the class
        instanceClip1.setMax(initialMax); // Set the initial Max for the sub-clip at 100 to used in the class
        instanceClip2.setStart(initialStartTime); // Set the initial start time for the second sub-clip at 10 to used in the class
        instanceClip2.setEnd(initialEndTime); // Set the initial end time for the secondsub-clip at 50 to used in the class
        instanceClip2.setTitle(initialTitle); // Set the initial Title for the second sub-clip as Title to used in the class
        instanceClip2.setMax(initialMax); // Set the initial Max for the second sub-clip at 100 to used in the class
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Clip.
     */
    @Test
    public void testSetTitleToEmptyStringKeepsPreviousValue()
    {
        System.out.println("Set the title to empty string (Keeps previous value)");
        boolean emptyStringFlag = false, nullStringFlag = false;
        
        // Take the title before modified and try to change the name with empty String.
        String titleBeforeModified = instanceClip1.getTitle(); //Get the real name of the sub-clip before made any changes.
        instanceClip1.setTitle("");  // set the title as empty string
        String realTitleAftermodified = instanceClip1.getTitle(); //Get the real name of the sub-clip after made changes.
        if (titleBeforeModified.equals(realTitleAftermodified))
            emptyStringFlag = true;
        
        // Take the title before modified and try to change the name with null String.
        titleBeforeModified = instanceClip1.getTitle(); //Get the real name of the sub-clip before made any changes.
        instanceClip1.setTitle(null); //// set the title as null
        realTitleAftermodified = instanceClip1.getTitle(); //Get the real name of the sub-clip after made changes.
        if (titleBeforeModified.equals(realTitleAftermodified))
            nullStringFlag = true;
        
        assertEquals(true,emptyStringFlag&&nullStringFlag);
    }

    @Test
    public void testSetEndBeforeStartKeepsPreviousValue()
    {
    }

    @Test
    public void testEqualsOnEqualClips() 
    {
    }
    
    @Test
    public void testEqualsOnNonEqualClips() 
    {
    }
    
    @Test
    public void testSetEndToNegativeNumberKeepsPreviousValue() 
    {
    }
    
    @Test
    public void testSetStartToValidPositiveNumber() 
    {    
    }
    
    
    
}
