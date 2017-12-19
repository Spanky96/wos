package top.spanky.common;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

public class LoggerAppender extends DailyRollingFileAppender {

    @Override
    public boolean isAsSevereAsThreshold(Priority priority){
        return this.getThreshold().equals(priority);
    }

}
