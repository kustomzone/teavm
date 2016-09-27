/*
 *  Copyright 2016 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.jsinterop;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.teavm.jso.JSBody;
import org.teavm.junit.SkipJVM;
import org.teavm.junit.TeaVMTestRunner;

@RunWith(TeaVMTestRunner.class)
@SkipJVM
public class ClassExportTest {
    @Test
    public void simple() {
        new Foo().bar();
        assertEquals(23, testFoo());
    }

    @JSBody(params = {}, script = ""
            + "var Foo = org.teavm.jsinterop.Foo;"
            + "var instance = new Foo();"
            + "return instance.bar();")
    private static native int testFoo();
}
