hadoop-balancer
===============
Balances blocks on a single node with multiple disks.


# Compile
```
$ sbt clean; sbt package
```


# Usage
```
$ java -cp hadoop-balancer-assembly-0.1-SNAPSHOT.jar com.schmitztech.hadoop.DiskBalancerMain disk1 disk2 disk3
```

- disk path should be like `/disk1/dfs/dn/current/BP-75803259-10.58.99.37-1446001913715/current/finalized`


# How it works
This app move meta and data blocks between disks to balace data storage


# Monitoring
Appart of the standard `df -h` command to monitor disks fulling in, the disk bandwidths can be easily monitored using `iostat -x 1 -m`

```
$ iostat -x 1 -m
   Device:         rrqm/s   wrqm/s     r/s     w/s    rMB/s    wMB/s avgrq-sz avgqu-sz   await  svctm  %util
   sdd               0.00     0.00    0.00    0.00     0.00     0.00     0.00     0.00    0.00   0.00   0.00
   sde               0.00 32911.00    0.00  300.00     0.00   149.56  1020.99   138.72  469.81   3.34 100.00
   sdf               0.00    27.00  963.00   50.00   120.54     0.30   244.30     1.37    1.35   0.80  80.60
   sdg               0.00     0.00    0.00    0.00     0.00     0.00     0.00     0.00    0.00   0.00   0.00
   sdh               0.00     0.00  610.00    0.00    76.25     0.00   255.99     1.45    2.37   1.44  88.10
   sdi               0.00     0.00    0.00    0.00     0.00     0.00     0.00     0.00    0.00   0.00   0.00
```
