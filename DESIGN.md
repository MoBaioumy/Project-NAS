##For a video of the prototype [click here.](https://youtu.be/p5YkaQjKWw0)







## Libraries, tools & API's 

To visualize the results for the students [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) will be used.

For the translation activities, [Google Cloud Translation API](https://cloud.google.com/translate/docs/quickstart-client-libraries#client-libraries-usage-java) will be used. This can be easily used in Java or Python and is obviously properly supported and documented.

[Material Design](https://material.io/design/) will be probably used everywhere.

For word definitions in English, the [Oxford Dictionary API](https://developer.oxforddictionaries.com/) is used



**Additional parts**

Ultimately, I want a teacher to be able to create a quiz by simply taking a picture of the word list (or a set of Multiple Choice questions...etc.). However, this is out of the scope of this course so I am listing is as **additional**.

[OpenCV](https://opencv.org/) is used to for image processing.

**Optical Character Recognition (OCR)** is done using [Tesseract](https://github.com/tesseract-ocr/tesseract)

Natural Language Processing is done using [NLTK](https://www.nltk.org/)

[scikit-learn](https://scikit-learn.org/stable/) is used for analyzing text documents.



## Data Bases

I will be using one database with multiple tables for the dummy version .



**Table 1: Quizzes**

| QUIZ_ID | QUIZ_NAME    | QUIZ_TYPE | OPENING_TIME | CLOSING_TIME |
| ------- | ------------ | --------- | ------------ | ------------ |
| 1       | Unit 1 words | Binary    | 20/01/2019   | 23/01/2019   |
| 2       | Unit 1 words | MCQ       | 20/01/2019   | 23/01/2019   |
| 3       | Unit 2 words | MCQ       | 23/01/2019   | 26/01/2019   |



**Table 2: Students**

| STUDENT_ID | STUDENT_NAME | TOTAL_QUIZZES | AVERAGE_SCORE |
| ---------- | ------------ | ------------- | ------------- |
| 100        | Merlijn      | 13            | 8.4           |
| 102        | Josh         | 1             | 3.8           |
| 103        | Klemens      | 4             | 6.8           |

**Table 3: Student Scores Quiz**

I am not entirely sure which way I will implement this but probably one table for every quiz with STUDENT_ID and SCORE as columns.