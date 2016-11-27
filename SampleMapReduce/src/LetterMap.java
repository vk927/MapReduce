
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// create mapper class from parent mapper and give i/ps K,V and o/p K,v
public class LetterMap extends Mapper<LongWritable, Text, Text, IntWritable> {

    //Now override the map() of parent class, give i/p K,V and context as params
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // convert the text obj into string
        String line = value.toString();

        //split the line into words when u have a non alpha chars in line
        //and loop through the array of words
        for (String word : line.split("\\W+")) {
            // if word length is > 0 then only it is a word
            if (word.length() > 0) {
                //get the 1st letter of the word using substring
                String let = word.substring(0, 1);

                // write 1st letter as key & length of word as value
                context.write(new Text(let), new IntWritable(word.length()));
            }
        }
    }
}