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
        System.out.println("Set the end time before start one (Keeps previous value)");
        boolean endBeforeStart = false, endEqualStart = false, endAtZero = false, endAtNull = false;
        // Try to set the end time before the start one.
        int endTimeBeforeModified = instanceClip1.getEnd(); //Get the real end time of the sub-clip before made any changes.
        instanceClip1.setEnd(instanceClip1.getStart()-5);
        int endTimeAfterModified = instanceClip1.getEnd(); //Get the real end time of the sub-clip after made changes.
        if (endTimeBeforeModified==endTimeAfterModified)
            endBeforeStart = true;
        
        // Try to set the end time equal to the start one.
        endTimeBeforeModified = instanceClip1.getEnd(); //Get the real end time of the sub-clip before made any changes.
        instanceClip1.setEnd(instanceClip1.getStart()); // Tty to set the end time equals to start one
        endTimeAfterModified = instanceClip1.getEnd(); //Get the real end time of the sub-clip after made changes.
        if (endTimeBeforeModified==endTimeAfterModified) return; // !!Should be modified in the program!!
        endEqualStart = true; // Can't bn the start and the end time the same % if (end<$=$start.get()) return; %
        
        // Try to set the end time equal to Zero.
        endTimeBeforeModified = instanceClip1.getEnd(); //Get the real end time of the sub-clip before made any changes.
        instanceClip1.setEnd(0); //Try to set end time to Zero
        endTimeAfterModified = instanceClip1.getEnd(); //Get the real end time of the sub-clip after made changes.
        if (endTimeBeforeModified==endTimeAfterModified) // it is not because zero it is because less than start point
            endAtZero = true;
        
        // Try to set the end time equal to Null.
        endTimeBeforeModified = instanceClip1.getEnd(); //Get the real end time of the sub-clip before made any changes.
        instanceClip1.setEnd(null); //Try to set end time to null
        endTimeAfterModified = instanceClip1.getEnd(); //Get the real end time of the sub-clip after made changes.
        if (endTimeBeforeModified==endTimeAfterModified)
            endAtNull = true;
        
        assertEquals(true,endBeforeStart&&endEqualStart&&endAtZero&&endAtNull);
    }

    @Test
    public void testEqualsOnEqualClips() 
    {
        boolean clipIsNull = false, ClipsAreSame = false;
        System.out.println("Check the Equals function is working on the equals clips)");
        
        // Check if the two clips already prapared by the same Start,End and title are the same with equal function 
        if (instanceClip1.equals(instanceClip2))
            ClipsAreSame = true;
        
        // Check if the clip with start,end and title values is equal with the new empty clip 
        Clip instanceClipEmpty = new Clip(); // creating another new clip
        instanceClipEmpty = null; // make this clip empty
        if (!instanceClip1.equals(instanceClipEmpty))
            clipIsNull = true;
        
        assertEquals(true,clipIsNull&&ClipsAreSame);
    }
    
    @Test
    public void testEqualsOnNonEqualClips() 
    {
        boolean ClipsAreNotTheSame = false;
        System.out.println("Check the Equals function is working on the NOT equals clips)");
        
        // Check if the clip already prapared are not the same with equals function 
        instanceClip2.setStart(5); // change the start time for the clip2 to 5
        instanceClip2.setEnd(25); // change the end time for the clip2 to 25
        instanceClip2.setTitle("changeValues"); // change the title for the clip2 to changeValues
        if (!instanceClip1.equals(instanceClip2)) /// if not equals
            ClipsAreNotTheSame = true;
        
        assertEquals(true,ClipsAreNotTheSame);
        
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
