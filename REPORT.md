# Final Report

Zaker is an educational app that enhances testing and tutoring. It allows the teacher to create quizzes and questions by simply taking a picture, add or delete questions and post it for the students. The student quizzes get generated automatically and grades are saved. Both students and teacher can view their progress with proper graphs.



![](https://github.com/artix15/Project-NAS/blob/master/Doc/TeacherOverviewLand.png?raw=true)



## Overview



First, let's look at the teacher and how a quiz is created.

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutTeacher.PNG?raw=true)



A teacher has access to a QuizList, which contains quizzes loaded from the adapter. After clicking on an element (a quiz), you move on to the wordsList it contains. So every quiz has words within it, and that is loaded in the List view using an adapter as well. 

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutQuizWithWordsPNG.PNG?raw=true)

The data it self is all loaded in an SQL database. 

After a quiz is created, a student can access it. The difference between the teachers and student are: Only a teacher can add a quiz, delete a quiz, add words and delete words. A student can solve the question within the quiz and get a grade. Those grades are saved and used in visualization. 

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutProgress.PNG?raw=true)

Note that, a student gets a bar chart for all his quizzes; however, a teacher get a line chart. This makes it easier for the teacher to see different students. 



Finally, within the community Activities, teacher and student can have a live chat. Both message within a chat room are send to Firebase and communicated in Real-time on different devices.

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutChat.PNG?raw=true)



Finally, the database. It consists of 3 table: WORDS, QUIZZES and RESULTS. They are all linked by the Quiz_ID as illustrated in the table below.

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutDB.PNG?raw=true)



A UML overview of the important activities is provided below.

![](https://github.com/artix15/Project-NAS/blob/master/Doc/UML.jpg?raw=true)





