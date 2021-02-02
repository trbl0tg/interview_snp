package com.shvydkov;

import com.shvydkov.deserializer.OfficeEntityDeserializer;
import com.shvydkov.service.OfficeJoiningService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class Test {

    private ByteArrayOutputStream out;

    @Before
    public void init() {
        out = new ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
    }

    @org.junit.Test
    public void successOnCorrectInputIntegrationTest() throws IOException {
        OfficeJoiningService.performJoin();
        String expected = TestUtils.readFileContent("expected.txt");
        Assert.assertEquals(expected, out.toString());
    }

}
