package com.smart.admin.modules.schedule.bean;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 执行历史
 * @Description 
 * @author gaowenming
 */
public class JobRunHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    //Job名称
    private String jobName;

    //Job
    private String jobGroup;

    //Job类
    private String jobClass;

    //Trigger名称
    private String triggerName;

    //Trigger分组 
    private String triggerGroup;

    //异常标识
    private Boolean exceptionFlag = Boolean.FALSE;

    //执行结果
    private String result;

    //异常日志
    private String exceptionStack;

    //本次触发时间
    private Date fireTime;

    //value = 上次触发时间
    private Date previousFireTime;

    //下次触发时间
    private Date nextFireTime;

    //value = 触发次数
    private Integer refireCount;

    //触发节点标识
    private String nodeId;

    private transient Date startTime;

    private transient Date endTime;

    private transient Integer resultState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public Boolean getExceptionFlag() {
        return exceptionFlag;
    }

    public void setExceptionFlag(Boolean exceptionFlag) {
        this.exceptionFlag = exceptionFlag;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getExceptionStack() {
        return exceptionStack;
    }

    public void setExceptionStack(String exceptionStack) {
        this.exceptionStack = exceptionStack;
    }

    public Date getFireTime() {
        return fireTime;
    }

    public void setFireTime(Date fireTime) {
        this.fireTime = fireTime;
    }

    public Date getPreviousFireTime() {
        return previousFireTime;
    }

    public void setPreviousFireTime(Date previousFireTime) {
        this.previousFireTime = previousFireTime;
    }

    public Date getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Date nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public Integer getRefireCount() {
        return refireCount;
    }

    public void setRefireCount(Integer refireCount) {
        this.refireCount = refireCount;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getResultState() {
        return resultState;
    }

    public void setResultState(Integer resultState) {
        this.resultState = resultState;
    }

}