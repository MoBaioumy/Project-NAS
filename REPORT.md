# Final Report

Zaker is an educational app that enhances testing and tutoring. It allows the teacher to create quizzes and questions by simply taking a picture, add or delete questions and post it for the students. The student quizzes get generated automatically and grades are saved. Both students and teacher can view their progress with proper graphs. Finally, chatting is allowed within the community pages.



![](https://github.com/artix15/Project-NAS/blob/master/Doc/TeacherOverviewLand.png?raw=true)



## Overview



First, let's look at the teacher and how a quiz is created.

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutTeacher.PNG?raw=true)



A teacher has access to a QuizList, which contains quizzes loaded from the adapter. After clicking on an element (a quiz), you move on to the wordsList it contains. So every quiz has words within it, and that is loaded in the List view using an adapter as well. 

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutQuizWithWordsPNG.PNG?raw=true)

The data it self is all loaded from a database. 

After a quiz is created, a student can access it. The difference between the teachers and student are: Only a teacher can add a quiz, delete a quiz, add words and delete words. A student can solve the question within the quiz and get a grade. Those grades are saved and used in visualization. 

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutProgress.PNG?raw=true)

Note that, a student gets a bar chart for all his quizzes; however, a teacher get a line chart. This makes it easier for the teacher to see different students. 



Finally, within the community Activities, a teacher and a student can have a live chat. Both messages within a chat room are send to Firebase and communicated in Real-time on different devices.

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutChat.PNG?raw=true)



Finally, the database. It consists of 3 table: WORDS, QUIZZES and RESULTS. They are all linked by the Quiz_ID as illustrated in the figure below.

![](https://github.com/artix15/Project-NAS/blob/master/Doc/LayoutDB.PNG?raw=true)



A UML overview of the important activities is provided below.

![](https://github.com/artix15/Project-NAS/blob/master/Doc/UML.jpg?raw=true)





## Main challenges and changes

At the start, I created prototypes using [Adobe XD](https://www.adobe.com/products/xd/ui-design-kits.html). The first two look like [1](https://www.youtube.com/watch?v=p5YkaQjKWw0&feature=youtu.be), [2](https://www.youtube.com/watch?v=dPi2C28WYpQ&feature=youtu.be&fbclid=IwAR1snFk3T4RJoFFlXDoGs7b4SqR7w5wlb-OdB_xoOOzI8z6aajFOlQEQEVU). After this I decided to change the design based on feedback from 6 users which stated that it doesn't suit an educational app but more a vacation app. Additionally, to simplify the app: **only one student and one teacher are created**. This is reasonable since the focus becomes on the core functionality and allowing more users is easily fixed by creating *Teacher*, or *Student* objects and authentication. 



For creating graphs, I used both **[MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)** and [GraphView](https://github.com/jjoe64/GraphView) with Student and Teacher progress respectively. After trying out both libraries, the first is a better choice for me since it has more capabilities, better documentation and is easy to use. 



Regarding the quizzes, I decided to only create one type: True/False questions for memorizing words. You simply enter words lists and you are tested on it. Since you only store 2 Strings and no Booleans for the right answer, it's simple to start with. Future work could include MCQ and more types. 



The database is modelled using three tables. Since these tables are connected (via the quiz ID), the previously proposed method didn't work. Additionally, extra functions like quiz start date and end date were omitted.



To allow community functionality (like chatting), the standard API's aren't suitable. I used [Firebase](https://console.firebase.google.com/u/0/), since it has *real-time database* functionality. Regarding sharing quizzes across devices, Firebase is good option to use; however, due to time limitation, it has only been implemented as a local sqlite database.



Finally, the main idea behind this app is to allow a teacher to digitalize a quiz simply by taking a picture of it. Since most of the functions (image processing, OCR and Natural Language Processing) are out of the scope of this course, three sample quizzes have been hard-coded and used as buttons. 









 

