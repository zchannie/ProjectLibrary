
/****************2017/05/08  *************************/
//新增train_course_city_relation 课程-城市关系表
CREATE TABLE `train_course_city_relation` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`courseId`  int(11) NOT NULL DEFAULT 0 COMMENT '课程ID' ,
`cityId`  int(11) NOT NULL DEFAULT 0 COMMENT '城市id' ,
`status`  int(11) NOT NULL DEFAULT 1 COMMENT '状态： 0无效 1有效' ,
PRIMARY KEY (`id`)
)
