# MapReduce

MapReduce allows automatic //zation and distribution of work, so jobs run faster

3 stages in map reduce

1) mapper -- run on hdfs block ,each map runs on node where block is located

2) shuffle and sort -- sorts and consolidates immediate data from all mappers

3) reducer -- operates on shuffle and sorted intermediate data

Reducer can start prior to mapper finish but can't process data till the completion of mapper

Mapper Flow
- 3 blocks of file running on diff nodes on cluster
- each node will run record reader which writes block of file to  corresponding mapper

->files is written in form of K,V
->where K might be offset of byte in memory

mapper conatins bussines logic
  lets call mapper output as records
  mappers write data out to partioner - partioner decide to send data to which reducer

shuffle and sort phase transforms records to respective reducers

reducer applies some logic
  reducers o/p to file
  so if 3 reducers then o/p contains 3 files





map(in_key,in_value) -- o/p will be (out_key,out_value)

some mappers ignore i/p key mostly when key is offset byte

mappers can filter i/p

identity mapper which o/ps same as i/p

identity reducer which o/ps same as i/p

mapper must contain o/p in K,V form or no o/p should not be list or any other DS

reducer o/p should be one or more unique keys with a single associated value for each

shuffle and sort groups results of mapper by keys
