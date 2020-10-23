package lab2;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;




public class AirportApp {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: AirportApp3 <input path> <input path> <output path>");  //664600583_T_ONTIME_sample.csv
            System.exit(-1);
        }

        Job job = Job.getInstance();
        job.setJarByClass(AirportApp.class);
        job.setJobName("Airport");
        MultipleInputs.addInputPath(job, new Path(args[0]) , TextInputFormat.class , AirportMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]) , TextInputFormat.class , AirportNameMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));


        job.setPartitionerClass(AirportPartitioner.class);
        job.setReducerClass(AirportReducer.class);
        job.setGroupingComparatorClass(GroupComparator.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setMapOutputKeyClass(AirportWritableComparable.class);
        job.setMapOutputValueClass(Text.class);

        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
