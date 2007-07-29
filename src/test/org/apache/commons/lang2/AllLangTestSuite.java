/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang2;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.apache.commons.lang2.builder.BuilderTestSuite;
import org.apache.commons.lang2.exception.ExceptionTestSuite;
import org.apache.commons.lang2.math.MathTestSuite;
import org.apache.commons.lang2.mutable.MutableTestSuite;
import org.apache.commons.lang2.text.TextTestSuite;
import org.apache.commons.lang2.time.TimeTestSuite;

/**
 * Test suite for [lang].
 *
 * @author Stephen Colebourne
 * @version $Id$
 */
public class AllLangTestSuite extends TestCase {
    
    /**
     * Construct a new instance.
     */
    public AllLangTestSuite(String name) {
        super(name);
    }

    /**
     * Command-line interface.
     */
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    /**
     * Get the suite of tests
     */
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.setName("Commons-Lang (all) Tests");
        suite.addTest(LangTestSuite.suite());
        suite.addTest(BuilderTestSuite.suite());
        suite.addTest(ExceptionTestSuite.suite());
        suite.addTest(MathTestSuite.suite());
        suite.addTest(MutableTestSuite.suite());
        suite.addTest(TextTestSuite.suite());
        suite.addTest(TimeTestSuite.suite());
        return suite;
    }
}