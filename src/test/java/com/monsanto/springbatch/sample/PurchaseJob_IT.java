package com.monsanto.springbatch.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.AssertFile;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: Rasesh Desai
 * Date: 6/21/13
 * Time: 12:31 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:job-config.xml", "classpath:batch-config-test.xml", "classpath:jdbc-repository-test.xml", "classpath:jdbc-repository-common.xml"})
public class PurchaseJob_IT {

    @Resource
    private JobLauncherTestUtils jobLauncherTestUtilsForPurchaseReportBatchJob;

    @Test
    public void testPurchaseReportJobExecutesSuccessfully_AndGeneratedSavingsReport() throws Exception {

        jobLauncherTestUtilsForPurchaseReportBatchJob.launchJob();

        String expectedFile = "src/test/resources/EXPECTED_SAVING_REPORT.txt";
        String actualFile = "C:\\SPRING_BATCH_SAMPLE\\SAVING_REPORT.txt";
        AssertFile.assertFileEquals(new FileSystemResource(expectedFile), new FileSystemResource(actualFile));
    }
}
