学习笔记

GC算法
=========
1、操作环境
--
	java version "1.8.0_241"Java(TM) Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)
    CPU i7-7700HQ 4核
	16G内存
2、操作数据
--
	1、默认GC UseParallelGC 并行GC
	-Xmx128M -Xms128m     堆溢出
	-Xmx256M -Xms256m     堆溢出
	-Xmx512M -Xms512m    【9186】
	-Xmx1G  -Xms1Gm      【14308】
	-Xmx2G   -Xms2G      【14649】
	-Xmx4G   -Xms4G      【15127】

	2、-XX:+UseSerialGC 串行GC
	-Xmx128M -Xms128m    【堆溢出】
	-Xmx256M -Xms256m    【4769】
	-Xmx512M -Xms512m    【10488】
	-Xmx1G -Xms1G        【13731】
	-Xmx2G -Xms2G        【12576】
	-Xmx4G -Xms4G        【9865】

	3、-XX:+UseConcMarkSweepGC 标记清除CMS
	-Xmx128M -Xms128m    【堆溢出】
	-Xmx256M -Xms256m    【4495】
	-Xmx512M -Xms512m    【10537】
	-Xmx1G -Xms1G        【13298】
	-Xmx2G -Xms2G        【13224】
	-Xmx4G -Xms4G        【12419】

	3、-XX:+UseG1GC 
	-Xmx128M -Xms128m    【堆溢出】
	-Xmx256M -Xms256m    【堆溢出】
	-Xmx512M -Xms512m    【11999】
	-Xmx1G -Xms1G        【14424】
	-Xmx2G -Xms2G        【16568】
	-Xmx4G -Xms4G        【16276】


3总结
--
	GC算法是非常成熟的技术，一般来说特别小的堆内存虽然回收较快，但极易发生内存溢出。而一般场景上特别大的内存也是没有必要的，因为会fullGC回收时间过长，造成较长的停顿。
	一般会权衡吞吐量与响应时间，4G-6G CMS可能占优势，而更大的内存G1可能会更好。
