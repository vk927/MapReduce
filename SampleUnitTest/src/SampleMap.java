import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//sample word mapper
public class SampleMap extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //convert the value text obj to string
        //we only get single line as input
        String line = value.toString();
        //split the line into words of array and loop these words
        for (String word : line.split("\\W+")) {
            //check the length of word
            if (word.length() > 0) {
                //save the o/p as K word, V 1
                context.write(new Text(word), new IntWritable(1));
            }
        }
    }
}