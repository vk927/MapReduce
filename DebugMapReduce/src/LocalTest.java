/**
 * Created by Envy on 11/27/2016.
 */

/*

Hadoop run MR locally.

MR can be runned on local file system than HDFS this is called LocalJobRunner mode

add code to driver not to mapper or reducer
 */
public class LocalTestDriver{

    Configuration conf=new Confoguration();
    conf.set("mapred.job.tracker","local");
    conf.set("fs.default.name","file:///");  // file:/// doesn't give u locla file path , it says complier that we are going to use local file system

}


//or

//**  hadoop jar myjar.jar myDriver -fs=file:/// -jt=local indir outdir

//** hadoop jar xxx.jar xyxDriver -fs=file:/// -jt=local  inputFilepath outputfilepath