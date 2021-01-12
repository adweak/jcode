package com.adweak.reference.quartz.constants;

/**
 * @author : xuzhaole
 * @date : 2020/12/1
 */

public class CommonConstants {

    //Job Group  建议使用服务名
    public final static String GROUP_KEY_KEY = "WM-MOBILE-SVC";
    //Trigger Group  建议使用表明
    public final static String GROUP_KEY = "G_BOOK_RECORD";
    // 调度器名称，用于集群中区别不同调度器
    public final static String SCHEDULER_NAME = "demoSchedulerFactory";
    // 调度器 bean名称
    public final static String BEAN_NAME = "demoSchedulerFactoryBean";
}
