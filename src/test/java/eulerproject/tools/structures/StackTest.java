package eulerproject.tools.structures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackTest
{
    @Test
    public void isEmpty() throws Exception
    {
        Stack<Integer> stack = new Stack<>();
        assertThat(stack.isEmpty()).isTrue();

        stack.push(3);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    public void testPush() throws Exception
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(4);

        assertThat(stack.peek()).isEqualTo(4);
    }

    @Test
    public void pop() throws Exception
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(4);

        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.peek()).isEqualTo(3);

        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isNull();
        assertThat(stack.pop()).isNull();
    }

    @Test
    public void peek() throws Exception
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(4);

        assertThat(stack.peek()).isEqualTo(4);
        assertThat(stack.peek()).isEqualTo(4);
        stack.pop();
        stack.pop();
        assertThat(stack.peek()).isNull();
        assertThat(stack.peek()).isNull();
    }

    @Test
    public void size() throws Exception
    {
        Stack<Integer> stack = new Stack<>();
        assertThat(stack.size()).isEqualTo(0);
        stack.push(3);
        assertThat(stack.size()).isEqualTo(1);
        stack.push(4);
        assertThat(stack.size()).isEqualTo(2);
        stack.pop();
        assertThat(stack.size()).isEqualTo(1);
    }
}