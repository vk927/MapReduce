# MapReduce

3 stages in map reduce

1) mapper -- run on hdfs block ,each map runs on node where block is located
2) shuffle and sort -- sorts and consolidates immediate data from all mappers
3) reducer -- operates on shuffle and sorted intermediate data

reducer can start prior to mapper finish but can't process data till the completion of mapper

mapper flow
3 blocks of file running on diff nodes on cluster

each node will run record reader which writes block of file to  corresponding mapper

files is written in form of K,V
where K might be offset of byte in memory

mapper conatins bussines logic
lets call mapper output as records
mappers write data out to partioner - partioner decide to send data to which reducer

shuffle and sort phase transforms records to respective reducers

reducer applies osme logic
reducers o/p to file
so if 3 reducers then o/p contains 3 files

