import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

public class AvgWord {

    public static void main(String[] args) throws Exception {
        // check the length of args ,we nned only 2 inputs
        if (args.length != 2) {
            System.out.printf("Usage: AvgWordLength <input dir> <output dir>\n");
            System.exit(-1);
        }

        //create an instance of job
        Job job = new Job();

        //tell the job which jar file to choose by giving any class in that jar
        job.setJarByClass(AvgWord.class);

        //set the name of the job
        job.setJobName("Word Length");

        //give input file path
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        //give output file path
        FileOutputFormat.setOutputPath(job, new Path(args[1]));


        // set mapper class
        job.setMapperClass(LetterMap.class);
        //set reducer class
        job.setReducerClass(AvgReducer.class);

        //set mapper class output K,V datatypes
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //set reducer class output K,V datatypes
        job.setOutputKeyClass(Text.class);
        //as the o/p is average we are giving it double
        job.setOutputValueClass(DoubleWritable.class);

        //lets start exec and the main thread waits here till we get result from waitForCompletion
        boolean success = job.waitForCompletion(true);
        //if true 0 else 1
        System.exit(success ? 0 : 1);
    }
}