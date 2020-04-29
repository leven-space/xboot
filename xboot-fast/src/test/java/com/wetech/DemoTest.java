package com.wetech;

import cn.hutool.core.util.RandomUtil;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author leven.chen
 */
public class DemoTest {

    /**
     * mock 一个普通方法
     */
    @Test
    public void mock_method(){
        List list = mock(List.class);
        when(list.add(anyString())).thenReturn(false);
        boolean added = list.add(RandomUtil.randomString(6));
        assertThat(added,is(false));
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void mock_method_with_name(){
        List list = mock(List.class,"myList");
        when(list.add(anyString())).thenReturn(false);
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(containsString("some exception"));
        verify(list, times(2)).add(anyString());
    }


}
