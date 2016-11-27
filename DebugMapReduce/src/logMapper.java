/**
 * Created by Envy on 11/27/2016.
 */
public class logMapper implements Mapper {

    private static final Logger Log= Logger.getLogger(logMapper.class.getName());  // give i/p fully qyalified class name

    if (Log.isDebugEnabled()){
        Log.debug("acct info:",acct.getReport());
    }
}


// /etc/hoop/conf/log4j.properties


// example
// log4j.logger.org.apache.hadoop.mapred,jobTracker=WARN


// for globally =---  hadoop.root.log set this property


// or pgmlly  but not recommended // because od recompiling rebuilding jar files

// Log.setLevel(Level.WARN)  // where Log is obj we created earlier