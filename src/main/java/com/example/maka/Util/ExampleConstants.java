//snippet-keyword:[AWS SDK for Java v2]
//snippet-keyword:[Amazon Athena]

/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

//snippet-start:[athena.java2.ExampleConstants.complete]
//snippet-start:[athena.java.ExampleConstants.complete]
package com.example.maka.Util;

public class ExampleConstants {
    public static final int CLIENT_EXECUTION_TIMEOUT = 100000;
    public static final String ATHENA_OUTPUT_BUCKET = "s3://jackcodetest";
    public static final String ATHENA_SAMPLE_QUERY = "select * from mc_logs where branch = '1';";
    public static final long SLEEP_AMOUNT_IN_MS = 1000;
    public static final String ATHENA_DEFAULT_DATABASE = "demo";
}