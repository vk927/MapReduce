import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//create reducer class from parent reducer class
public class AvgReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {
    // override the reduce() of parent Reducer class
    @Override
    // give only i/p as params of method and make sure that we use iterable class generic type , use context
    public void reduce(Text key, Iterable<IntWritable> values, Context context)throws IOException, InterruptedException {
        //here we get only one key and its values collection as
        //use sum & count
        long sum = 0, count = 0;
        //iterate through values of single key
        for (IntWritable value : values) {
            //add those as a sum
            sum += value.get();
            count++;
        }
        if (count != 0) {
            //now count the avg
            double result = (double)sum / (double)count;
            // retun key as it is and values as result  of double datatype
            context.write(key, new DoubleWritable(result));
        }
    }
}