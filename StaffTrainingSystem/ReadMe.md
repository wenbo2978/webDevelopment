front-end: javascript
back-end: springboot + mybatis + MySQL database

show database:
+---------------------------------+
| Tables_in_staff_training_system |
+---------------------------------+
| task                            |
| taskchoice                      |
| taskessay                       |
| trainingrecord                  |
| trainingresult                  |
| user                            |
+---------------------------------+
table user:
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| userid    | int(11)     | NO   | PRI | NULL    | auto_increment |
| username  | varchar(45) | NO   | PRI | NULL    |                |
| password  | varchar(45) | YES  |     | NULL    |                |
| realname  | varchar(45) | YES  |     | NULL    |                |
| mark      | int(11)     | YES  |     | 0       |                |
| phone     | varchar(45) | YES  |     | NULL    |                |
| email     | varchar(45) | YES  |     | NULL    |                |
| picture   | varchar(45) | YES  |     | NULL    |                |
| authority | varchar(45) | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
table task:
+-------------+-------------+------+-----+---------+----------------+
| Field       | Type        | Null | Key | Default | Extra          |
+-------------+-------------+------+-----+---------+----------------+
| taskId      | int(11)     | NO   | PRI | NULL    | auto_increment |
| taskName    | varchar(45) | NO   |     | NULL    |                |
| scope       | varchar(45) | YES  |     | NULL    |                |
| begin_Time  | varchar(45) | YES  |     | NULL    |                |
| end_Time    | varchar(45) | YES  |     | NULL    |                |
| attachment  | varchar(45) | YES  |     | NULL    |                |
| authorId    | int(11)     | YES  |     | NULL    |                |
| isPublished | varchar(45) | YES  |     | NULL    |                |
| category    | varchar(45) | YES  |     | NULL    |                |
+-------------+-------------+------+-----+---------+----------------+
table taskchoice:
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| taskChoiceId  | int(11)     | NO   | PRI | NULL    | auto_increment |
| taskId        | int(11)     | YES  |     | NULL    |                |
| authorId      | int(11)     | YES  |     | NULL    |                |
| taskQ         | varchar(45) | YES  |     | NULL    |                |
| taskChoiceA   | varchar(45) | YES  |     | NULL    |                |
| taskChoiceB   | varchar(45) | YES  |     | NULL    |                |
| taskChoiceC   | varchar(45) | YES  |     | NULL    |                |
| taskChoiceD   | varchar(45) | YES  |     | NULL    |                |
| correctAnswer | varchar(45) | YES  |     | NULL    |                |
| answer        | varchar(45) | YES  |     | NULL    |                |
| isFinished    | varchar(45) | YES  |     | NULL    |                |
| isCorrect     | varchar(45) | YES  |     | NULL    |                |
| staffId       | int(11)     | YES  |     | NULL    |                |
+---------------+-------------+------+-----+---------+----------------+
table taskessay:
+-------------+-------------+------+-----+---------+----------------+
| Field       | Type        | Null | Key | Default | Extra          |
+-------------+-------------+------+-----+---------+----------------+
| taskEssayId | int(11)     | NO   | PRI | NULL    | auto_increment |
| taskId      | int(11)     | YES  |     | NULL    |                |
| authorId    | int(11)     | YES  |     | NULL    |                |
| staffId     | int(11)     | YES  |     | NULL    |                |
| taskQ       | varchar(45) | YES  |     | NULL    |                |
| answer      | varchar(45) | YES  |     | NULL    |                |
| isFinished  | varchar(45) | YES  |     | NULL    |                |
| score       | int(11)     | YES  |     | NULL    |                |
+-------------+-------------+------+-----+---------+----------------+
table trainingrecord:
+--------------------+-------------+------+-----+---------+----------------+
| Field              | Type        | Null | Key | Default | Extra          |
+--------------------+-------------+------+-----+---------+----------------+
| trainingRId        | int(11)     | NO   | PRI | NULL    | auto_increment |
| taskId             | int(11)     | YES  |     | NULL    |                |
| staffId            | int(11)     | YES  |     | NULL    |                |
| authorId           | int(11)     | YES  |     | NULL    |                |
| taskName           | varchar(45) | YES  |     | NULL    |                |
| staffName          | varchar(45) | YES  |     | NULL    |                |
| end_Time           | varchar(45) | YES  |     | NULL    |                |
| lastOperation_Time | varchar(45) | YES  |     | NULL    |                |
| process            | double      | YES  |     | NULL    |                |
| isFinished         | varchar(45) | YES  |     | NULL    |                |
| isEvaluated        | varchar(45) | YES  |     | NULL    |                |
| feedBack           | varchar(45) | YES  |     | NULL    |                |
+--------------------+-------------+------+-----+---------+----------------+
table trainingresult:
+-----------------+-------------+------+-----+---------+----------------+
| Field           | Type        | Null | Key | Default | Extra          |
+-----------------+-------------+------+-----+---------+----------------+
| trainingResId   | int(11)     | NO   | PRI | NULL    | auto_increment |
| taskId          | int(11)     | YES  |     | NULL    |                |
| taskName        | varchar(45) | YES  |     | NULL    |                |
| choiceScore     | int(11)     | YES  |     | NULL    |                |
| essayScore      | int(11)     | YES  |     | NULL    |                |
| authorId        | int(11)     | YES  |     | NULL    |                |
| staffId         | int(11)     | YES  |     | NULL    |                |
| staffName       | varchar(45) | YES  |     | NULL    |                |
| trainerFeedBack | varchar(45) | YES  |     | NULL    |                |
| staffAdvice     | varchar(45) | YES  |     | NULL    |                |
| staffFeedBack   | varchar(45) | YES  |     | NULL    |                |
| totalScore      | int(11)     | YES  |     | NULL    |                |
+-----------------+-------------+------+-----+---------+----------------+
