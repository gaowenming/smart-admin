package com.smart.admin.modules.schedule.plugin;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.quartz.plugins.history.LoggingJobHistoryPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smart.admin.core.security.SpringBeanContainer;
import com.smart.admin.modules.schedule.bean.JobRunHistory;
import com.smart.admin.modules.schedule.service.IJobRunHistoryService;

/**
 * 记录任务执行历史
 * @Description 
 * @author gaowenming
 */
public class SmartLoggingJobHistoryPlugin extends LoggingJobHistoryPlugin {

    private final static Logger logger = LoggerFactory.getLogger(SmartLoggingJobHistoryPlugin.class);

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        IJobRunHistoryService jobRunHistoryService = SpringBeanContainer.getBean("jobRunHistoryService");
        logger.debug("SmartLoggingJobHistoryPlugin executing...");
        super.jobWasExecuted(context, jobException);
        Trigger trigger = context.getTrigger();

        JobRunHistory jobRunHistory = new JobRunHistory();
        try {
            jobRunHistory.setNodeId(InetAddress.getLocalHost().toString());
        } catch (UnknownHostException e) {
            jobRunHistory.setNodeId("U/A");
        }
        jobRunHistory.setTriggerGroup(trigger.getKey().getGroup());
        jobRunHistory.setTriggerName(trigger.getKey().getName());
        jobRunHistory.setJobClass(context.getJobDetail().getJobClass().getName());
        jobRunHistory.setJobName(context.getJobDetail().getKey().getName());
        jobRunHistory.setJobGroup(context.getJobDetail().getKey().getGroup());
        jobRunHistory.setFireTime(new java.util.Date());
        jobRunHistory.setPreviousFireTime(trigger.getPreviousFireTime());
        jobRunHistory.setNextFireTime(trigger.getNextFireTime());
        jobRunHistory.setRefireCount(new Integer(context.getRefireCount()));
        if (jobException != null) {
            jobRunHistory.setExceptionFlag(Boolean.TRUE);
            jobRunHistory.setResult(jobException.getMessage());
            StringWriter strWriter = new StringWriter();
            PrintWriter writer = new PrintWriter(new BufferedWriter(strWriter));
            jobException.printStackTrace(writer);
            writer.flush();
            strWriter.flush();
            String exceptionStack = strWriter.getBuffer().toString();
            jobRunHistory.setExceptionStack(exceptionStack);
        } else {
            jobRunHistory.setExceptionFlag(Boolean.FALSE);
            if (context.getResult() == null) {
                jobRunHistory.setResult("SUCCESS");
            } else {
                String result = String.valueOf(context.getResult());
                jobRunHistory.setResult(result);
            }
        }
        try {
            jobRunHistoryService.save(jobRunHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
