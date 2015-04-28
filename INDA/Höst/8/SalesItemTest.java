import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
	
	@Test
	public void addCommentTwiceTest()
	{
        SalesItem salesIte1 = new SalesItem("Java for complete Idiots", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I learned all my Java from it.", 4));
        assertEquals(false, salesIte1.addComment("James Duckling", "This book is great. I learned all my Java from it.", 4));
	}
	@Test
	public void negativeRatingTest()
	{
        SalesItem salesIte1 = new SalesItem("Java for complete Idiots", 21998);
        assertEquals(false, salesIte1.addComment("alice", "This book is great. I learned all my Java from it.", 0));
        assertEquals(false, salesIte1.addComment("bob", "This book is great. I learned all my Java from it.", 6));	
	}
	
	
	
	@Test
	public void mostUseFulCommentTest() 
	{
        SalesItem salesIte1 = new SalesItem("Java for complete Idiots", 21998);
        
        assertEquals(true, salesIte1.addComment("name", "This book is great", 4));
        assertEquals(true, salesIte1.addComment("name2", "Too simple!", 2));
        assertEquals(true, salesIte1.addComment("name3", "Why don't people switch to mono instead?", 1));
        assertEquals(true, salesIte1.addComment("name4", "Really pedagogical. I recommend this book to freshman", 5));
        
        salesIte1.upvoteComment(3);
        salesIte1.upvoteComment(3);
        salesIte1.upvoteComment(3);
        salesIte1.upvoteComment(1);
        salesIte1.upvoteComment(0);
        salesIte1.downvoteComment(2);
        
        assertEquals("name4", salesIte1.findMostHelpfulComment().getAuthor());
        
     }
	
	
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Java for complete Idiots", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I learned all my Java from it.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
}


