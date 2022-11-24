package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
    }

    @Test
    public void when_it_push_a_element_in_the_stack() {
        stack.push("algo");

        assertEquals("algo", stack.top());
    }

    @Test
    public void when_it_push_two_elements_in_the_stack() {
        stack.push("algo1");
        stack.push("algo2");

        assertEquals(2, stack.size());
    }

    @Test
    public void when_it_push_three_elements_in_the_stack() {
        stack.push("algo1");
        stack.push("algo2");
        stack.push("algo3");

        assertEquals(3, stack.size());
    }

    @Test
    public void when_it_pop_two_elements_of_the_stack() {
        stack.push("algo1");
        stack.push("algo2");
        stack.push("algo3");

        stack.pop();
        stack.pop();

        assertEquals(1, stack.size());
    }

    @Test
    public void when_it_pop_a_element_of_the_stack() {
        stack.push("algo1");
        stack.push("algo2");
        stack.push("algo3");

        stack.pop();


        assertEquals("algo2", stack.top());
    }

    @Test
    public void when_it_pop_three_elements_of_the_stack() {
        stack.push("algo1");
        stack.push("algo2");
        stack.push("algo3");

        stack.pop();
        stack.pop();
        stack.pop();

        assertEquals(0, stack.size());
    }

    @Test
    public void when_it_is_empty() {
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void when_it_is_not_empty() {

        stack.push("algo1");

        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void when_it_pop_the_unique_element_and_it_is_empty() {
        stack.push("algo1");

        stack.pop();

        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void when_it_adds_two_elements_and_the_top_is_the_last_added() {
        stack.push("algo1");
        stack.push("algo2");

        assertEquals("algo2", stack.top());
    }

    @Test
    public void when_it_adds_three_elements_and_the_top_is_the_last_added() {
        stack.push("algo1");
        stack.push("algo2");
        stack.push("algo3");

        assertEquals("algo3", stack.top());
    }

    @Test
    public void when_it_adds_one_elements_and_the_top_is_the_last_added() {
        stack.push("algo1");

        assertEquals("algo1", stack.top());
    }
}