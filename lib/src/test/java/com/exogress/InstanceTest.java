// lib/src/test/java/com/exogress/InstanceTest.java
package com.exogress;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import org.junit.Test;
import static org.junit.Assert.*;
import com.exogress.Instance;

public class InstanceTest {
    @Test public void testBuilder() throws Exception {
        Instance instance = new InstanceBuilder(
                UlidCreator.getUlid(),
                "secret",
                "account",
                "project")
                .label("label1", "val1")
                .label("label2", "val2")
                .watchConfig(true)
                .profile("my-profile")
                .configPath("./Exofile.yml")
                .build();
    }
}
