import static org.junit.Assert.*;

import org.junit.Test;


public class CommentTest {

	@Test
	public void commentStorageTest()
	{   
        Comment comment1 = new Comment("James Duckling", "This book is great. I learned all my Java from it.", 4);
        
        assertEquals(4, comment1.getRating());
        assertEquals("James Duckling", comment1.getAuthor());
	}
	
	@Test
	public void upvoteDownvoteTest() 
	{
		Comment comment1 = new Comment("Henry Higgins", "It is marvelous indeed", 5);
		
		comment1.upvote();
		assertEquals(1, comment1.getVoteCount());
		comment1.downvote();
		assertEquals(0, comment1.getVoteCount());
	}
}
