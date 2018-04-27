import com.yanghao.job.GoodMorningJob;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class TipJobDetailTest {

    @Test
    public void test() throws SchedulerException {
        //创建一个Schedualer
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //创建一个JobDetail
        JobBuilder jobBuilder = newJob(GoodMorningJob.class);
        String time = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(new Date());
        jobBuilder.usingJobData("时间",time);
        jobBuilder.usingJobData("地点","英国大不列颠");
        JobDetail jobDetail = jobBuilder.build();

        //创建一个触发器
        TriggerBuilder<Trigger> triggerTriggerBuilder = newTrigger();
        triggerTriggerBuilder.startNow(); //一旦有schedule就触发
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        simpleScheduleBuilder.withIntervalInSeconds(2);
        simpleScheduleBuilder.repeatForever();
        simpleScheduleBuilder.build();
        triggerTriggerBuilder.withSchedule(simpleScheduleBuilder);
        Trigger trigger = triggerTriggerBuilder.build();

        //当前Schedualer加入触发器和JobDetail
        scheduler.scheduleJob(jobDetail,trigger);

        //启动当前调度
        scheduler.start();

        //100秒后关闭调度
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.shutdown();

    }


}
