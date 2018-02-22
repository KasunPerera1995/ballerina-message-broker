/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package io.ballerina.messaging.broker.integration.standalone.cli;

import io.ballerina.messaging.broker.client.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.ballerina.messaging.broker.integration.util.TestConstants.CLI_ROOT_COMMAND;

/**
 * Test class containing tests of 'root' command.
 */
public class RootCmdTest extends CliTestParent {

    @Test(description = "test command '--help'",
          groups = "StreamReading")
    public void testRootCmdHelp() {
        String[] cmd = { CLI_ROOT_COMMAND, "--help" };
        String expectedLog = "Welcome to Broker Command Line Interface";
        String errorMessage = "error when executing root '--help' command";

        Main.main(cmd);

        Assert.assertTrue(PrintStreamHandler.readErrStream().contains(expectedLog), errorMessage);
    }

}