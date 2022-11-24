package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue<>();
    }

    @Test
    public void assess_enqueue_when_it_adds_one_element() {
        queue.enqueue("algo");

        assertEquals("algo", queue.front());
    }

    @Test
    public void assess_enqueue_when_it_adds_two_elements() {
        queue.enqueue("algo1");
        queue.enqueue("algo2");


        assertEquals(2, queue.size());
    }

    @Test
    public void assess_enqueue_when_it_adds_three_elements() {
        queue.enqueue("algo1");
        queue.enqueue("algo2");
        queue.enqueue("algo3");


        assertEquals(3, queue.size());
    }

    @Test
    public void assess_dequeue_when_it_drops_one_element_the_first_should_be_the_fact_that_before_was_the_second() {
        queue.enqueue("algo1");
        queue.enqueue("algo2");
        queue.enqueue("algo3");

        queue.dequeue();

        assertEquals("algo2", queue.dequeue());
    }

    @Test
    public void assess_dequeue_when_there_are_three_elements_and_it_drops_one_element() {
        queue.enqueue("algo1");
        queue.enqueue("algo2");
        queue.enqueue("algo3");

        queue.dequeue();

        assertEquals(2, queue.size());
    }

    @Test
    public void assess_dequeue_when_there_are_three_elements_and_it_drops_two_elements() {
        queue.enqueue("algo1");
        queue.enqueue("algo2");
        queue.enqueue("algo3");

        queue.dequeue();
        queue.dequeue();

        assertEquals(1, queue.size());
    }

    @Test
    public void assess_front_when_only_add_some_elements() {
        queue.enqueue("algo1");
        queue.enqueue("algo2");
        queue.enqueue("algo3");

        assertEquals("algo1", queue.front());
    }

    @Test
    public void assess_front_when_add_some_elements_and_drop_one_element() {
        queue.enqueue("algo1");
        queue.enqueue("algo2");
        queue.enqueue("algo3");

        queue.dequeue();

        assertEquals("algo2", queue.front());
    }

    @Test
    public void assess_front_when_add_some_elements_and_drop_two_elements() {
        queue.enqueue("algo1");
        queue.enqueue("algo2");
        queue.enqueue("algo3");

        queue.dequeue();
        queue.dequeue();

        assertEquals("algo3", queue.front());
    }

    @Test
    public void assess_isEmpty_when_it_is_empty() {
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void assess_isEmpty_when_it_is_not_empty() {
        queue.enqueue("Algo");

        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void assess_isEmpty_when_drop_the_unique_element() {
        queue.enqueue("Algo");
        queue.dequeue();

        assertEquals(true, queue.isEmpty());
    }
}